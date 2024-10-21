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

import com.servimax.proservicehub.application.service.RolServiceI;
import com.servimax.proservicehub.domain.entity.Rol;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/rol")
public class RolController {

    @Autowired
    private RolServiceI rolServiceI;

    @GetMapping
    public List<Rol> list(){
        return rolServiceI.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<Rol> ORol = rolServiceI.findById(id);
        if (ORol.isPresent()) {
            return ResponseEntity.ok(ORol.orElseThrow());
        }   
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Rol rol, BindingResult result){
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(rolServiceI.save(rol));
    }

    @PutMapping("/{id}")
    public Optional<Rol> Update(@PathVariable Long id, @RequestBody Rol rol){
        Optional<Rol> ORol = rolServiceI.findById(id); 
        if (ORol.isPresent()) {
            Rol RegionCopy = ORol.orElseThrow();
            if (rol.getNombre() != null) {
                RegionCopy.setNombre(rol.getNombre());
            }
            rolServiceI.update(id, RegionCopy);
            return Optional.of(RegionCopy);
        }
        return Optional.empty();
    }

    @DeleteMapping("/{id}") 
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Rol> ORol =  rolServiceI.delete(id);
        if (ORol.isPresent()) {
            return ResponseEntity.ok(ORol.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/verificarPermiso")
    public String verificarPermiso() {
        boolean tienePermiso = rolServiceI.validarPermiso("Admin", "READ_ALL_PRODUCTS");
        
        if (tienePermiso) {
            return "El rol tiene permiso para leer todos los productos.";
        } else {
            return "El rol no tiene permiso.";
        }
    }
}
