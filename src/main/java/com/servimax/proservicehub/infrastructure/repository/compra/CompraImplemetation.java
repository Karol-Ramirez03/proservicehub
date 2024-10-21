package com.servimax.proservicehub.infrastructure.repository.compra;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servimax.proservicehub.application.service.CompraServiceI;
import com.servimax.proservicehub.domain.entity.Compra;
import com.servimax.proservicehub.domain.entity.Personas;
import com.servimax.proservicehub.domain.entity.TipoCompra;

@Service
public class CompraImplemetation implements CompraServiceI{

    @Autowired
    private CompraRepositoryI compraRepositoryI;

    @Override
    public List<Compra> findAll() {
        return ((List<Compra>)compraRepositoryI.findAll());
    }

    @Override
    public Optional<Compra> findById(Long id) {
        return compraRepositoryI.findById(id);
    }

    @Override
    public Compra save(Compra compra) {
        return compraRepositoryI.save(compra);
    }

    @Override
    public Optional<Compra> update(Long id, Compra compra) {
        Optional<Compra> OCompra = compraRepositoryI.findById(id);
        if (OCompra.isPresent()) {
            Compra compra2 = OCompra.orElseThrow();
            compra2.setFecha_compra(compra.getFecha_compra());
            compra2.setEstado_compra(compra.getEstado_compra());
            compra2.setTotal(compra.getTotal());
            compra2.setPersonas(compra.getPersonas());
            return Optional.of(compraRepositoryI.save(compra2));
            
        }
        return Optional.empty();
    }

    @Override
    public Optional<Compra> delete(Long id) {
        Optional<Compra> OCompra = compraRepositoryI.findById(id);
        OCompra.ifPresent( Co -> {
            compraRepositoryI.delete(Co);
        });
        return OCompra;
    }

    @Override
    public List<Compra> findByPersonasId(Personas personasId) {
        return compraRepositoryI.findByPersonaId(personasId);
    }

    public String obtenerNombreEstado(Long estadoId) {
        Compra compra = compraRepositoryI.findById(estadoId)
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));

        return compra.getEstado_compra().getNombre();
    }

    @Override
    public void addComprayDetalle(Long idCliente,Long idservicio,int cantidad) {
        compraRepositoryI.addComprayDetalle(idCliente,idservicio,cantidad);
    }

    @Override
    public List<Compra> findByTipoCompraId(TipoCompra tipoCompraId) {
        return compraRepositoryI.findByTipoCompraId(tipoCompraId);
    }

    @Override
    public void actualizarEstadocompra(int compraId){
        compraRepositoryI.actualizarEstadocompra(compraId);
    }

}
