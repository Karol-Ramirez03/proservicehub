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

import com.servimax.proservicehub.application.service.TipoCompraServiceI;
import com.servimax.proservicehub.domain.entity.TipoCompra;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/tipocompra")
public class TipoCompraController {

    @Autowired
    private TipoCompraServiceI tipoCompraServiceI;

    @GetMapping
    public List<TipoCompra> list(){
        return  tipoCompraServiceI.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<TipoCompra> OTipoCompra = tipoCompraServiceI.findById(id);
        if (OTipoCompra.isPresent()){
            return ResponseEntity.ok(OTipoCompra.orElseThrow());
        }
        return  ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<?> create(@Valid @RequestBody TipoCompra tipoCompra, BindingResult result){
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
            
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoCompraServiceI.save(tipoCompra));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody TipoCompra tipoCompra, @PathVariable Long id, BindingResult result) {
        Optional<TipoCompra> OTipoCompra= tipoCompraServiceI.update(id, tipoCompra);
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        if (OTipoCompra.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(OTipoCompra.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<TipoCompra> OTipoCompra = tipoCompraServiceI.delete(id);
        if (OTipoCompra.isPresent()) {
            return ResponseEntity.ok(OTipoCompra.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }


}
