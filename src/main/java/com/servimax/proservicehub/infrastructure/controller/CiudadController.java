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

import com.servimax.proservicehub.application.service.CiudadServiceI;
import com.servimax.proservicehub.domain.entity.Ciudad;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/ciudad")
public class CiudadController {

    @Autowired
    private CiudadServiceI CiudadServiceI;

    @GetMapping
    public List<Ciudad> list(){
        return CiudadServiceI.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<Ciudad> CiudadOpt = CiudadServiceI.findById(id);
        if (CiudadOpt.isPresent()) {
            return ResponseEntity.ok(CiudadOpt.orElseThrow());
        }   
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Ciudad Ciudad, BindingResult result){
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(CiudadServiceI.save(Ciudad));
    }

    @PutMapping("/{id}")
    public Optional<Ciudad> Update(@PathVariable Long id, @RequestBody Ciudad Ciudad){
        Optional<Ciudad> CiudadId = CiudadServiceI.findById(id); 
        if (CiudadId.isPresent()) {
            Ciudad CiudadCopy = CiudadId.orElseThrow();
            if (Ciudad.getRegion() != null) {
                CiudadCopy.setRegion(Ciudad.getRegion());
            }
            if (Ciudad.getNombre() != null) {
                CiudadCopy.setNombre(Ciudad.getNombre());
            }
            CiudadServiceI.update(id, CiudadCopy);
            return Optional.of(CiudadCopy);
        }
        return Optional.empty();
    }

    @DeleteMapping("/{id}") 
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Ciudad> CiudadId =  CiudadServiceI.delete(id);
        if (CiudadId.isPresent()) {
            return ResponseEntity.ok(CiudadId.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
