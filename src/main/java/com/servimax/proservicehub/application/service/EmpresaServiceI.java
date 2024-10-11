package com.servimax.proservicehub.application.service;

import java.util.List;
import java.util.Optional;

import com.servimax.proservicehub.domain.entity.Empresa;

public interface EmpresaServiceI {
    List<Empresa> findAll();
    Optional<Empresa> findById(Long id);
    Empresa save(Empresa Empresa);
    Optional<Empresa> update(Long id, Empresa empresa);
    Optional<Empresa> delete(Long id);
}
