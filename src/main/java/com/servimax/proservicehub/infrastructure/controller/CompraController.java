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

import com.servimax.proservicehub.application.service.CompraServiceI;
import com.servimax.proservicehub.application.service.PersonasServiceI;
import com.servimax.proservicehub.application.service.TipoCompraServiceI;
import com.servimax.proservicehub.domain.dto.CompraDTO;
import com.servimax.proservicehub.domain.entity.Compra;
import com.servimax.proservicehub.domain.entity.Personas;
import com.servimax.proservicehub.domain.entity.TipoCompra;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/compra")
public class CompraController {


    @Autowired
    private CompraServiceI compraServiceI;

    @Autowired
    private PersonasServiceI personasServiceI;

    @Autowired
    private TipoCompraServiceI tipoCompraServiceI;

    @GetMapping
    public List<Compra> list(){
        return  compraServiceI.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Compra> OCompra = compraServiceI.findById(id);
        if (OCompra.isPresent()) {
            return ResponseEntity.ok(OCompra.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<?> create(@Valid @RequestBody Compra compra, BindingResult result) {
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(compraServiceI.save(compra));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Compra compra, @PathVariable Long id, BindingResult result) {
        Optional<Compra> OCompra = compraServiceI.update(id, compra);
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        if (OCompra.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(OCompra.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Compra> OCompra = compraServiceI.delete(id);
        if (OCompra.isPresent()) {
            return ResponseEntity.ok(OCompra.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/persona/{personaId}")
    public ResponseEntity<List<Compra>> findByPersonaId(@PathVariable Long personaId) {
        // Primero, busca la persona por ID
        Optional<Personas> persona = personasServiceI.findById(personaId);
        if (persona == null) {
            return ResponseEntity.notFound().build(); // Retorna 404 si la persona no se encuentra
        }
        Personas newPersona=persona.get();
        // Busca las compras asociadas a la persona
        List<Compra> compras = compraServiceI.findByPersonasId(newPersona);
        if (compras.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna 204 si no hay compras
        }
        
        return ResponseEntity.ok(compras); // Retorna 200 con las compras
    }

    @GetMapping("/{compraId}/estado/nombre")
    public ResponseEntity<String> obtenerNombreEstado(@PathVariable Long compraId) {
        String nombreEstado = compraServiceI.obtenerNombreEstado(compraId);
        return ResponseEntity.ok(nombreEstado);
    }

    @PostMapping("/agregar")
    public ResponseEntity<Void> addOrdenSaddComprayDetalleervicio(@RequestBody CompraDTO compraDTO) {
        compraServiceI.addComprayDetalle(compraDTO.getIdCliente(), compraDTO.getIdProducto(), compraDTO.getCantidad(), compraDTO.getTipo_compra());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/tipocompra/{tipoCompraId}")
    public ResponseEntity<List<Compra>> findByTipoCompraId(@PathVariable Long tipoCompraId) {
        // Primero, busca la persona por ID
        Optional<TipoCompra> tipoCompra = tipoCompraServiceI.findById(tipoCompraId);
        if (tipoCompra == null) {
            return ResponseEntity.notFound().build(); // Retorna 404 si la persona no se encuentra
        }
        TipoCompra newTipo=tipoCompra.get();
        // Busca las compras asociadas a la persona
        List<Compra> compras = compraServiceI.findByTipoCompraId(newTipo);
        if (compras.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna 204 si no hay compras
        }
        
        return ResponseEntity.ok(compras); // Retorna 200 con las compras
    }

    @PostMapping("/actualizarestadocompra/{compraid}")
    public void actualizarEstadocompra(@PathVariable int compraid) {
        compraServiceI.actualizarEstadocompra(compraid);
    }
    
}
