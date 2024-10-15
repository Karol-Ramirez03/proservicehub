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

import com.servimax.proservicehub.application.service.RegionServiceI;
import com.servimax.proservicehub.domain.entity.Region;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/region")
public class RegionController {

    @Autowired
    private RegionServiceI RegionServiceI;

    @GetMapping
    public List<Region> list(){
        return RegionServiceI.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<Region> RegionOpt = RegionServiceI.findById(id);
        if (RegionOpt.isPresent()) {
            return ResponseEntity.ok(RegionOpt.orElseThrow());
        }   
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Region Region, BindingResult result){
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(RegionServiceI.save(Region));
    }

    @PutMapping("/{id}")
    public Optional<Region> Update(@PathVariable Long id, @RequestBody Region Region){
        Optional<Region> RegionId = RegionServiceI.findById(id); 
        if (RegionId.isPresent()) {
            Region RegionCopy = RegionId.orElseThrow();
            if (Region.getNombre() != null) {
                RegionCopy.setNombre(Region.getNombre());
            }
            RegionServiceI.update(id, RegionCopy);
            return Optional.of(RegionCopy);
        }
        return Optional.empty();
    }

    @DeleteMapping("/{id}") 
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Region> RegionId =  RegionServiceI.delete(id);
        if (RegionId.isPresent()) {
            return ResponseEntity.ok(RegionId.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
