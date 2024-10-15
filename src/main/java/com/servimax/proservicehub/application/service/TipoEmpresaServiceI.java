package com.servimax.proservicehub.application.service;

import java.util.List;
import java.util.Optional;

import com.servimax.proservicehub.domain.entity.TipoEmpresa;

public interface TipoEmpresaServiceI {
    List<TipoEmpresa> findAll();
    Optional<TipoEmpresa> findById(Long id);
    TipoEmpresa save(TipoEmpresa tipoEmpresa);
    Optional<TipoEmpresa> update(Long id, TipoEmpresa tipoEmpresa);
    Optional<TipoEmpresa> delete(Long id);
}
