package com.servimax.proservicehub.application.service;

import java.util.List;
import java.util.Optional;

import com.servimax.proservicehub.domain.entity.Sucursal;

public interface SucursalServiceI {
    List<Sucursal> findAll();
    Optional<Sucursal> findById(Long id);
    Sucursal save(Sucursal Sucursal);
    Optional<Sucursal> update(Long id, Sucursal Sucursal);
    Optional<Sucursal> delete(Long id);
}
