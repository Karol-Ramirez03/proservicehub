package com.servimax.proservicehub.infrastructure.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.servimax.proservicehub.application.service.OrdenTrabajoServiceI;
import com.servimax.proservicehub.domain.entity.OrdenTrabajo;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/ordentrabajo")
public class OrdenTrabajoController {

     @Autowired
    private OrdenTrabajoServiceI ordenTrabajoServiceI;

    @GetMapping
    public List<OrdenTrabajo> list(){
        return ordenTrabajoServiceI.findAll();
    }

    @Transactional(readOnly = true)
    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<OrdenTrabajo> OrdenTrabajo = ordenTrabajoServiceI.findById(id);
        if (OrdenTrabajo.isPresent()) {
            return ResponseEntity.ok(OrdenTrabajo.orElseThrow());
        }   
        return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<?> create(@Valid @RequestBody OrdenTrabajo ordenTrabajoOrdenTrabajo, BindingResult result) {
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(ordenTrabajoServiceI.save(ordenTrabajoOrdenTrabajo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody OrdenTrabajo ordenTrabajoOrdenTrabajo, @PathVariable Long id, BindingResult result) {
        Optional<OrdenTrabajo> OrdenTrabajo = ordenTrabajoServiceI.update(id, ordenTrabajoOrdenTrabajo);
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        if (OrdenTrabajo.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(OrdenTrabajo.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<OrdenTrabajo> OrdenTrabajo = ordenTrabajoServiceI.delete(id);
        if (OrdenTrabajo.isPresent()) {
            return ResponseEntity.ok(OrdenTrabajo.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
