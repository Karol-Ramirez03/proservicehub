package com.servimax.proservicehub.application.service;

import java.util.List;
import java.util.Optional;

import com.servimax.proservicehub.domain.entity.Pais;

public interface PaisServiceI {

    List<Pais> findAll();
    Optional<Pais> findById(Long id);
    Pais save(Pais Pais);
    Optional<Pais> update(Long id, Pais Pais);
    Optional<Pais> delete(Long id);
}
