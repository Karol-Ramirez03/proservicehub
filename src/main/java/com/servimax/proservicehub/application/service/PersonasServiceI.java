package com.servimax.proservicehub.application.service;

import java.util.List;
import java.util.Optional;

import com.servimax.proservicehub.domain.entity.Personas;

public interface PersonasServiceI {

    List<Personas> findAll();
    Optional<Personas> findById(Long id);
    Personas save(Personas Personas);
    Optional<Personas> update(Long id, Personas Personas);
    Optional<Personas> delete(Long id);
}

