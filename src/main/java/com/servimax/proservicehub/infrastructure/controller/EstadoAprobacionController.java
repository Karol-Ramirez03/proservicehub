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

import com.servimax.proservicehub.application.service.EstadoAprobacionServiceI;
import com.servimax.proservicehub.domain.entity.EstadoAprobacion;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/estadoaprobacion")
public class EstadoAprobacionController {

    @Autowired
    private EstadoAprobacionServiceI estadoAprobacionServiceI;

    @GetMapping
    public List<EstadoAprobacion> list(){
        return estadoAprobacionServiceI.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<EstadoAprobacion> OEstadoAprobacion = estadoAprobacionServiceI.findById(id);
        if (OEstadoAprobacion.isPresent()) {
            return ResponseEntity.ok(OEstadoAprobacion.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

        
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody EstadoAprobacion estadoAprobacion, BindingResult result) {
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoAprobacionServiceI.save(estadoAprobacion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody EstadoAprobacion estadoAprobacion, @PathVariable Long id, BindingResult result) {
        Optional<EstadoAprobacion> OEstadoAprobacion = estadoAprobacionServiceI.update(id, estadoAprobacion);
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        if (OEstadoAprobacion.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(OEstadoAprobacion.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<EstadoAprobacion> OEstadoAprobacion = estadoAprobacionServiceI.delete(id);
        if (OEstadoAprobacion.isPresent()) {
            return ResponseEntity.ok(OEstadoAprobacion.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
