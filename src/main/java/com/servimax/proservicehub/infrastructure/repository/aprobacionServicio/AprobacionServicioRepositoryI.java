package com.servimax.proservicehub.infrastructure.repository.aprobacionServicio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.AprobacionServicio;

@Repository
public interface AprobacionServicioRepositoryI extends CrudRepository<AprobacionServicio,Long>{

    @Query("SELECT a FROM AprobacionServicio a WHERE a.estado_aprobacion.id = ?1")
    List<AprobacionServicio> findByEstadoAprobacionId(@Param("estadoId") Long estadoId);
}
