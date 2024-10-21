package com.servimax.proservicehub.application.service;

import java.util.Optional;
import java.util.List;

import com.servimax.proservicehub.domain.entity.TipoCompra;

public interface TipoCompraServiceI {
    List<TipoCompra> findAll();
    Optional<TipoCompra> findById(Long id);
    TipoCompra save(TipoCompra tipoCompra);
    Optional<TipoCompra> update(Long id, TipoCompra tipoCompra);
    Optional<TipoCompra> delete(Long id);
}
