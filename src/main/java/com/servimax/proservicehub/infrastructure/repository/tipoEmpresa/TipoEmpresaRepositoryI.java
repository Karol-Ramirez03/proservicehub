package com.servimax.proservicehub.infrastructure.repository.tipoEmpresa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.TipoEmpresa;

@Repository
public interface TipoEmpresaRepositoryI extends CrudRepository<TipoEmpresa,Long>{

}
