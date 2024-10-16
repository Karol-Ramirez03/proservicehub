package com.servimax.proservicehub.application.service;

import java.util.List;
import java.util.Optional;

import com.servimax.proservicehub.domain.entity.EstadoOrdenServicio;

public interface EstadoSerOrdenServiceI {

    List<EstadoOrdenServicio> findAll();
    Optional<EstadoOrdenServicio> findById(Long id);
    EstadoOrdenServicio save(EstadoOrdenServicio estadoOrdenServicio);
    Optional<EstadoOrdenServicio> update(Long id, EstadoOrdenServicio estadoOrdenServicio);
    Optional<EstadoOrdenServicio> delete(Long id);
}
