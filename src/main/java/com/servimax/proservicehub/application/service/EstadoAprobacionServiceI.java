package com.servimax.proservicehub.application.service;

import java.util.List;
import java.util.Optional;

import com.servimax.proservicehub.domain.entity.EstadoAprobacion;

public interface EstadoAprobacionServiceI {
    List<EstadoAprobacion> findAll();
    Optional<EstadoAprobacion> findById(Long id);
    EstadoAprobacion save(EstadoAprobacion estadoAprobacion);
    Optional<EstadoAprobacion> update(Long id, EstadoAprobacion estadoAprobacion);
    Optional<EstadoAprobacion> delete(Long id);
}
