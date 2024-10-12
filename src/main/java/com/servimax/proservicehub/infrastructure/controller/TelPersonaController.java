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

import com.servimax.proservicehub.application.service.TelPersonaServiceI;
import com.servimax.proservicehub.domain.entity.TelPersona;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/telpersona")
public class TelPersonaController {

    @Autowired
    private TelPersonaServiceI TelPersonaServiceI;

    @GetMapping
    public List<TelPersona> list(){
        return TelPersonaServiceI.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<TelPersona> TelPersonaOpt = TelPersonaServiceI.findById(id);
        if (TelPersonaOpt.isPresent()) {
            return ResponseEntity.ok(TelPersonaOpt.orElseThrow());
        }   
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody TelPersona TelPersona, BindingResult result){
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(TelPersonaServiceI.save(TelPersona));
    }

    @PutMapping("/{id}")
    public Optional<TelPersona> Update(@PathVariable Long id, @RequestBody TelPersona TelPersona){
        Optional<TelPersona> TelPersonaId = TelPersonaServiceI.findById(id); 
        if (TelPersonaId.isPresent()) {
            TelPersona TelPersonaCopy = TelPersonaId.orElseThrow();
            if (TelPersona.getNumero() != null) {
                TelPersonaCopy.setNumero(TelPersona.getNumero());
            }
            if (TelPersona.getPersonas() != null) {
                TelPersonaCopy.setPersonas(TelPersona.getPersonas());
            }
            if (TelPersona.getTipoTelefono() != null) {
                TelPersonaCopy.setTipoTelefono(TelPersona.getTipoTelefono());
            }
            TelPersonaServiceI.update(id, TelPersonaCopy);
            return Optional.of(TelPersonaCopy);
        }
        return Optional.empty();
    }

    @DeleteMapping("/{id}") 
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<TelPersona> TelPersonaId =  TelPersonaServiceI.delete(id);
        if (TelPersonaId.isPresent()) {
            return ResponseEntity.ok(TelPersonaId.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
