package com.servimax.proservicehub.infrastructure.repository.aprobacionServicio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.AprobacionServicio;

@Repository
public interface AprobacionServicioRepositoryI extends CrudRepository<AprobacionServicio,Long>{

}
