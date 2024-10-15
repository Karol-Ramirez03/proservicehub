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

import com.servimax.proservicehub.application.service.ServicioInsumoServiceI;
import com.servimax.proservicehub.domain.entity.ServicioInsumo;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/servicioinsumo")
public class ServicioInsumoController {

    @Autowired
    private ServicioInsumoServiceI servicioInsumoServiceI;

    @GetMapping
    public List<ServicioInsumo> list(){
        return servicioInsumoServiceI.findAll();
    }

    @GetMapping("/{idInsumo}/{idservicio}")
    public ResponseEntity<?> view(@PathVariable Long idInsumo,@PathVariable  Long idservicio) {
        Optional<ServicioInsumo> ServicioInsumoOptional = servicioInsumoServiceI.findById(idInsumo,idservicio);
        if (ServicioInsumoOptional.isPresent()) {
            return ResponseEntity.ok(ServicioInsumoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

        
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ServicioInsumo ServicioInsumo, BindingResult result) {
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(servicioInsumoServiceI.save(ServicioInsumo));
    }

    @PutMapping("/{idInsumo}/{idservicio}")
    public ResponseEntity<?> update(@Valid @RequestBody ServicioInsumo ServicioInsumo, @PathVariable Long idInsumo,@PathVariable  Long idservicio, BindingResult result) {
        Optional<ServicioInsumo> ServicioInsumoOptional = servicioInsumoServiceI.update(idInsumo,idservicio, ServicioInsumo);
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        if (ServicioInsumoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(ServicioInsumoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idInsumo}/{idservicio}")
    public ResponseEntity<?> delete(@PathVariable Long idInsumo,@PathVariable  Long idservicio) {
        Optional<ServicioInsumo> ServicioInsumoOptional = servicioInsumoServiceI.delete(idInsumo,idservicio);
        if (ServicioInsumoOptional.isPresent()) {
            return ResponseEntity.ok(ServicioInsumoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
