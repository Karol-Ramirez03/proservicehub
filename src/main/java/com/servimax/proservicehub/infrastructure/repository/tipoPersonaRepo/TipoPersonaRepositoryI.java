package com.servimax.proservicehub.infrastructure.repository.tipoPersonaRepo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.TipoPersona;

@Repository
public interface TipoPersonaRepositoryI extends CrudRepository<TipoPersona,Long>{
    Optional<TipoPersona> findByNombre(String nombre);
}
