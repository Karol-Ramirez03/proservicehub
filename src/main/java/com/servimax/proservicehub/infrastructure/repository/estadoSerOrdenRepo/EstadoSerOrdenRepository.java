package com.servimax.proservicehub.infrastructure.repository.estadoSerOrdenRepo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.servimax.proservicehub.domain.entity.EstadoOrdenServicio;

public interface EstadoSerOrdenRepository extends CrudRepository<EstadoOrdenServicio,Long>{
    Optional<EstadoOrdenServicio> findByNombre(String nombre);
}
