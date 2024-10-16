package com.servimax.proservicehub.infrastructure.repository.tipotelefono;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.TipoTelefono;

@Repository
public interface TipotelefonoRepositoryI extends CrudRepository<TipoTelefono, Long>{
    Optional<TipoTelefono> findByNombre(String nombre);
}
