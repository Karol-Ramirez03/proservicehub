package com.servimax.proservicehub.application.service;

import java.util.List;
import java.util.Optional;

import com.servimax.proservicehub.domain.entity.TelPersona;

public interface TelPersonaServiceI {
    List<TelPersona> findAll();
    Optional<TelPersona> findById(Long id);
    TelPersona save(TelPersona TelPersona);
    Optional<TelPersona> update(Long id, TelPersona TelPersona);
    Optional<TelPersona> delete(Long id);
}
