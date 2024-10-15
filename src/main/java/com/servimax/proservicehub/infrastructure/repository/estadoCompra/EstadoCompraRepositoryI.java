package com.servimax.proservicehub.infrastructure.repository.estadoCompra;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.EstadoCompra;

@Repository
public interface EstadoCompraRepositoryI extends CrudRepository<EstadoCompra,Long>{

}
