package com.servimax.proservicehub.infrastructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.servimax.proservicehub.application.service.EstadoOrdenServiceI;
import com.servimax.proservicehub.domain.entity.EstadoOrden;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/estadoorden")
public class EstadoOrdenController {

    @Autowired
    private EstadoOrdenServiceI estadoOrdenServiceI;

    @GetMapping
    public List<EstadoOrden> list(){
        return estadoOrdenServiceI.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<EstadoOrden> OEstadoOrden = estadoOrdenServiceI.findById(id);
        if (OEstadoOrden.isPresent()) {
            return ResponseEntity.ok(OEstadoOrden.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<?> create(@Valid @RequestBody EstadoOrden estadoOrden, BindingResult result) {
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoOrdenServiceI.save(estadoOrden));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody EstadoOrden estadoOrden, @PathVariable Long id, BindingResult result) {
        Optional<EstadoOrden> OEstadoOrden = estadoOrdenServiceI.update(id, estadoOrden);
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        if (OEstadoOrden.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(OEstadoOrden.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<EstadoOrden> OEstadoOrden = estadoOrdenServiceI.delete(id);
        if (OEstadoOrden.isPresent()) {
            return ResponseEntity.ok(OEstadoOrden.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    

}
