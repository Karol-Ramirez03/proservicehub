package com.servimax.proservicehub.application.service;

import java.util.List;
import java.util.Optional;

import com.servimax.proservicehub.domain.entity.Servicio;

public interface ServicioServiceI {
    List<Servicio> findAll();
    Optional<Servicio> findById(Long id);
    Servicio save(Servicio servicio);
    Optional<Servicio> update(Integer id, Servicio servicio);
    Optional<Servicio> delete(Integer id);
}