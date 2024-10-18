package com.servimax.proservicehub.application.service;

import java.util.List;
import java.util.Optional;

import com.servimax.proservicehub.domain.entity.DetalleOrdenTrabajo;

public interface DetalleOrdenTrabajoServiceI {

    List<DetalleOrdenTrabajo> findAll();
    Optional<DetalleOrdenTrabajo> findById(Long id);
    DetalleOrdenTrabajo save(DetalleOrdenTrabajo detalleOrdenTrabajo);
    Optional<DetalleOrdenTrabajo> update(Long id, DetalleOrdenTrabajo detalleOrdenTrabajo);
    Optional<DetalleOrdenTrabajo> delete(Long id);
    List<DetalleOrdenTrabajo> findByIdEmpleado(long estadoId);

}
