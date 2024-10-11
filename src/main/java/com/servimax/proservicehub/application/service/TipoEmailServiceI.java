package com.servimax.proservicehub.application.service;

import java.util.List;
import java.util.Optional;

import com.servimax.proservicehub.domain.entity.TipoEmail;

public interface TipoEmailServiceI {
    List<TipoEmail> findAll();
    Optional<TipoEmail> findById(Long id);
    TipoEmail save(TipoEmail tipoEmail);
    Optional<TipoEmail> update(Long id, TipoEmail tipoEmail);
    Optional<TipoEmail> delete(Long id);
}
