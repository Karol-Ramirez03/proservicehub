package com.servimax.proservicehub.application.service;

import java.util.List;
import java.util.Optional;

import com.servimax.proservicehub.domain.entity.OrdenServicio;
import com.servimax.proservicehub.domain.entity.Personas;

public interface OrdenServicioServiceI {
    List<OrdenServicio> findAll();
    Optional<OrdenServicio> findById(Long id);
    OrdenServicio save(OrdenServicio ordenServicio);
    Optional<OrdenServicio> update(Long id, OrdenServicio ordenServicio);
    Optional<OrdenServicio> delete(Long id);
    List<OrdenServicio> findByPersonasId(Personas personasId);
    void addOrdenServicio(Long idCliente,Long idservicio);
}
