package com.servimax.proservicehub.infrastructure.repository.detalleCompra;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.DetalleCompra;

@Repository
public interface DetalleCompraRepositoryI extends CrudRepository<DetalleCompra,Long>{

}
