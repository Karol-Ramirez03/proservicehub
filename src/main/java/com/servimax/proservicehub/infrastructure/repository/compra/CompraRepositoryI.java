package com.servimax.proservicehub.infrastructure.repository.compra;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.Compra;
import com.servimax.proservicehub.domain.entity.Personas;

@Repository
public interface CompraRepositoryI extends CrudRepository<Compra,Long>{

    @Query("SELECT c FROM Compra c WHERE c.personas = ?1")
    List<Compra> findByPersonaId(@Param("personaId") Personas personaId);
}
