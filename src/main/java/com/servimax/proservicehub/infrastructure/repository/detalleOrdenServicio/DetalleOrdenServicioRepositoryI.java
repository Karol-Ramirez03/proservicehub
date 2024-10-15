package com.servimax.proservicehub.infrastructure.repository.detalleOrdenServicio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.DetalleOrdenServicio;

@Repository
public interface DetalleOrdenServicioRepositoryI extends CrudRepository<DetalleOrdenServicio, Long>{

}
