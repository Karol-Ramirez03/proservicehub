package com.servimax.proservicehub.infrastructure.repository.ordentrabajoRepo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.OrdenTrabajo;

@Repository
public interface OrdenTrabajoRepository extends CrudRepository<OrdenTrabajo,Long> {

    //aja
}
