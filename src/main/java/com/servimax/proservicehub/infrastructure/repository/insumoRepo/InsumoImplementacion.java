package com.servimax.proservicehub.infrastructure.repository.insumoRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servimax.proservicehub.application.service.InsumoServiceI;
import com.servimax.proservicehub.domain.entity.Insumo;

@Service
public class InsumoImplementacion implements InsumoServiceI{

    @Autowired
    private InsumoRepository InsumoRepository;

    @Override
    public List<Insumo> findAll() {
        return ((List<Insumo>) InsumoRepository.findAll());
    }

    @Override
    public Optional<Insumo> findById(Long id) {
        return InsumoRepository.findById(id);
    }

    @Override
    public Insumo save(Insumo Insumo) {
        return InsumoRepository.save(Insumo);
    }

    @Override
    public Optional<Insumo> update(Long id, Insumo Insumo) {
        Optional<Insumo> InsumoID = InsumoRepository.findById(id);
        if (InsumoID.isPresent()) {
            Insumo InsumoCopy = InsumoID.orElseThrow();
            InsumoCopy.setNombre(Insumo.getNombre());
            InsumoCopy.setCodigo_interno(Insumo.getCodigo_interno());
            InsumoCopy.setPrecio_unitario(Insumo.getPrecio_unitario());
            InsumoCopy.setStock(Insumo.getStock());
            InsumoCopy.setStock_maximo(Insumo.getStock_maximo());
            InsumoCopy.setStock_minimo(Insumo.getStock_minimo());
            return Optional.of(InsumoRepository.save(InsumoCopy));
            
        }
        return Optional.empty();
    }

    @Override
    public Optional<Insumo> delete(Long id) {
        Optional<Insumo> InsumoID = InsumoRepository.findById(id);
        InsumoID.ifPresent( ec -> {
            InsumoRepository.delete(ec);
        });
        return InsumoID;
    }

    @Override
    public int verificarStock(int insumoId, int cantidadSolicitada) {
        InsumoRepository.validarStock(insumoId, cantidadSolicitada);

        Integer estado = InsumoRepository.obtenerEstado();

        return estado;
    }

}
