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

import com.servimax.proservicehub.application.service.EmpresaServicioServiceI;
import com.servimax.proservicehub.domain.entity.EmpresaServicio;
import com.servimax.proservicehub.domain.entity.EmpresaServicioPk;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/empresaServicio")
public class EmpresaServicioController {

    
    @Autowired
    private EmpresaServicioServiceI EmpresaServicioServiceI;

    @GetMapping
    public List<EmpresaServicio> list() {
        return EmpresaServicioServiceI.findAll();
    }

    @GetMapping("/{IdSucursal}/{IdServicio}")
    public ResponseEntity<?> view(@PathVariable Long IdSucursal, @PathVariable Long IdServicio) {
        EmpresaServicioPk id = new EmpresaServicioPk(IdSucursal, IdServicio);
        Optional<EmpresaServicio> EmpresaServicioOptional = EmpresaServicioServiceI.findById(id);
        if (EmpresaServicioOptional.isPresent()) {
            return ResponseEntity.ok(EmpresaServicioOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody EmpresaServicio EmpresaServicio, BindingResult result) {
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(EmpresaServicioServiceI.save(EmpresaServicio));
    }


    @PutMapping("/{IdSucursal}/{IdServicio}")
    public Optional<EmpresaServicio> update(@PathVariable Long IdSucursal, @PathVariable Long IdServicio, @RequestBody EmpresaServicio EmpresaServicio){
        EmpresaServicioPk id = new EmpresaServicioPk(IdSucursal, IdServicio);
        Optional<EmpresaServicio> compranew = EmpresaServicioServiceI.findById(id);
        if (compranew.isPresent()) {
            EmpresaServicio EmpresaServicioCopy = compranew.get();
            if (EmpresaServicio.getServicio() != null) {
                EmpresaServicioCopy.setServicio(EmpresaServicio.getServicio());
            }
            if (EmpresaServicio.getSucursal() != null) {
                EmpresaServicioCopy.setSucursal(EmpresaServicio.getSucursal());
            }
            if (EmpresaServicio.getValorServicio() != null) {
                EmpresaServicioCopy.setValorServicio(EmpresaServicio.getValorServicio());
            }

            EmpresaServicioServiceI.update(id, EmpresaServicioCopy);
            return Optional.of(EmpresaServicioCopy);
            
        }
        return Optional.empty();

    }

    @DeleteMapping("/{IdSucursal}/{IdServicio}")
    public ResponseEntity<?> delete(@PathVariable Long IdSucursal, @PathVariable Long IdServicio) {
        EmpresaServicioPk id = new EmpresaServicioPk(IdSucursal, IdServicio);
        Optional<EmpresaServicio> EmpresaServicioOptional = EmpresaServicioServiceI.delete(id);
        if (EmpresaServicioOptional.isPresent()) {
            return ResponseEntity.ok(EmpresaServicioOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }



}
