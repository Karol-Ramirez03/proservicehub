package com.servimax.proservicehub.infrastructure.repository.servicioInsumo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.ServicioInsumo;

@Repository
public interface ServicioInsumoRepositoryI extends CrudRepository<ServicioInsumo, Object>{

}
