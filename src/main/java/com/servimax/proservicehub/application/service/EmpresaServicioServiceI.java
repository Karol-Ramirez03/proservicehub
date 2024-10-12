package com.servimax.proservicehub.application.service;

import java.util.List;
import java.util.Optional;

import com.servimax.proservicehub.domain.entity.EmpresaServicio;
import com.servimax.proservicehub.domain.entity.EmpresaServicioPk;

public interface EmpresaServicioServiceI {
    List<EmpresaServicio> findAll();
    Optional<EmpresaServicio> findById(EmpresaServicioPk id);
    EmpresaServicio save(EmpresaServicio EmpresaServicio);
    Optional<EmpresaServicio> update(EmpresaServicioPk id, EmpresaServicio EmpresaServicio);
    Optional<EmpresaServicio> delete(EmpresaServicioPk id);
}
