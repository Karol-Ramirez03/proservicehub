package com.servimax.proservicehub.infrastructure.repository.telSucursal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.TelSucursal;

@Repository
public interface TelSucursalReporitoryI extends CrudRepository<TelSucursal,Long>{

}
