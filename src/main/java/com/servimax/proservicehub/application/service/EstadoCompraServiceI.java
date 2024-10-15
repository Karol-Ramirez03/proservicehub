package com.servimax.proservicehub.application.service;

import java.util.Optional;
import java.util.List;

import com.servimax.proservicehub.domain.entity.EstadoCompra;

public interface EstadoCompraServiceI {
    List<EstadoCompra> findAll();
    Optional<EstadoCompra> findById(Long id);
    EstadoCompra save(EstadoCompra estadoCompra);
    Optional<EstadoCompra> update(Long id, EstadoCompra estadoCompra);
    Optional<EstadoCompra> delete(Long id);
}
