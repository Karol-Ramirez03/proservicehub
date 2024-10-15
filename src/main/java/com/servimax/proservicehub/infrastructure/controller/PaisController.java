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

import com.servimax.proservicehub.application.service.PaisServiceI;
import com.servimax.proservicehub.domain.entity.Pais;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/pais")
public class PaisController {

    @Autowired
    private PaisServiceI PaisServiceI;

    @GetMapping
    public List<Pais> list(){
        return PaisServiceI.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<Pais> PaisOpt = PaisServiceI.findById(id);
        if (PaisOpt.isPresent()) {
            return ResponseEntity.ok(PaisOpt.orElseThrow());
        }   
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Pais Pais, BindingResult result){
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(PaisServiceI.save(Pais));
    }

    @PutMapping("/{id}")
    public Optional<Pais> Update(@PathVariable Long id, @RequestBody Pais Pais){
        Optional<Pais> PaisId = PaisServiceI.findById(id); 
        if (PaisId.isPresent()) {
            Pais PaisCopy = PaisId.orElseThrow();
            if (Pais.getRegion() != null) {
                PaisCopy.setRegion(Pais.getRegion());
            }
            if (Pais.getNombre() != null) {
                PaisCopy.setNombre(Pais.getNombre());
            }
            PaisServiceI.update(id, PaisCopy);
            return Optional.of(PaisCopy);
        }
        return Optional.empty();
    }

    @DeleteMapping("/{id}") 
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Pais> PaisId =  PaisServiceI.delete(id);
        if (PaisId.isPresent()) {
            return ResponseEntity.ok(PaisId.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}

