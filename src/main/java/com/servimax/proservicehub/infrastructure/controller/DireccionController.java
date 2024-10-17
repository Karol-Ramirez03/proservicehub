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

import com.servimax.proservicehub.application.service.DireccionServiceI;
import com.servimax.proservicehub.domain.entity.Direccion;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/direccion")
public class DireccionController {

    @Autowired
    private DireccionServiceI DireccionServiceI;

    @GetMapping
    public List<Direccion> list(){
        return DireccionServiceI.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<Direccion> DireccionOpt = DireccionServiceI.findById(id);
        if (DireccionOpt.isPresent()) {
            return ResponseEntity.ok(DireccionOpt.orElseThrow());
        }   
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Direccion Direccion, BindingResult result){
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(DireccionServiceI.save(Direccion));
    }

    @PutMapping("/{id}")
    public Optional<Direccion> Update(@PathVariable Long id, @RequestBody Direccion Direccion){
        Optional<Direccion> DireccionId = DireccionServiceI.findById(id); 
        if (DireccionId.isPresent()) {
            Direccion DireccionCopy = DireccionId.orElseThrow();
            if (Direccion.getBarrio() != null) {
                DireccionCopy.setBarrio(Direccion.getBarrio());
            }
            if (Direccion.getCalle() != null) {
                DireccionCopy.setCalle(Direccion.getCalle());
            }
            if (Direccion.getCarrera() != null) {
                DireccionCopy.setCarrera(Direccion.getCarrera());
            }
            if (Direccion.getDescripcion() != null) {
                DireccionCopy.setDescripcion(Direccion.getDescripcion());
            }
            DireccionServiceI.update(id, DireccionCopy);
            return Optional.of(DireccionCopy);
        }
        return Optional.empty();
    }

    @DeleteMapping("/{id}") 
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Direccion> DireccionId =  DireccionServiceI.delete(id);
        if (DireccionId.isPresent()) {
            return ResponseEntity.ok(DireccionId.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
