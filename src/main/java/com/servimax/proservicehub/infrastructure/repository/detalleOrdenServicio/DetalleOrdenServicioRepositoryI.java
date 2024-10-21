package com.servimax.proservicehub.infrastructure.repository.detalleOrdenServicio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.DetalleOrdenServicio;

@Repository
public interface DetalleOrdenServicioRepositoryI extends CrudRepository<DetalleOrdenServicio, Long>{

    @Query("SELECT d FROM DetalleOrdenServicio d INNER JOIN d.id_orden_servicio os WHERE os.estado_orden_servicio.id = ?1")
    List<DetalleOrdenServicio> findByEstadoOrdenServicioId(@Param("estadoId") long estadoId);

    @Query("SELECT d FROM DetalleOrdenServicio d INNER JOIN d.id_orden_servicio os WHERE os.persona.id = ?1")
    List<DetalleOrdenServicio> findByIdEmpleado(@Param("estadoId") long estadoId);


    @Query("SELECT dos.servicio, COUNT(dos.servicio) AS totalPedidos FROM DetalleOrdenServicio dos WHERE dos.id_orden_servicio.fecha_orden >= ?1 GROUP BY dos.servicio ORDER BY totalPedidos DESC LIMIT 1")
    List<Object[]> findServicioMasPedidoUltimoMes(@Param("fechaInicio") Date fechaInicio);

    @Query("SELECT dos.servicio, COUNT(dos.servicio) AS totalPedidos FROM DetalleOrdenServicio dos WHERE dos.id_orden_servicio.fecha_orden >= ?1 GROUP BY dos.servicio ORDER BY totalPedidos ASC LIMIT 1")
    List<Object[]> findServicioMenosPedidoUltimoMes(@Param("fechaInicio") Date fechaInicio);
}
