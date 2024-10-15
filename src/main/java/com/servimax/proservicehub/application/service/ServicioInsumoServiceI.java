package com.servimax.proservicehub.application.service;

import java.util.List;
import java.util.Optional;

import com.servimax.proservicehub.domain.entity.ServicioInsumo;

public interface ServicioInsumoServiceI {
    List<ServicioInsumo> findAll();
    Optional<ServicioInsumo> findById(Long idInsumo,Long idServicio);
    ServicioInsumo save(ServicioInsumo servicioInsumo);
    Optional<ServicioInsumo> update(Long idInsumo,Long idServicio, ServicioInsumo servicioInsumo);
    Optional<ServicioInsumo> delete(Long idInsumo,Long idServicio);
}
