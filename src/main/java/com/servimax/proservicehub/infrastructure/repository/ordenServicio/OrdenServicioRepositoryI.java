package com.servimax.proservicehub.infrastructure.repository.ordenServicio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.OrdenServicio;

@Repository
public interface OrdenServicioRepositoryI extends CrudRepository<OrdenServicio,Long>{

   
    @Query("SELECT o FROM OrdenServicio o WHERE o.estado_orden_servicio = ?1")
    List<OrdenServicio> findByEstadoOrdenServicioId(@Param("estadoId") Long estadoId);
}
