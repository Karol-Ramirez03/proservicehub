package com.servimax.proservicehub.application.service;

import java.util.Optional;
import java.util.List;

import com.servimax.proservicehub.domain.entity.EstadoOrden;

public interface EstadoOrdenServiceI {
    List<EstadoOrden> findAll();
    Optional<EstadoOrden> findById(Long id);
    EstadoOrden save(EstadoOrden estadoOrden);
    Optional<EstadoOrden> update(Long id, EstadoOrden estadoOrden);
    Optional<EstadoOrden> delete(Long id);
}
