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

import com.servimax.proservicehub.application.service.TipoEmpresaServiceI;
import com.servimax.proservicehub.domain.entity.TipoEmpresa;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tipoEmpresa")
public class TipoEmpresaController {

    
    @Autowired
    private TipoEmpresaServiceI tipoEmpresaServiceI;

    @GetMapping
    public List<TipoEmpresa> list(){
        return tipoEmpresaServiceI.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<TipoEmpresa> TipoEmpresaOpt = tipoEmpresaServiceI.findById(id);
        if (TipoEmpresaOpt.isPresent()) {
            return ResponseEntity.ok(TipoEmpresaOpt.orElseThrow());
        }   
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody TipoEmpresa TipoEmpresa, BindingResult result){
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoEmpresaServiceI.save(TipoEmpresa));
    }

    @PutMapping("/{id}")
    public Optional<TipoEmpresa> Update(@PathVariable Long id, @RequestBody TipoEmpresa TipoEmpresa){
        Optional<TipoEmpresa> TipoEmpresaId = tipoEmpresaServiceI.findById(id); 
        if (TipoEmpresaId.isPresent()) {
            TipoEmpresa TipoEmpresaCopy = TipoEmpresaId.orElseThrow();
            if (TipoEmpresa.getDescripcion() != null) {
                TipoEmpresaCopy.setDescripcion(TipoEmpresa.getDescripcion());
            }
            tipoEmpresaServiceI.update(id, TipoEmpresaCopy);
            return Optional.of(TipoEmpresaCopy);
        }
        return Optional.empty();
    }

    @DeleteMapping("/{id}") 
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<TipoEmpresa> TipoEmpresaId = tipoEmpresaServiceI.delete(id); 
        if (TipoEmpresaId.isPresent()) {
            return ResponseEntity.ok(TipoEmpresaId.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
