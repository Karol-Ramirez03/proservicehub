package com.servimax.proservicehub.infrastructure.repository.estadoAprobacion;

import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.EstadoAprobacion;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface EstadoAprobacionRepositoryI extends CrudRepository<EstadoAprobacion,Long>{
    Optional<EstadoAprobacion> findByNombre(String nombre);
}
