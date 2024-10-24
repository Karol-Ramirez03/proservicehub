package com.servimax.proservicehub.application.service.auth;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.servimax.proservicehub.application.service.LoginServiceI;
import com.servimax.proservicehub.domain.dto.RegisterUser;
import com.servimax.proservicehub.domain.dto.UserDto;
import com.servimax.proservicehub.domain.dto.auth.AuthenticationRequest;
import com.servimax.proservicehub.domain.dto.auth.AuthenticationResponse;
import com.servimax.proservicehub.domain.entity.Login;
import com.servimax.proservicehub.domain.entity.segurity.JwtToken;
import com.servimax.proservicehub.infrastructure.repository.jwttoken.JwtTokenRepository;
import com.servimax.proservicehub.infrastructure.utils.exceptions.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class AuthenticationService {

    @Autowired
    private LoginServiceI userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenRepository jwtRepository;

    public RegisterUser registerOneCustomer(UserDto newUser){
        Login user = userService.registrOneCustomer(newUser);
        //Utiliza userService para registrar un nuevo usuario con los datos recibidos en el DTO UserDto.
        String jwt = jwtService.generateToken(user, generateExtraClaims(user));
        //Llama a jwtService.generateToken para generar un JWT para el usuario recién creado.
        saveUserToken(user,jwt);
        //El token generado se guarda en la base de datos a través del método saveUserToken.
        RegisterUser userDto = new RegisterUser();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setRole(user.getRol());
        userDto.setIdPersonas(user.getPersonas());
        //Devuelve una instancia de RegisterUser que contiene el ID del usuario, 
        //su nombre de usuario, su rol, y el JWT generado.
        userDto.setJwt(jwt);

        return userDto;
    }
    private void saveUserToken(Login user, String jwt){
        JwtToken token= new JwtToken();
        token.setToken(jwt);
        token.setLogin(user);
        token.setExpiration(jwtService.extractExpiration(jwt));
        token.setValid(true);

        jwtRepository.save(token);
        /*
         * Este método guarda el JWT generado en una entidad llamada JwtToken, 
         * la cual contiene información como el token, 
         * el usuario asociado, la fecha de expiración, 
         * y si el token es válido o no.
        */
    }
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

    public AuthenticationResponse login(AuthenticationRequest autRequest) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                autRequest.getUsername(), autRequest.getPassword()
        );
        /*
         * Se crea un objeto UsernamePasswordAuthenticationToken 
         * utilizando las credenciales proporcionadas en AuthenticationRequest 
         * y se autentica con authenticationManager.
        */

        authenticationManager.authenticate(authentication);

        /*
         * Si la autenticación es correcta, se genera un nuevo JWT y se guarda.
         * Devuelve una instancia de AuthenticationResponse que contiene el JWT generado.
        */

        UserDetails user = userService.findOneByUsername(autRequest.getUsername()).get();
        String jwt = jwtService.generateToken(user, generateExtraClaims((Login) user));
        saveUserToken((Login) user, jwt);
        AuthenticationResponse authRsp = new AuthenticationResponse();
        authRsp.setJwt(jwt);

        return authRsp;
    }

    public boolean validateToken(String jwt) {

        try{
            jwtService.extractUsername(jwt);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        /*
         * ntenta extraer el nombre de usuario del JWT. 
         * Si lo consigue, el token es válido; de lo contrario, el token es inválido.
        */

    }
    public Login findLoggedInUser() {
        UsernamePasswordAuthenticationToken auth =(UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        //Utiliza SecurityContextHolder para obtener el Authentication actual del contexto de seguridad de Spring.
        String username = (String) auth.getPrincipal();
        return userService.findOneByUsername(username)
                .orElseThrow(() -> new ObjectNotFoundException("User not found. Username: " + username));
        //A partir del nombre de usuario obtenido, busca el usuario en el servicio userService.
    }

    public void logout(HttpServletRequest request) {
        String jwt = jwtService.extractJwtFromRequest(request);
        if (jwt == null || !StringUtils.hasText(jwt)) return ;
        //Extrae el JWT desde el encabezado Authorization de la petición HTTP.
        Optional<JwtToken> token = jwtRepository.findByToken(jwt);

        if (token.isPresent() && token.get().isValid()) {
            token.get().setValid(false);
            jwtRepository.save(token.get());
        }
        //Verifica si el JWT es válido, y si lo es, 
        //lo marca como inválido en la base de datos (revocación del token).
    }
}
