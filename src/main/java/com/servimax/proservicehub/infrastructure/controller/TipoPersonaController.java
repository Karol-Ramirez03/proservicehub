package com.servimax.proservicehub.infrastructure.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import com.servimax.proservicehub.application.service.TipoPersonaServiceI;
import com.servimax.proservicehub.domain.entity.TipoPersona;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/tipoPersona")
public class TipoPersonaController {

    @Autowired
    private TipoPersonaServiceI tipoPersonaService;

    @GetMapping
    public List<TipoPersona> list(){
        return tipoPersonaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<TipoPersona> TipoPersonaOptional = tipoPersonaService.findById(id);
        if (TipoPersonaOptional.isPresent()) {
            return ResponseEntity.ok(TipoPersonaOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

        
    @PostMapping()
    public ResponseEntity<?> create(@Valid @RequestBody TipoPersona TipoPersona, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoPersonaService.save(TipoPersona));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody TipoPersona TipoPersona, @PathVariable Long id, BindingResult result) {
        Optional<TipoPersona> TipoPersonaOptional = tipoPersonaService.update(id, TipoPersona);
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        if (TipoPersonaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(TipoPersonaOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<TipoPersona> TipoPersonaOptional = tipoPersonaService.delete(id);
        if (TipoPersonaOptional.isPresent()) {
            return ResponseEntity.ok(TipoPersonaOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
    
    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
