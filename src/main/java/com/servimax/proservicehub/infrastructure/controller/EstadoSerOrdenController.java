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

import com.servimax.proservicehub.application.service.EstadoSerOrdenServiceI;
import com.servimax.proservicehub.domain.entity.EstadoOrdenServicio;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/estadoordenservicio")
public class EstadoSerOrdenController {

    @Autowired
    private EstadoSerOrdenServiceI estadoOrdenServicioServiceI;

    @GetMapping
    public List<EstadoOrdenServicio> list() {
        return ((List<EstadoOrdenServicio>)estadoOrdenServicioServiceI.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<EstadoOrdenServicio> estadoOrdenServicioOptional = estadoOrdenServicioServiceI.findById(id);
        if (estadoOrdenServicioOptional.isPresent()) {
            return ResponseEntity.ok(estadoOrdenServicioOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody EstadoOrdenServicio estadoOrdenServicio, BindingResult result) {
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoOrdenServicioServiceI.save(estadoOrdenServicio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody EstadoOrdenServicio estadoOrdenServicio, @PathVariable Long id, BindingResult result) {
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }

        Optional<EstadoOrdenServicio> estadoOrdenServicioOptional = estadoOrdenServicioServiceI.update(id, estadoOrdenServicio);
        if (estadoOrdenServicioOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(estadoOrdenServicioOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<EstadoOrdenServicio> estadoOrdenServicioOptional = estadoOrdenServicioServiceI.delete(id);
        if (estadoOrdenServicioOptional.isPresent()) {
            return ResponseEntity.ok(estadoOrdenServicioOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
