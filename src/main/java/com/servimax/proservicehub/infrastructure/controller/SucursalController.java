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

import com.servimax.proservicehub.application.service.SucursalServiceI;
import com.servimax.proservicehub.domain.entity.Sucursal;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/sucursal")
public class SucursalController {
    
    @Autowired
    private SucursalServiceI SucursalServiceI;

    @GetMapping
    public List<Sucursal> list(){
        return SucursalServiceI.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<Sucursal> SucursalOpt = SucursalServiceI.findById(id);
        if (SucursalOpt.isPresent()) {
            return ResponseEntity.ok(SucursalOpt.orElseThrow());
        }   
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Sucursal Sucursal, BindingResult result){
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(SucursalServiceI.save(Sucursal));
    }

    @PutMapping("/{id}")
    public Optional<Sucursal> Update(@PathVariable Long id, @RequestBody Sucursal Sucursal){
        Optional<Sucursal> SucursalId = SucursalServiceI.findById(id); 
        if (SucursalId.isPresent()) {
            Sucursal SucursalCopy = SucursalId.orElseThrow();
            if (Sucursal.getDireccion() != null) {
                SucursalCopy.setDireccion(Sucursal.getDireccion());
            }
            if (Sucursal.getNombre() != null) {
                SucursalCopy.setNombre(Sucursal.getNombre());
            }
            if (Sucursal.getEmpresa() != null) {
                SucursalCopy.setEmpresa(Sucursal.getEmpresa());
            }
            if (Sucursal.getFecha_creacion() != null) {
                SucursalCopy.setFecha_creacion(Sucursal.getFecha_creacion());
            }
            if (Sucursal.getNit() != null) {
                SucursalCopy.setNit(Sucursal.getNit());
            }
            SucursalServiceI.update(id, SucursalCopy);
            return Optional.of(SucursalCopy);
        }
        return Optional.empty();
    }

    @DeleteMapping("/{id}") 
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Sucursal> SucursalId =  SucursalServiceI.delete(id);
        if (SucursalId.isPresent()) {
            return ResponseEntity.ok(SucursalId.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

}
