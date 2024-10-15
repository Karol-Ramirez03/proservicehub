package com.servimax.proservicehub.application.service;

import java.util.List;
import java.util.Optional;

import com.servimax.proservicehub.domain.entity.TipoPersona;

public interface TipoPersonaServiceI {
    List<TipoPersona> findAll();
    Optional<TipoPersona> findById(Long id);
    TipoPersona save(TipoPersona TipoPersona);
    Optional<TipoPersona> update(Long id, TipoPersona TipoPersona);
    Optional<TipoPersona> delete(Long id);

}
