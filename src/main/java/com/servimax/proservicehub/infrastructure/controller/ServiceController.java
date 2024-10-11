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

import com.servimax.proservicehub.application.service.ServicioServiceI;
import com.servimax.proservicehub.domain.entity.Servicio;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

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
            return ValidatedFields.validation(result);
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(servicioServiceI.save(servicio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Servicio servicio, @PathVariable Long id, BindingResult result) {
        Optional<Servicio> servicioOptional = servicioServiceI.update(id, servicio);
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        if (servicioOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(servicioOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Servicio> servicioOptional = servicioServiceI.delete(id);
        if (servicioOptional.isPresent()) {
            return ResponseEntity.ok(servicioOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
    
    
}
    


