package com.servimax.proservicehub.infrastructure.repository.sucursalRepo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.Sucursal;

@Repository
public interface SucursalRepositoryI extends CrudRepository<Sucursal,Long>{

}
