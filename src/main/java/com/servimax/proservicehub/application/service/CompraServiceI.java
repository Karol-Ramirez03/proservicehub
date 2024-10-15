package com.servimax.proservicehub.application.service;

import java.util.Optional;
import java.util.List;

import com.servimax.proservicehub.domain.entity.Compra;

public interface CompraServiceI {
    List<Compra> findAll();
    Optional<Compra> findById(Long id);
    Compra save(Compra compra);
    Optional<Compra> update(Long id, Compra compra);
    Optional<Compra> delete(Long id);
}
