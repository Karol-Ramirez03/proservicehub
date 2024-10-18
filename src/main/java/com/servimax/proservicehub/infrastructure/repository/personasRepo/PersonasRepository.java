package com.servimax.proservicehub.infrastructure.repository.personasRepo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.Personas;

@Repository
public interface PersonasRepository extends CrudRepository<Personas,Long>{
    
    
}
