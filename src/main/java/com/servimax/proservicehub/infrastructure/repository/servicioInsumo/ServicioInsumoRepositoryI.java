package com.servimax.proservicehub.infrastructure.repository.servicioInsumo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.ServicioInsumo;
import com.servimax.proservicehub.domain.entity.ServicioInsumoPk;

@Repository
public interface ServicioInsumoRepositoryI extends CrudRepository<ServicioInsumo, ServicioInsumoPk>{

}
