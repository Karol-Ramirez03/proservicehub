package com.servimax.proservicehub.infrastructure.repository.ordenServicio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.OrdenServicio;

@Repository
public interface OrdenServicioRepositoryI extends CrudRepository<OrdenServicio,Long>{

}
