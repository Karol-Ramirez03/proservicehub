package com.servimax.proservicehub.infrastructure.repository.servicio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.Servicio;

@Repository
public interface ServicioRepositoryI extends CrudRepository<Servicio,Long>{

}
