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

import com.servimax.proservicehub.application.service.CompraServiceI;
import com.servimax.proservicehub.domain.entity.Compra;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/compra")
public class CompraController {


    @Autowired
    private CompraServiceI compraServiceI;

    @GetMapping
    public List<Compra> list(){
        return  compraServiceI.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Compra> OCompra = compraServiceI.findById(id);
        if (OCompra.isPresent()) {
            return ResponseEntity.ok(OCompra.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<?> create(@Valid @RequestBody Compra compra, BindingResult result) {
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(compraServiceI.save(compra));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Compra compra, @PathVariable Long id, BindingResult result) {
        Optional<Compra> OCompra = compraServiceI.update(id, compra);
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        if (OCompra.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(OCompra.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Compra> OCompra = compraServiceI.delete(id);
        if (OCompra.isPresent()) {
            return ResponseEntity.ok(OCompra.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    
}
