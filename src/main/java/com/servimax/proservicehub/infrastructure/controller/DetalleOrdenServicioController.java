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

import com.servimax.proservicehub.application.service.DetalleOrdenServicioServiceI;
import com.servimax.proservicehub.domain.entity.DetalleOrdenServicio;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/detalleordenservicio")
public class DetalleOrdenServicioController {

    @Autowired
    private DetalleOrdenServicioServiceI detalleOrdenServicioServiceI;

    @GetMapping
    public List<DetalleOrdenServicio> list(){
        return  detalleOrdenServicioServiceI.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<DetalleOrdenServicio> ODetalleOrdenServicio = detalleOrdenServicioServiceI.findById(id);
        if (ODetalleOrdenServicio.isPresent()) {
            return ResponseEntity.ok(ODetalleOrdenServicio.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<?> create(@Valid @RequestBody DetalleOrdenServicio detalleOrdenServicio, BindingResult result) {
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleOrdenServicioServiceI.save(detalleOrdenServicio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody DetalleOrdenServicio detalleOrdenServicio, @PathVariable Long id, BindingResult result) {
        Optional<DetalleOrdenServicio> ODetalleOrdenServicio = detalleOrdenServicioServiceI.update(id, detalleOrdenServicio);
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        if (ODetalleOrdenServicio.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(ODetalleOrdenServicio.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<DetalleOrdenServicio> ODetalleOrdenServicio = detalleOrdenServicioServiceI.delete(id);
        if (ODetalleOrdenServicio.isPresent()) {
            return ResponseEntity.ok(ODetalleOrdenServicio.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/estado/{estadoId}")
    public ResponseEntity<List<DetalleOrdenServicio>> findByEstadoId(@PathVariable long estadoId) {
        List<DetalleOrdenServicio> ordenServicios = detalleOrdenServicioServiceI.findByEstadoId(estadoId);
        if (ordenServicios.isEmpty()) {
            return ResponseEntity.noContent().build(); 
        }
        return ResponseEntity.ok(ordenServicios);
    }

    @GetMapping("/empleado/{estadoId}")
    public ResponseEntity<List<DetalleOrdenServicio>> findByEmpleado(@PathVariable long estadoId) {
        List<DetalleOrdenServicio> ordenServicios = detalleOrdenServicioServiceI.findByIdEmpleado(estadoId);
        if (ordenServicios.isEmpty()) {
            return ResponseEntity.noContent().build(); 
        }
        return ResponseEntity.ok(ordenServicios);
    }
}
