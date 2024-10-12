package com.servimax.proservicehub.application.service;

import java.util.List;
import java.util.Optional;

import com.servimax.proservicehub.domain.entity.Servicio;
import com.servimax.proservicehub.domain.entity.ServicioInsumo;

public interface ServicioInsumoServiceI {
    List<ServicioInsumo> findAll();
    // Optional<Servicio> findById(Long id);
    ServicioInsumo save(ServicioInsumo servicioInsumo);
    // Optional<Servicio> update(Long id, Servicio servicio);
    // Optional<Servicio> delete(Long id);
}
