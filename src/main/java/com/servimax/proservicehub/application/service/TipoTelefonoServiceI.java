package com.servimax.proservicehub.application.service;

import java.util.List;
import java.util.Optional;

import com.servimax.proservicehub.domain.entity.TipoTelefono;

public interface TipoTelefonoServiceI {
    List<TipoTelefono> findAll();
    Optional<TipoTelefono> findById(Long id);
    TipoTelefono save(TipoTelefono tipoTelefono);
    Optional<TipoTelefono> update(Long id, TipoTelefono tipoTelefono);
    Optional<TipoTelefono> delete(Long id);
}
