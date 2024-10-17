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

import com.servimax.proservicehub.application.service.OrdenServicioServiceI;
import com.servimax.proservicehub.domain.entity.OrdenServicio;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/ordenservicio")
public class OrdenServicioController {

    @Autowired
    private OrdenServicioServiceI ordenServicioServiceI;

    @GetMapping
    public List<OrdenServicio> list(){
        return ordenServicioServiceI.findAll();
    }

    @Transactional(readOnly = true)
    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<OrdenServicio> OOrdenServicio = ordenServicioServiceI.findById(id);
        if (OOrdenServicio.isPresent()) {
            return ResponseEntity.ok(OOrdenServicio.orElseThrow());
        }   
        return ResponseEntity.notFound().build();
    }


    @PostMapping()
    public ResponseEntity<?> create(@Valid @RequestBody OrdenServicio ordenServicio, BindingResult result) {
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(ordenServicioServiceI.save(ordenServicio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody OrdenServicio ordenServicio, @PathVariable Long id, BindingResult result) {
        Optional<OrdenServicio> ordenServicioOptional = ordenServicioServiceI.findById(id);

        if (ordenServicioOptional.isPresent()) {
            OrdenServicio ordenServicioCopy = ordenServicioOptional.orElseThrow();
    
            if (ordenServicio.getFecha_orden() != null) {
                ordenServicioCopy.setFecha_orden(ordenServicio.getFecha_orden());
            }
            if (ordenServicio.getPersona() != null) {
                ordenServicioCopy.setPersona(ordenServicio.getPersona());
            }
            if (ordenServicio.getPersonas() != null) {
                ordenServicioCopy.setPersonas(ordenServicio.getPersonas());
            }
            if (ordenServicio.getEstado_orden_servicio() != null) {
                ordenServicioCopy.setEstado_orden_servicio(ordenServicio.getEstado_orden_servicio());
            }
            if (ordenServicio.getOrdenTrabajo() != null) {
                ordenServicioCopy.setOrdenTrabajo(ordenServicio.getOrdenTrabajo());
            }
            
            ordenServicioServiceI.update(id, ordenServicioCopy);
            
            return ResponseEntity.status(HttpStatus.OK).body(ordenServicioCopy);
        }
    
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("OrdenServicio no encontrada");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<OrdenServicio> OOrdenServicio = ordenServicioServiceI.delete(id);
        if (OOrdenServicio.isPresent()) {
            return ResponseEntity.ok(OOrdenServicio.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
    
}
