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

import com.servimax.proservicehub.application.service.InsumoServiceI;
import com.servimax.proservicehub.domain.dto.ValidarStockRequest;
import com.servimax.proservicehub.domain.entity.Insumo;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/insumo")
public class InsumoController {

    @Autowired
    private InsumoServiceI InsumoServiceI;

    @GetMapping
    public List<Insumo> list(){
        return InsumoServiceI.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<Insumo> InsumoOpt = InsumoServiceI.findById(id);
        if (InsumoOpt.isPresent()) {
            return ResponseEntity.ok(InsumoOpt.orElseThrow());
        }   
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Insumo Insumo, BindingResult result){
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(InsumoServiceI.save(Insumo));
    }

    @PutMapping("/{id}")
    public Optional<Insumo> Update(@PathVariable Long id, @RequestBody Insumo Insumo){
        Optional<Insumo> InsumoId = InsumoServiceI.findById(id); 
        if (InsumoId.isPresent()) {
            Insumo InsumoCopy = InsumoId.orElseThrow();
            if (Insumo.getCodigo_interno() != null) {
                InsumoCopy.setCodigo_interno(Insumo.getCodigo_interno());
            }
            if (Insumo.getNombre() != null) {
                InsumoCopy.setNombre(Insumo.getNombre());
            }
            if (Insumo.getPrecio_unitario() != null) {
                InsumoCopy.setPrecio_unitario(Insumo.getPrecio_unitario());
            }
            if (Insumo.getStock() != 0) {
                InsumoCopy.setStock(Insumo.getStock());
            }
            if (Insumo.getStock_maximo() != 0) {
                InsumoCopy.setStock_maximo(Insumo.getStock_maximo());
            }
            if (Insumo.getStock_minimo() != 0) {
                InsumoCopy.setStock_minimo(Insumo.getStock_minimo());
            }
            InsumoServiceI.update(id, InsumoCopy);
            return Optional.of(InsumoCopy);
        }
        return Optional.empty();
    }

    @DeleteMapping("/{id}") 
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Insumo> InsumoId =  InsumoServiceI.delete(id);
        if (InsumoId.isPresent()) {
            return ResponseEntity.ok(InsumoId.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/validar-stock")
    public int validarStock(@RequestBody ValidarStockRequest request) {
        return InsumoServiceI.verificarStock(request.getInsumoId(), request.getCantidadSolicitada());
    }

    @PostMapping("/actualizar-stock")
    public void actualizarStock(@RequestBody ValidarStockRequest request) {
        InsumoServiceI.actualizarStock(request.getInsumoId(), request.getCantidadSolicitada());
    }

    @PostMapping("/actualizar-stock-proveedor")
    public void actualizarStockProveedor(@RequestBody ValidarStockRequest request) {
        InsumoServiceI.actualizarStockProveedor(request.getInsumoId(), request.getCantidadSolicitada());
    }
}
