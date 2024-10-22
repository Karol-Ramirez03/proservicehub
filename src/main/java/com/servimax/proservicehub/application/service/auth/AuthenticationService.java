package com.servimax.proservicehub.application.service.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.servimax.proservicehub.application.service.LoginServiceI;
import com.servimax.proservicehub.domain.dto.RegisterUser;
import com.servimax.proservicehub.domain.dto.UserDTO;
import com.servimax.proservicehub.domain.dto.auth.AuthenticationRequest;
import com.servimax.proservicehub.domain.dto.auth.AuthenticationResponse;
import com.servimax.proservicehub.domain.entity.Login;
import com.servimax.proservicehub.infrastructure.utils.exceptiones.ObjectNotFoundException;

@Service
public class AuthenticationService {

    @Autowired
    private LoginServiceI loginServiceI;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public RegisterUser registro(UserDTO newUser){
        Login user = loginServiceI.resgistroCliente(newUser);

        RegisterUser userDto = new RegisterUser();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsuario());
        userDto.setPersona(user.getPersonas());
        userDto.setRole(user.getRol());

        String jwt = jwtService.generateToken(user, generateExtraClaims(user));
        userDto.setJwt(jwt);
        /*
         * El token JWT generado se almacena en 
         * el objeto RegisterUser utilizando el método setJwt(jwt)
        */

        return userDto;
    }
    private Map<String, Object> generateExtraClaims(Login user) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name",user.getPersonas());
        extraClaims.put("role",user.getRol());
        extraClaims.put("authorities",user.getAuthorities());

        return extraClaims;
    }
    public AuthenticationResponse login(AuthenticationRequest autRequest) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                autRequest.getUsername(), autRequest.getPassword()
        );

        authenticationManager.authenticate(authentication);

        UserDetails user = loginServiceI.findByUsuario(autRequest.getUsername()).get();
        String jwt = jwtService.generateToken(user, generateExtraClaims((Login) user));

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

    }

    public Login findLoggedInUser() {
        UsernamePasswordAuthenticationToken auth =(UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        String username = (String) auth.getPrincipal();
        return loginServiceI.findByUsuario(username)
                .orElseThrow(() -> new ObjectNotFoundException("User not found. Username: " + username));
    }
}
