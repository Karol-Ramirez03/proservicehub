package com.servimax.proservicehub.infrastructure.repository.telPersonaRepo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.TelPersona;

@Repository
public interface TelPersonaRepositoryI extends CrudRepository<TelPersona,Long> {

}
