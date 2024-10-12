package com.servimax.proservicehub.infrastructure.repository.estadoorden;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.EstadoOrden;

@Repository
public interface EstadoOrdenRepositoryI extends CrudRepository<EstadoOrden, Long>{

}
