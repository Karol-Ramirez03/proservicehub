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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servimax.proservicehub.application.service.AprobacionServicioServiceI;
import com.servimax.proservicehub.domain.entity.AprobacionServicio;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/aprobacionservicio")
public class AprobacionServicioController {

    @Autowired
    private AprobacionServicioServiceI aprobacionServicioServiceI;

    @GetMapping
    public List<AprobacionServicio> list(){
        return aprobacionServicioServiceI.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<AprobacionServicio> OAprobacionServicio = aprobacionServicioServiceI.findById(id);
        if (OAprobacionServicio.isPresent()) {
            return ResponseEntity.ok(OAprobacionServicio.orElseThrow());
        }   
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody AprobacionServicio AprobacionServicio, BindingResult result){
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(aprobacionServicioServiceI.save(AprobacionServicio));
    }

    // @PutMapping("/{id}")
    // public Optional<AprobacionServicio> Update(@PathVariable Long id, @RequestBody AprobacionServicio AprobacionServicio){
    //     Optional<AprobacionServicio> CiudadId = aprobacionServicioServiceI.findById(id); 
    //     if (CiudadId.isPresent()) {
    //         AprobacionServicio CiudadCopy = CiudadId.orElseThrow();
    //         if (AprobacionServicio.getRegion() != null) {
    //             CiudadCopy.setRegion(AprobacionServicio.getRegion());
    //         }
    //         if (AprobacionServicio.getNombre() != null) {
    //             CiudadCopy.setNombre(AprobacionServicio.getNombre());
    //         }
    //         aprobacionServicioServiceI.update(id, CiudadCopy);
    //         return Optional.of(CiudadCopy);
    //     }
    //     return Optional.empty();
    // }

    @DeleteMapping("/{id}") 
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<AprobacionServicio> CiudadId =  aprobacionServicioServiceI.delete(id);
        if (CiudadId.isPresent()) {
            return ResponseEntity.ok(CiudadId.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

}
