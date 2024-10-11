package com.servimax.proservicehub.infrastructure.repository.tipotelefono;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.TipoTelefono;

@Repository
public interface TipotelefonoRepositoryI extends CrudRepository<TipoTelefono, Long>{

}
