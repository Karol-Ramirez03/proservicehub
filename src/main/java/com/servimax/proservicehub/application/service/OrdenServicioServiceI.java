package com.servimax.proservicehub.application.service;

import java.util.Optional;
import java.util.List;

import com.servimax.proservicehub.domain.entity.OrdenServicio;

public interface OrdenServicioServiceI {
    List<OrdenServicio> findAll();
    Optional<OrdenServicio> findById(Long id);
    OrdenServicio save(OrdenServicio ordenServicio);
    Optional<OrdenServicio> update(Long id, OrdenServicio ordenServicio);
    Optional<OrdenServicio> delete(Long id);
    List<OrdenServicio> findByEstadoId(Long estadoId);
}
