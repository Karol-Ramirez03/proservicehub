package com.servimax.proservicehub.infrastructure.controller;

import java.util.Optional;
import java.util.ArrayList;
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

import com.servimax.proservicehub.application.service.DetalleCompraServiceI;
import com.servimax.proservicehub.domain.dto.InsumoDTO;
import com.servimax.proservicehub.domain.entity.Compra;
import com.servimax.proservicehub.domain.entity.DetalleCompra;
import com.servimax.proservicehub.domain.entity.Insumo;
import com.servimax.proservicehub.infrastructure.repository.compra.CompraRepositoryI;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/detallecompra")
public class DetalleCompraController {

    @Autowired
    private DetalleCompraServiceI detalleCompraServiceI;

    @Autowired
    private CompraRepositoryI compraRepositoryI;

    @GetMapping
    public List<DetalleCompra> list(){
        return  detalleCompraServiceI.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<DetalleCompra> ODetalleCompra = detalleCompraServiceI.findById(id);
        if (ODetalleCompra.isPresent()) {
            return ResponseEntity.ok(ODetalleCompra.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<?> create(@Valid @RequestBody DetalleCompra detalleCompra, BindingResult result) {
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleCompraServiceI.save(detalleCompra));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody DetalleCompra detalleCompra, @PathVariable Long id, BindingResult result) {
        Optional<DetalleCompra> ODetalleCompra = detalleCompraServiceI.update(id, detalleCompra);
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        if (ODetalleCompra.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(ODetalleCompra.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<DetalleCompra> ODetalleCompra = detalleCompraServiceI.delete(id);
        if (ODetalleCompra.isPresent()) {
            return ResponseEntity.ok(ODetalleCompra.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/compra/{compraId}")
    public ResponseEntity<List<DetalleCompra>> findByPersonaId(@PathVariable Long compraId) {
        // Primero, busca la comprapor ID
        Optional<Compra> compra = compraRepositoryI.findById(compraId);
        if (compra == null) {
            return ResponseEntity.notFound().build(); // Retorna 404 si la persona no se encuentra
        }
        Compra newCompra= compra.get();
        // Busca las compras asociadas a la persona
        List<DetalleCompra> detaOrden = detalleCompraServiceI.findByCompra(newCompra);
        if (detaOrden.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna 204 si no hay compras
        }
        
        return ResponseEntity.ok(detaOrden); // Retorna 200 con las compras
    }

    @GetMapping("/top3")
    public List<InsumoDTO> obtener3insumos() {
        List<InsumoDTO> ListaTop3 = new ArrayList<>();
        List<Object[]> resultados = detalleCompraServiceI.obtenerTop3InsumosVendidos();
        for (Object[] resultado : resultados) {
            Insumo insumo = (Insumo) resultado[0];
            Long totalVendido = (Long) resultado[1];

            InsumoDTO newInsumo = new InsumoDTO(totalVendido, insumo);
            ListaTop3.add(newInsumo);
        }
        return ListaTop3;
    }

    @GetMapping("/top3menos")
    public List<InsumoDTO> obtener3insumosmenos() {
        List<InsumoDTO> ListaTop3menos = new ArrayList<>();
        List<Object[]> resultados = detalleCompraServiceI.obtenerTop3InsumosMenosVendidos();
        for (Object[] resultado : resultados) {
            Insumo insumo = (Insumo) resultado[0];
            Long totalVendido = (Long) resultado[1];

            InsumoDTO newInsumo = new InsumoDTO(totalVendido, insumo);
            ListaTop3menos.add(newInsumo);
        }
        return ListaTop3menos;
    }

}
