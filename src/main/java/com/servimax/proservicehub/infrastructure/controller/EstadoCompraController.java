package com.servimax.proservicehub.infrastructure.controller;

import java.util.Optional;
import java.util.List;

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

import com.servimax.proservicehub.application.service.EstadoCompraServiceI;
import com.servimax.proservicehub.domain.entity.EstadoCompra;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/estadocompra")
public class EstadoCompraController {

    @Autowired
    private EstadoCompraServiceI estadoCompraServiceI;

    @GetMapping
    public List<EstadoCompra> list(){
        return estadoCompraServiceI.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<EstadoCompra> OEstadoCompra = estadoCompraServiceI.findById(id);
        if (OEstadoCompra.isPresent()) {
            return ResponseEntity.ok(OEstadoCompra.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

        
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody EstadoCompra EstadoCompra, BindingResult result) {
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoCompraServiceI.save(EstadoCompra));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody EstadoCompra EstadoCompra, @PathVariable Long id, BindingResult result) {
        Optional<EstadoCompra> OEstadoCompra = estadoCompraServiceI.update(id, EstadoCompra);
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        if (OEstadoCompra.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(OEstadoCompra.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<EstadoCompra> OEstadoCompra = estadoCompraServiceI.delete(id);
        if (OEstadoCompra.isPresent()) {
            return ResponseEntity.ok(OEstadoCompra.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

}
