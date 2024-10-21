package com.servimax.proservicehub.application.service;

import java.util.List;
import java.util.Optional;

import com.servimax.proservicehub.domain.entity.Insumo;

public interface InsumoServiceI {
    List<Insumo> findAll();
    Optional<Insumo> findById(Long id);
    Insumo save(Insumo insumo);
    Optional<Insumo> update(Long id, Insumo insumo);
    Optional<Insumo> delete(Long id);
    int verificarStock(int insumoId, int cantidadSolicitada);
}
