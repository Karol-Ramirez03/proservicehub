package com.servimax.proservicehub.infrastructure.controller;

import java.util.Optional;
import java.util.List;

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

import com.servimax.proservicehub.application.service.TelSucursalServiceI;
import com.servimax.proservicehub.domain.entity.TelSucursal;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/telsucursal")
public class TelSucursalController {

    @Autowired
    private TelSucursalServiceI telSucursalServiceI;

    @GetMapping
    public List<TelSucursal> list(){
        return  telSucursalServiceI.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<TelSucursal> OTelSucursal = telSucursalServiceI.findById(id);
        if (OTelSucursal.isPresent()){
            return ResponseEntity.ok(OTelSucursal.orElseThrow());
        }
        return  ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<?> create(@Valid @RequestBody TelSucursal telSucursal, BindingResult result){
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
            
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(telSucursalServiceI.save(telSucursal));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody TelSucursal telSucursal, @PathVariable Long id, BindingResult result) {
        Optional<TelSucursal> OTelSucursal= telSucursalServiceI.update(id, telSucursal);
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        if (OTelSucursal.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(OTelSucursal.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<TelSucursal> OTelSucursal = telSucursalServiceI.delete(id);
        if (OTelSucursal.isPresent()) {
            return ResponseEntity.ok(OTelSucursal.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
