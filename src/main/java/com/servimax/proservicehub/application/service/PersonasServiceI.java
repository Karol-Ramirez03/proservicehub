package com.servimax.proservicehub.application.service;

import java.util.List;
import java.util.Optional;

import com.servimax.proservicehub.domain.entity.Personas;

public interface PersonasServiceI {

    List<Personas> findAll();
    Optional<Personas> findById(Long nroDoc);
    Personas save(Personas persona);
    Optional<Personas> update(Long nroDoc, Personas persona);
    Optional<Personas> delete(Long nroDoc);
    List<Object[]> infoPersona(Long id);
    List<Object[]> top3MasInversion();
}

