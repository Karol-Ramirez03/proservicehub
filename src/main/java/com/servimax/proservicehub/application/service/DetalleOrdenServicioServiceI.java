package com.servimax.proservicehub.application.service;

import java.util.Optional;
import java.util.Date;
import java.util.List;

import com.servimax.proservicehub.domain.entity.DetalleOrdenServicio;

public interface DetalleOrdenServicioServiceI {
    List<DetalleOrdenServicio> findAll();
    Optional<DetalleOrdenServicio> findById(Long id);
    DetalleOrdenServicio save(DetalleOrdenServicio detalleOrdenServicio);
    Optional<DetalleOrdenServicio> update(Long id, DetalleOrdenServicio detalleOrdenServicio);
    Optional<DetalleOrdenServicio> delete(Long id);
    List<DetalleOrdenServicio> findByEstadoId(long estadoId);
    List<DetalleOrdenServicio> findByIdEmpleado(long estadoId);
    List<Object[]> servicioMasPedido(Date fechaInicio);
    List<Object[]> servicioMenosPedido(Date fechaInicio);
}
