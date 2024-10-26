package com.servimax.proservicehub.infrastructure.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servimax.proservicehub.application.service.LoginServiceI;
import com.servimax.proservicehub.application.service.auth.AuthenticationService;
import com.servimax.proservicehub.application.service.auth.JwtService;
import com.servimax.proservicehub.domain.dto.auth.AuthenticationRequest;
import com.servimax.proservicehub.domain.dto.auth.AuthenticationResponse;
import com.servimax.proservicehub.domain.dto.auth.LogoutResponse;
import com.servimax.proservicehub.domain.entity.Login;
import com.servimax.proservicehub.domain.entity.segurity.JwtToken;
import com.servimax.proservicehub.infrastructure.repository.jwttoken.JwtTokenRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    // @GetMapping("/validate-token")
    // public ResponseEntity<Boolean> validate(@RequestParam String jwt){
    //     boolean isTokenValid = authenticationService.validateToken(jwt);
    //     return ResponseEntity.ok(isTokenValid);
    // }

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtService jwtUtil;

    @Autowired
    private LoginServiceI userService;

    @Autowired
    private JwtTokenRepository jwtRepository;

    private Map<String, Object> generateExtraClaims(Login user) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("role",user.getRol().getNombre());
        extraClaims.put("authorities",user.getAuthorities());

        return extraClaims;
        /*
         * Genera un mapa de claims adicionales que incluyen el rol y 
         * las autoridades del usuario. Estos claims adicionales 
         * pueden ser usados durante la generación del JWT para añadir más contexto.
        */
    }

    private void saveUserToken(Login user, String jwt){
        JwtToken token= new JwtToken();
        token.setToken(jwt);
        token.setLogin(user);
        token.setExpiration(jwtUtil.extractExpiration(jwt));
        token.setValid(true);

        jwtRepository.save(token);
        /*
         * Este método guarda el JWT generado en una entidad llamada JwtToken, 
         * la cual contiene información como el token, 
         * el usuario asociado, la fecha de expiración, 
         * y si el token es válido o no.
        */
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<AuthenticationResponse> refreshToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String jwt = authHeader.substring(7);
            
            // Validar el token
            if (!authenticationService.validateToken(jwt)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            // Obtener el usuario del token (puedes tener un método para extraer el username)
            String username = jwtUtil.extractUsername(jwt);
            
            Optional<Login> user = userService.findOneByUsername(username);
            UserDetails usuario=user.get();

            if(user.isPresent()){
                usuario=user.get();
            }
            // Generar un nuevo token
            String newToken = jwtUtil.generateToken(usuario, generateExtraClaims((Login) usuario));
            
            saveUserToken((Login) usuario, newToken);
            // Crear la respuesta
            AuthenticationResponse response = new AuthenticationResponse(newToken);
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.badRequest().build();
    }


    @GetMapping("/validate-token")
    public ResponseEntity<Boolean> validate(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String jwt = authHeader.substring(7);
            boolean isTokenValid = authenticationService.validateToken(jwt);
            return ResponseEntity.ok(isTokenValid);
        }
        
        //Si no hay un token válido en el header, retornamos 400 Bad Request
        return ResponseEntity.badRequest().build();
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody @Valid AuthenticationRequest authenticationRequest) {
        AuthenticationResponse rsp = authenticationService.login(authenticationRequest);
        return ResponseEntity.ok(rsp);
    }


    @PostMapping("/logout")
    public ResponseEntity<LogoutResponse> authenticate(HttpServletRequest request){
        authenticationService.logout(request);
        return ResponseEntity.ok(new LogoutResponse("La sesion se cerro exitosamente"));
    }
    
    @GetMapping("/profile")
    public ResponseEntity<Login> findMyProfile(){
        Login user = authenticationService.findLoggedInUser();
        return ResponseEntity.ok(user);
    }
}
