package com.servimax.proservicehub.application.service;

import java.util.Optional;
import java.util.List;

import com.servimax.proservicehub.domain.entity.Compra;
import com.servimax.proservicehub.domain.entity.DetalleCompra;

public interface DetalleCompraServiceI {
    List<DetalleCompra> findAll();
    Optional<DetalleCompra> findById(Long id);
    DetalleCompra save(DetalleCompra detalleCompra);
    Optional<DetalleCompra> update(Long id, DetalleCompra detalleCompra);
    Optional<DetalleCompra> delete(Long id);
    List<DetalleCompra> findByCompra(Compra conpra);
    List<Object[]> obtenerTop3InsumosVendidos();
    List<Object[]> obtenerTop3InsumosMenosVendidos();
}
