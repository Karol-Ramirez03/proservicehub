package com.servimax.proservicehub.infrastructure.repository.detalleCompra;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servimax.proservicehub.application.service.DetalleCompraServiceI;
import com.servimax.proservicehub.domain.entity.DetalleCompra;

@Service
public class DetalleCompraImplementation implements DetalleCompraServiceI{

    @Autowired
    private DetalleCompraRepositoryI detalleCompraRepositoryI;

    @Override
    public List<DetalleCompra> findAll() {
        return ((List<DetalleCompra>) detalleCompraRepositoryI.findAll());
    }

    @Override
    public Optional<DetalleCompra> findById(Long id) {
        return detalleCompraRepositoryI.findById(id);
    }

    @Override
    public DetalleCompra save(DetalleCompra detalleCompra) {
        return detalleCompraRepositoryI.save(detalleCompra);
    }

    @Override
    public Optional<DetalleCompra> update(Long id, DetalleCompra detalleCompra) {
        Optional<DetalleCompra> OCompra = detalleCompraRepositoryI.findById(id);
        if (OCompra.isPresent()) {
            DetalleCompra detalleCompra2 = OCompra.orElseThrow();
            detalleCompra2.setPrecio_unitario(detalleCompra.getPrecio_unitario());
            detalleCompra2.setCantidad(detalleCompra.getCantidad());
            detalleCompra2.setInsumo(detalleCompra.getInsumo());
            detalleCompra2.setCompra(detalleCompra.getCompra());
            return Optional.of(detalleCompraRepositoryI.save(detalleCompra2));
            
        }
        return Optional.empty();
    }

    @Override
    public Optional<DetalleCompra> delete(Long id) {
        Optional<DetalleCompra> ODetalleCompra = detalleCompraRepositoryI.findById(id);
        ODetalleCompra.ifPresent( deCo -> {
            detalleCompraRepositoryI.delete(deCo);
        });
        return ODetalleCompra;
    }

}
