package com.servimax.proservicehub.infrastructure.repository.servicio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.Servicio;

@Repository
public interface ServicioRepositoryI extends CrudRepository<Servicio,Long>{
    Optional<Servicio> findByNombre(String nombre);
}
