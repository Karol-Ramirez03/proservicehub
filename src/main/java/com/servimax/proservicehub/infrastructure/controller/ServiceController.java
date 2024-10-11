package com.servimax.proservicehub.infrastructure.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servimax.proservicehub.application.service.ServicioServiceI;
import com.servimax.proservicehub.domain.entity.Servicio;
import com.servimax.proservicehub.domain.entity.TipoPersona;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("api/servicio")
public class ServiceController {

    @Autowired
    private ServicioServiceI servicioServiceI;

    @GetMapping
    public List<Servicio> list(){
        return  servicioServiceI.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Servicio> servicioOptional = servicioServiceI.findById(id);
        if (servicioOptional.isPresent()) {
            return ResponseEntity.ok(servicioOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<?> create(@Valid @RequestBody Servicio servicio, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(servicioServiceI.save(servicio));
    }

    
    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
    
    
}
    


