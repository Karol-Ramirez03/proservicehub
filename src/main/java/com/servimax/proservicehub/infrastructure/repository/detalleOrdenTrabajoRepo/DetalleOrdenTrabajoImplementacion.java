package com.servimax.proservicehub.infrastructure.repository.detalleOrdenTrabajoRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servimax.proservicehub.application.service.DetalleOrdenTrabajoServiceI;
import com.servimax.proservicehub.domain.entity.DetalleOrdenTrabajo;

@Service
public class DetalleOrdenTrabajoImplementacion  implements DetalleOrdenTrabajoServiceI{

    @Autowired
    private DetalleOrdenTrabajoRepository detalleOrdenTrabajoRepository;

    @Override
    public List<DetalleOrdenTrabajo> findAll() {
        return ((List<DetalleOrdenTrabajo>)detalleOrdenTrabajoRepository.findAll());
    }

    @Override
    public Optional<DetalleOrdenTrabajo> findById(Long id) {
        return detalleOrdenTrabajoRepository.findById(id);
    }

    @Override
    public DetalleOrdenTrabajo save(DetalleOrdenTrabajo detalleOrdenTrabajo) {
        return detalleOrdenTrabajoRepository.save(detalleOrdenTrabajo);
    }

    @Override
    public Optional<DetalleOrdenTrabajo> update(Long id, DetalleOrdenTrabajo detalleOrdenTrabajo) {
        return detalleOrdenTrabajoRepository.findById(id).map(existingDetalle -> {
            existingDetalle.setFecha(detalleOrdenTrabajo.getFecha());
            existingDetalle.setOrden_trabajo(detalleOrdenTrabajo.getOrden_trabajo());
            existingDetalle.setEstado_orden(detalleOrdenTrabajo.getEstado_orden());
            existingDetalle.setServicio(detalleOrdenTrabajo.getServicio());
            return detalleOrdenTrabajoRepository.save(existingDetalle);
        });
    }

    @Override
    public Optional<DetalleOrdenTrabajo> delete(Long id) {
        return detalleOrdenTrabajoRepository.findById(id).map(detalle -> {
            detalleOrdenTrabajoRepository.delete(detalle);
            return detalle;
        });
    }

    @Override
    public List<DetalleOrdenTrabajo> findByIdEmpleado(long estadoId) {
        return detalleOrdenTrabajoRepository.findDetallesByEmpleadoId(estadoId);

    }

}
