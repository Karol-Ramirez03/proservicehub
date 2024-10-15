package com.servimax.proservicehub.infrastructure.repository.personaInsumo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.PersonaInsumo;
import com.servimax.proservicehub.domain.entity.PersonaInsumoPk;

@Repository
public interface PersonaInsumoRepositoryI extends CrudRepository<PersonaInsumo,PersonaInsumoPk>{

}
