package com.servimax.proservicehub.infrastructure.repository.permisosRepo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.servimax.proservicehub.domain.entity.Permiso;

public interface PermisoRepository extends CrudRepository<Permiso,Long>{
    Optional<Permiso> findByNombre(String nombre);

}
