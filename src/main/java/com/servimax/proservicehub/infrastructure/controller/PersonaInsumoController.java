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

import com.servimax.proservicehub.application.service.PersonaInsumoServiceI;
import com.servimax.proservicehub.domain.entity.PersonaInsumo;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/personainsumo")
public class PersonaInsumoController {

    @Autowired
    private PersonaInsumoServiceI personaInsumoServiceI;

    @GetMapping
    public List<PersonaInsumo> list(){
        return personaInsumoServiceI.findAll();
    }

    @GetMapping("/{idInsumo}/{idservicio}")
    public ResponseEntity<?> view(@PathVariable Long idPersona,@PathVariable  Long idInsumo) {
        Optional<PersonaInsumo> PersonaInsumoOptional = personaInsumoServiceI.findById(idPersona,idInsumo);
        if (PersonaInsumoOptional.isPresent()) {
            return ResponseEntity.ok(PersonaInsumoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

        
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody PersonaInsumo personaInsumo, BindingResult result) {
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(personaInsumoServiceI.save(personaInsumo));
    }

    @PutMapping("/{idInsumo}/{idservicio}")
    public ResponseEntity<?> update(@Valid @RequestBody PersonaInsumo personaInsumo, @PathVariable Long idPersona,@PathVariable  Long idInsumo, BindingResult result) {
        Optional<PersonaInsumo> ServicioInsumoOptional = personaInsumoServiceI.update(idPersona,idInsumo, personaInsumo);
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        if (ServicioInsumoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(ServicioInsumoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idInsumo}/{idservicio}")
    public ResponseEntity<?> delete(@PathVariable Long idPersona,@PathVariable  Long idInsumo) {
        Optional<PersonaInsumo> personaInsumoOptional = personaInsumoServiceI.delete(idPersona,idInsumo);
        if (personaInsumoOptional.isPresent()) {
            return ResponseEntity.ok(personaInsumoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/insumos/{idPersona}")
    public ResponseEntity<List<PersonaInsumo>> getInsumosByPersonaId(@PathVariable Long idPersona) {
        List<PersonaInsumo> insumos = personaInsumoServiceI.getInsumosByPersonaId(idPersona);
        if (insumos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(insumos);
    }
}
