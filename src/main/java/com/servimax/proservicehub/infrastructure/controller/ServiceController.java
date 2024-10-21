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

import com.servimax.proservicehub.application.service.ServicioServiceI;
import com.servimax.proservicehub.domain.entity.Servicio;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/servicio")
public class ServiceController {

    @Autowired
    private ServicioServiceI servicioServiceI;

    @GetMapping
    public List<Servicio> list(){
        return  servicioServiceI.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Servicio> servicioOptional = servicioServiceI.findById(id);
        if (servicioOptional.isPresent()) {
            return ResponseEntity.ok(servicioOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<?> create(@Valid @RequestBody Servicio servicio, BindingResult result) {
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(servicioServiceI.save(servicio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Servicio servicio, BindingResult result) {
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
    
        Optional<Servicio> servicioOptional = servicioServiceI.findById(id);
        if (!servicioOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
    
        Servicio servicioExistente = servicioOptional.get();
    
        // Solo actualiza los campos que no son nulos en el objeto recibido
        if (servicio.getNombre() != null) {
            servicioExistente.setNombre(servicio.getNombre());
        }
        if (servicio.getRequiere_insumo() != null) {
            servicioExistente.setRequiere_insumo(servicio.getRequiere_insumo());
        }
        if (servicio.getTiempo_ejecucion() != null) {
            servicioExistente.setTiempo_ejecucion(servicio.getTiempo_ejecucion());
        }
        
        Servicio servicioActualizado = servicioServiceI.save(servicioExistente);
        return ResponseEntity.ok(servicioActualizado);
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Servicio> servicioOptional = servicioServiceI.delete(id);
        if (servicioOptional.isPresent()) {
            return ResponseEntity.ok(servicioOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
    
    
}
    


