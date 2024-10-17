package com.servimax.proservicehub.infrastructure.repository.ordenServicio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.OrdenServicio;
import com.servimax.proservicehub.domain.entity.Personas;

@Repository
public interface OrdenServicioRepositoryI extends CrudRepository<OrdenServicio,Long>{


    @Query("SELECT o FROM OrdenServicio o WHERE o.estado_orden_servicio = ?1")
    List<OrdenServicio> findByEstadoOrdenServicioId(@Param("estadoId") Long estadoId);

    @Query("SELECT o FROM OrdenServicio o WHERE o.personas = ?1 ORDER BY o.numero_orden")
    List<OrdenServicio> findByPersonaId(@Param("personaId") Personas personaId);

    @Procedure(name="addOrdenServicio")
    void addOrdenServicio(@Param("idCliente")Long idCliente,@Param("idServicio")Long idServicio);
}
