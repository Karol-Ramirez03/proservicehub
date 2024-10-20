package com.servimax.proservicehub.infrastructure.repository.detalleCompra;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.Compra;
import com.servimax.proservicehub.domain.entity.DetalleCompra;

@Repository
public interface DetalleCompraRepositoryI extends CrudRepository<DetalleCompra,Long>{
    List<DetalleCompra> findByCompra(Compra compra);

    @Query("SELECT d.insumo, SUM(d.cantidad) AS totalVendido FROM DetalleCompra d JOIN d.compra c GROUP BY d.insumo ORDER BY totalVendido DESC LIMIT 3")
    List<Object[]> findTop3InsumosVendidos();

    @Query("SELECT d.insumo, SUM(d.cantidad) AS totalVendido FROM DetalleCompra d JOIN d.compra c GROUP BY d.insumo ORDER BY totalVendido ASC LIMIT 3")
    List<Object[]> findTop3InsumosMenosVendidos();
}
