package com.servimax.proservicehub.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servimax.proservicehub.application.service.auth.AuthenticationService;
import com.servimax.proservicehub.domain.dto.auth.AuthenticationRequest;
import com.servimax.proservicehub.domain.dto.auth.AuthenticationResponse;
import com.servimax.proservicehub.domain.dto.auth.LogoutResponse;
import com.servimax.proservicehub.domain.entity.Login;

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
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody @Valid AuthenticationRequest authenticationRequest){

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
