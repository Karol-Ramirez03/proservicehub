package com.servimax.proservicehub.application.service;

import java.util.List;
import java.util.Optional;

import com.servimax.proservicehub.domain.entity.Ciudad;

public interface CiudadServiceI {
    List<Ciudad> findAll();
    Optional<Ciudad> findById(Long id);
    Ciudad save(Ciudad Ciudad);
    Optional<Ciudad> update(Long id, Ciudad Ciudad);
    Optional<Ciudad> delete(Long id);
}
