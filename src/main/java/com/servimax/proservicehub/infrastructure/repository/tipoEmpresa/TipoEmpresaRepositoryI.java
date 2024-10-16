package com.servimax.proservicehub.infrastructure.repository.tipoEmpresa;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.TipoEmpresa;

@Repository
public interface TipoEmpresaRepositoryI extends CrudRepository<TipoEmpresa,Long>{
    Optional<TipoEmpresa> findByNombre(String nombre);
}
