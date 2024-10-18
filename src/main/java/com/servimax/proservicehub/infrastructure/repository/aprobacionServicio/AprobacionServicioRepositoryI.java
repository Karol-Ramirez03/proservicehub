package com.servimax.proservicehub.infrastructure.repository.aprobacionServicio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.AprobacionServicio;
import com.servimax.proservicehub.domain.entity.Personas;

@Repository
public interface AprobacionServicioRepositoryI extends CrudRepository<AprobacionServicio,Long>{

    @Query("SELECT as FROM AprobacionServicio as WHERE as.personas = ?1")
    List<AprobacionServicio> findByPersonaId(@Param("personaId") Personas personaId);
}
