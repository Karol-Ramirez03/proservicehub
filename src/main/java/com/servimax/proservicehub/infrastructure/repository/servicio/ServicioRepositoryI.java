package com.servimax.proservicehub.infrastructure.repository.servicio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.Servicio;

@Repository
public interface ServicioRepositoryI extends CrudRepository<Servicio,Long>{

}
