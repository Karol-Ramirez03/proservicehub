package com.servimax.proservicehub.infrastructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servimax.proservicehub.application.service.LoginServiceI;
import com.servimax.proservicehub.domain.entity.Login;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/login")
public class LoginController {

    @Autowired
    private LoginServiceI loginServiceI;

    @GetMapping
    public List<Login> list(){
        return loginServiceI.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<Login> OLogin = loginServiceI.findById(id);
        if (OLogin.isPresent()) {
            return ResponseEntity.ok(OLogin.orElseThrow());
        }   
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Login login, BindingResult result){
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(loginServiceI.save(login));
    }

    @PutMapping("/{id}")
    public Optional<Login> Update(@PathVariable Long id, @RequestBody Login login){
        Optional<Login> OLogin = loginServiceI.findById(id); 
        if (OLogin.isPresent()) {
            Login login2 = OLogin.orElseThrow();
            if (login.getUsuario() != null) {
                login2.setUsuario(login.getUsuario());
            }
            if (login.getContraseña() != null) {
                login2.setContraseña(login.getContraseña());
            }
            loginServiceI.update(id, login2);
            return Optional.of(login2);
        }
        return Optional.empty();
    }

    @DeleteMapping("/{id}") 
    public ResponseEntity<?> delete(@PathVariable long id){
        Optional<Login> OLogin =  loginServiceI.delete(id);
        if (OLogin.isPresent()) {
            return ResponseEntity.ok(OLogin.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }


    // @PostMapping("/register")
    // public ResponseEntity<Login> register(@RequestBody LoginRequest loginRequest) {
    //     Login login = new Login();
    //     login.setUsuario(loginRequest.getUsuario());
    //     login.setContraseña(loginRequest.getContraseña());
    //     Login savedLogin = loginServiceI.save(login);
    //     return ResponseEntity.ok(savedLogin);
    // }

    // @GetMapping("/login")
    // public ResponseEntity<Login> login(@RequestParam String username, @RequestParam String password) {
    //     Login authenticatedUser = loginServiceI.authenticate(username, password);
    //     if (authenticatedUser != null) {
    //         return ResponseEntity.ok(authenticatedUser);
    //     } else {
    //         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    //     }
    // }

    @GetMapping("/usuario/{usuario}")
    public ResponseEntity<Optional<Login>> findByUsuario(@PathVariable String usuario) {
        Optional<Login> login = loginServiceI.findByUsuario(usuario);
        if (login.isEmpty()) {
            return ResponseEntity.noContent().build(); 
        }
        return ResponseEntity.ok(login);
    }
}
