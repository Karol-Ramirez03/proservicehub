package com.servimax.proservicehub.application.service;

import java.util.List;
import java.util.Optional;

import com.servimax.proservicehub.domain.entity.Direccion;

public interface DireccionServiceI {
    List<Direccion> findAll();
    Optional<Direccion> findById(Long id);
    Direccion save(Direccion Direccion);
    Optional<Direccion> update(Long id, Direccion Direccion);
    Optional<Direccion> delete(Long id);
}
