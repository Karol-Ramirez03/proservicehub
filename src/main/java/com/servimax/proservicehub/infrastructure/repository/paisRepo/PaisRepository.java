package com.servimax.proservicehub.infrastructure.repository.paisRepo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.Pais;

@Repository
public interface PaisRepository extends CrudRepository<Pais,Long>{

    //aja
}
