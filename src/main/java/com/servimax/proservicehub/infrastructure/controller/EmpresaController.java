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

import com.servimax.proservicehub.application.service.EmpresaServiceI;
import com.servimax.proservicehub.domain.entity.Empresa;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaServiceI empresaServiceI;

    @GetMapping
    public List<Empresa> list(){
        return empresaServiceI.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<Empresa> empresaOpt = empresaServiceI.findById(id);
        if (empresaOpt.isPresent()) {
            return ResponseEntity.ok(empresaOpt.orElseThrow());
        }   
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Empresa Empresa, BindingResult result){
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaServiceI.save(Empresa));
    }

    @PutMapping("/{id}")
    public Optional<Empresa> Update(@PathVariable Long id, @RequestBody Empresa empresa){
        Optional<Empresa> empresaId = empresaServiceI.findById(id); 
        if (empresaId.isPresent()) {
            Empresa empresaCopy = empresaId.orElseThrow();
            if (empresa.getNombre() != null) {
                empresaCopy.setNombre(empresa.getNombre());
            }
            if (empresa.getTipo_empresa() != null) {
                empresaCopy.setTipo_empresa(empresa.getTipo_empresa());
            }
            empresaServiceI.update(id, empresaCopy);
            return Optional.of(empresaCopy);
        }
        return Optional.empty();
    }

    @DeleteMapping("/{id}") 
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Empresa> empresaId =  empresaServiceI.delete(id);
        if (empresaId.isPresent()) {
            return ResponseEntity.ok(empresaId.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
