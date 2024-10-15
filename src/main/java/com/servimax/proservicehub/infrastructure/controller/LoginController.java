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
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/api/login")
    public ResponseEntity<?> login(
            @RequestParam(name = "usuario") String usuario,
            @RequestParam(name = "contraseña") String contraseña) {
        
        // Lógica de autenticación
        Login login = loginServiceI.authenticate(usuario, contraseña);
        
        if (login == null) {
            return ResponseEntity.status(401).body("Credenciales inválidas"); // Retorna 401 si la autenticación falla
        }
        
        return ResponseEntity.ok(new Login(login.getId(), login.getUsuario())); // Retorna un objeto específico
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

}
