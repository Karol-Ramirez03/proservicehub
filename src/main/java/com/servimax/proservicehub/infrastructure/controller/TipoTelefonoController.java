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

import com.servimax.proservicehub.application.service.TipoTelefonoServiceI;
import com.servimax.proservicehub.domain.entity.TipoTelefono;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/tipotelefono")
public class TipoTelefonoController {

    @Autowired
    private TipoTelefonoServiceI telefonoServiceI;

    @GetMapping
    public List<TipoTelefono> list(){
        return telefonoServiceI.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<TipoTelefono> TipoTelefonoOptional = telefonoServiceI.findById(id);
        if (TipoTelefonoOptional.isPresent()) {
            return ResponseEntity.ok(TipoTelefonoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

        
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody TipoTelefono TipoTelefono, BindingResult result) {
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(telefonoServiceI.save(TipoTelefono));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody TipoTelefono TipoTelefono, @PathVariable Long id, BindingResult result) {
        Optional<TipoTelefono> TipoTelefonoOptional = telefonoServiceI.update(id, TipoTelefono);
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        if (TipoTelefonoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(TipoTelefonoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<TipoTelefono> TipoTelefonoOptional = telefonoServiceI.delete(id);
        if (TipoTelefonoOptional.isPresent()) {
            return ResponseEntity.ok(TipoTelefonoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
