package com.servimax.proservicehub.application.service;

import java.util.List;
import java.util.Optional;

import com.servimax.proservicehub.domain.entity.EmpresaServicio;

public interface EmpresaServicioServiceI {
    List<EmpresaServicio> findAll();
    Optional<EmpresaServicio> findById(Long  idSucursal, Long idServicio);
    EmpresaServicio save(EmpresaServicio EmpresaServicio);
    Optional<EmpresaServicio> update(Long  idSucursal, Long idServicio, EmpresaServicio EmpresaServicio);
    Optional<EmpresaServicio> delete(Long  idSucursal, Long idServicio);
}
