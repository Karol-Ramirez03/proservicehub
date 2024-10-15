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

import com.servimax.proservicehub.application.service.PersonasServiceI;
import com.servimax.proservicehub.domain.entity.Personas;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    private PersonasServiceI personaServiceI;

    @GetMapping
    public List<Personas> list(){
        return personaServiceI.findAll();
    }

    @GetMapping("/{nroDoc}")
    public ResponseEntity<?> view(@PathVariable Long nroDoc) {
        Optional<Personas> personaOptional = personaServiceI.findById(nroDoc);
        if (personaOptional.isPresent()) {
            return ResponseEntity.ok(personaOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Personas persona, BindingResult result) {
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(personaServiceI.save(persona));
    }

    @PutMapping("/{nroDoc}")
    public ResponseEntity<?> update(@Valid @RequestBody Personas persona, @PathVariable Long nroDoc, BindingResult result) {
        Optional<Personas> personaOptional = personaServiceI.update(nroDoc, persona);
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        if (personaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(personaOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{nroDoc}")
    public ResponseEntity<?> delete(@PathVariable Long nroDoc) {
        Optional<Personas> personaOptional = personaServiceI.delete(nroDoc);
        if (personaOptional.isPresent()) {
            return ResponseEntity.ok(personaOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
