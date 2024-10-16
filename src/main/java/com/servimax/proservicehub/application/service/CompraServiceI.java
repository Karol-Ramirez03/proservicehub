package com.servimax.proservicehub.application.service;

import java.util.List;
import java.util.Optional;

import com.servimax.proservicehub.domain.entity.Compra;
import com.servimax.proservicehub.domain.entity.Personas;
public interface CompraServiceI {
    List<Compra> findAll();
    Optional<Compra> findById(Long id);
    Compra save(Compra compra);
    Optional<Compra> update(Long id, Compra compra);
    Optional<Compra> delete(Long id);
    List<Compra> findByPersonasId(Personas personasId);
    String obtenerNombreEstado(Long id);
}
