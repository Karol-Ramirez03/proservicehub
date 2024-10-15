package com.servimax.proservicehub.infrastructure.repository.estadoCompra;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servimax.proservicehub.application.service.EstadoCompraServiceI;
import com.servimax.proservicehub.domain.entity.EstadoCompra;

@Service
public class EstadoCompraImplementation implements EstadoCompraServiceI{

    @Autowired
    private EstadoCompraRepositoryI estadoCompraRepositoryI;

    @Override
    public List<EstadoCompra> findAll() {
        return ((List<EstadoCompra>)estadoCompraRepositoryI.findAll());
    }

    @Override
    public Optional<EstadoCompra> findById(Long id) {
        return estadoCompraRepositoryI.findById(id);
    }

    @Override
    public EstadoCompra save(EstadoCompra estadoCompra) {
        return estadoCompraRepositoryI.save(estadoCompra);
    }

    @Override
    public Optional<EstadoCompra> update(Long id, EstadoCompra estadoCompra) {
        Optional<EstadoCompra> OEstadoCompra = estadoCompraRepositoryI.findById(id);
        if (OEstadoCompra.isPresent()) {
            EstadoCompra estadoCompra2 = OEstadoCompra.orElseThrow();
            estadoCompra2.setNombre(estadoCompra.getNombre());
            return Optional.of(estadoCompraRepositoryI.save(estadoCompra2));
        }
        return Optional.empty();
    }

    @Override
    public Optional<EstadoCompra> delete(Long id) {
        Optional<EstadoCompra> OEstadoCompra = estadoCompraRepositoryI.findById(id);
        OEstadoCompra.ifPresent( estaCo -> {
            estadoCompraRepositoryI.delete(estaCo);
        });
        return OEstadoCompra;
    }

}
