package com.servimax.proservicehub.application.service;

import java.util.Optional;
import java.util.List;

import com.servimax.proservicehub.domain.entity.TelSucursal;

public interface TelSucursalServiceI {
    List<TelSucursal> findAll();
    Optional<TelSucursal> findById(Long id);
    TelSucursal save(TelSucursal telSucursal);
    Optional<TelSucursal> update(Long id, TelSucursal telSucursal);
    Optional<TelSucursal> delete(Long id);
}
