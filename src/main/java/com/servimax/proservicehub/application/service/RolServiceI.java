package com.servimax.proservicehub.application.service;

import java.util.List;
import java.util.Optional;

import com.servimax.proservicehub.domain.entity.Rol;

public interface  RolServiceI {

    List<Rol> findAll();
    Optional<Rol> findById(Long id);
    Rol save(Rol rol);
    Optional<Rol> update(Long id, Rol rol);
    Optional<Rol> delete(Long id);
}

