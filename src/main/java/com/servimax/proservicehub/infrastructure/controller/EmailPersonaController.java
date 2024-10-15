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

import com.servimax.proservicehub.application.service.EmailPersonaServiceI;
import com.servimax.proservicehub.domain.entity.EmailPersona;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/emailpersona")
public class EmailPersonaController {

    @Autowired
    private EmailPersonaServiceI emailPersonaService;

    @GetMapping
    public List<EmailPersona> list() {
        return emailPersonaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<EmailPersona> emailPersonaOptional = emailPersonaService.findById(id);
        if (emailPersonaOptional.isPresent()) {
            return ResponseEntity.ok(emailPersonaOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody EmailPersona emailPersona, BindingResult result) {
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(emailPersonaService.save(emailPersona));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody EmailPersona emailPersona, @PathVariable Long id, BindingResult result) {
        Optional<EmailPersona> emailPersonaOptional = emailPersonaService.update(id, emailPersona);
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        if (emailPersonaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(emailPersonaOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<EmailPersona> emailPersonaOptional = emailPersonaService.delete(id);
        if (emailPersonaOptional.isPresent()) {
            return ResponseEntity.ok(emailPersonaOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
