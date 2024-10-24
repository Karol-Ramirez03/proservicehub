package com.servimax.proservicehub.application.service.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

@Service
public class JwtService {

    @Value("${security.jwt.expiration-in-minutes}")
    private Long EXPIRATION_IN_MINUTES;

    @Value("${security.jwt.secret-key}")
    private String SECRET_KEY;

    public String generateToken(UserDetails user, Map<String, Object> extraClaims) {
            
            Date issuedAt = new Date(System.currentTimeMillis());
            //Fecha de emisión (issuedAt): Se establece el momento actual como la fecha de emisión del token.
            Date expiration = new Date( (EXPIRATION_IN_MINUTES * 60 * 1000) + issuedAt.getTime() );
            //: Se calcula la fecha de expiración añadiendo el tiempo definido en EXPIRATION_IN_MINUTES a la fecha de emisión.
            String jwt = Jwts.builder()
            //Se establece el tipo de token como "JWT".
            .header()
                .type("JWT")
                .and()
            .subject(user.getUsername())
            .issuedAt(issuedAt)
            // Define cuándo fue emitido y cuándo expira el token.
            .expiration(expiration)
            .claims(extraClaims)
            //Añade las "claims" adicionales que se pasan como parámetro.

            .signWith(generateKey(),Jwts.SIG.HS256)
            // .signWith(Jwts.SIG.HS256.key().build())
            //Firma el JWT con la clave secreta y el algoritmo HS256 (HMAC con SHA-256).
            .compact();
            

        return jwt;
    }
    private SecretKey generateKey() {
        byte[] passwordDecoded = Decoders.BASE64.decode(SECRET_KEY);
        //La clave secreta está codificada en Base64. Aquí se decodifica.
        System.out.println( new String(passwordDecoded) );
        // Esta función genera una clave SecretKey a partir de la clave decodificada 
        //y la prepara para ser utilizada en el algoritmo HMAC-SHA256.
        return Keys.hmacShaKeyFor(passwordDecoded);
    }

    public String extractUsername(String jwt) {
        return extractAllClaims(jwt).getSubject();
        //Extrae el "subject" (nombre de usuario) del JWT llamando al método extractAllClaims, 
        //que obtiene todas las claims del token.
    }

    private Claims extractAllClaims(String jwt) {
        return Jwts.parser().verifyWith( generateKey() ).build()
                .parseSignedClaims(jwt).getPayload();
        //Este método analiza y verifica el JWT utilizando la clave secreta generada en generateKey(). 
        //Devuelve todas las claims (información dentro del JWT).


        //CLAIMS
        //Un claim son piezas de información sobre un usuario que se encuentran empaquetadas y 
        //firmadas con un token de seguridad.
    }

    public String extractJwtFromRequest(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");//Bearer jwt
        if(!StringUtils.hasText(authorizationHeader) || !authorizationHeader.startsWith("Bearer ")){
            return null;
        }
        return authorizationHeader.split(" ")[1];
        /*
         * Este método extrae el JWT desde el encabezado de autorización de una solicitud HTTP.
         *   -Si el encabezado no contiene el formato correcto (Bearer <jwt>), retorna null.
         *   -Si es válido, extrae el token después de "Bearer ".
        */
    }

    public Date extractExpiration(String jwt) {
        return extractAllClaims(jwt).getExpiration();
        //Extrae la fecha de expiración de las claims del JWT utilizando el método extractAllClaims.
    }

}
