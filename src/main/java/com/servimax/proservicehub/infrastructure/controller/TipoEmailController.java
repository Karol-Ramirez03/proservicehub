package com.servimax.proservicehub.infrastructure.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import com.servimax.proservicehub.application.service.TipoEmailServiceI;
import com.servimax.proservicehub.domain.entity.TipoEmail;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/tipoEmail")
public class TipoEmailController {

     @Autowired
    private TipoEmailServiceI tipoEmailServiceI;

    @GetMapping
    public List<TipoEmail> list(){
        return  tipoEmailServiceI.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<TipoEmail> OTipoEmail = tipoEmailServiceI.findById(id);
        if (OTipoEmail.isPresent()){
            return ResponseEntity.ok(OTipoEmail.orElseThrow());
        }
        return  ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<?> create(@Valid @RequestBody TipoEmail tipoEmail, BindingResult result){
        if (result.hasFieldErrors()) {
            return validation(result);
            
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoEmailServiceI.save(tipoEmail));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody TipoEmail tipoEmail, @PathVariable Long id, BindingResult result) {
        Optional<TipoEmail> OTipoEmail= tipoEmailServiceI.update(id, tipoEmail);
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        if (OTipoEmail.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(OTipoEmail.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<TipoEmail> OTipoEmail = tipoEmailServiceI.delete(id);
        if (OTipoEmail.isPresent()) {
            return ResponseEntity.ok(OTipoEmail.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
    

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
