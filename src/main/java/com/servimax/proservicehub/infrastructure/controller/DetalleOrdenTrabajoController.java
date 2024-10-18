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

import com.servimax.proservicehub.application.service.DetalleOrdenTrabajoServiceI;
import com.servimax.proservicehub.domain.entity.DetalleOrdenTrabajo;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/detalleorden")
public class DetalleOrdenTrabajoController {

    @Autowired
    private DetalleOrdenTrabajoServiceI detalleOrdenTrabajoServiceI;

    @GetMapping
    public List<DetalleOrdenTrabajo> list(){
        return detalleOrdenTrabajoServiceI.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<DetalleOrdenTrabajo> detalleOptional = detalleOrdenTrabajoServiceI.findById(id);
        if (detalleOptional.isPresent()) {
            return ResponseEntity.ok(detalleOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody DetalleOrdenTrabajo detalleOrdenTrabajo, BindingResult result) {
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleOrdenTrabajoServiceI.save(detalleOrdenTrabajo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody DetalleOrdenTrabajo detalleOrdenTrabajo, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldErrors());
        }
    
        Optional<DetalleOrdenTrabajo> detalleOptional = detalleOrdenTrabajoServiceI.findById(id);
    
        if (detalleOptional.isPresent()) {
            DetalleOrdenTrabajo detalleCopy = detalleOptional.orElseThrow();
    
            if (detalleOrdenTrabajo.getFecha() != null) {
                detalleCopy.setFecha(detalleOrdenTrabajo.getFecha());
            }
            if (detalleOrdenTrabajo.getEstado_orden() != null) {
                detalleCopy.setEstado_orden(detalleOrdenTrabajo.getEstado_orden());
            }
            if (detalleOrdenTrabajo.getServicio() != null) {
                detalleCopy.setServicio(detalleOrdenTrabajo.getServicio());
            }
            if (detalleOrdenTrabajo.getOrden_trabajo() != null) {
                detalleCopy.setOrden_trabajo(detalleOrdenTrabajo.getOrden_trabajo());
            }
    
            detalleOrdenTrabajoServiceI.update(id, detalleCopy);
            
            return ResponseEntity.status(HttpStatus.OK).body(detalleCopy);
        }
    
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("DetalleOrdenTrabajo no encontrado");
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<DetalleOrdenTrabajo> detalleOptional = detalleOrdenTrabajoServiceI.delete(id);
        if (detalleOptional.isPresent()) {
            return ResponseEntity.ok(detalleOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/empleadoId/{estadoId}")
    public ResponseEntity<List<DetalleOrdenTrabajo>> findByEmpleado(@PathVariable long estadoId) {
        List<DetalleOrdenTrabajo> ordenServicios = detalleOrdenTrabajoServiceI.findByIdEmpleado(estadoId);
        if (ordenServicios.isEmpty()) {
            return ResponseEntity.noContent().build(); 
        }
        return ResponseEntity.ok(ordenServicios);
    }
}
