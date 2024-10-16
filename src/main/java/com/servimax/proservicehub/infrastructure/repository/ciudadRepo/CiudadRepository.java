package com.servimax.proservicehub.infrastructure.repository.ciudadRepo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.Ciudad;


@Repository
public interface CiudadRepository extends CrudRepository<Ciudad,Long> {
    Optional<Ciudad> findByNombre(String nombre);
}
