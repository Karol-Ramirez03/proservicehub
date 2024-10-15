package com.servimax.proservicehub.application.service;

import java.util.List;
import java.util.Optional;

import com.servimax.proservicehub.domain.entity.OrdenTrabajo;

public interface OrdenTrabajoServiceI {

    List<OrdenTrabajo> findAll();
    Optional<OrdenTrabajo> findById(Long id);
    OrdenTrabajo save(OrdenTrabajo ordenServicio);
    Optional<OrdenTrabajo> update(Long id, OrdenTrabajo ordenServicio);
    Optional<OrdenTrabajo> delete(Long id);
}
