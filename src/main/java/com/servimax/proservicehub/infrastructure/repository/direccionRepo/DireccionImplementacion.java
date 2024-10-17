package com.servimax.proservicehub.infrastructure.repository.direccionRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servimax.proservicehub.application.service.DireccionServiceI;
import com.servimax.proservicehub.domain.entity.Direccion;

@Service
public class DireccionImplementacion implements DireccionServiceI{
    
    @Autowired
    private DireccionRepository DireccionRepository;

    @Override
    public List<Direccion> findAll() {
        return ((List<Direccion>) DireccionRepository.findAll());
    }

    @Override
    public Optional<Direccion> findById(Long id) {
        return DireccionRepository.findById(id);
    }

    @Override
    public Direccion save(Direccion Direccion) {
        return DireccionRepository.save(Direccion);
    }

    @Override
    public Optional<Direccion> update(Long id, Direccion Direccion) {
        Optional<Direccion> DireccionID = DireccionRepository.findById(id);
        if (DireccionID.isPresent()) {
            Direccion DireccionCopy = DireccionID.orElseThrow();
            DireccionCopy.setBarrio(Direccion.getBarrio());
            DireccionCopy.setCalle(Direccion.getCalle());
            DireccionCopy.setCarrera(Direccion.getCarrera());
            DireccionCopy.setDescripcion(Direccion.getDescripcion());
            return Optional.of(DireccionRepository.save(DireccionCopy));
            
        }
        return Optional.empty();
    }

    @Override
    public Optional<Direccion> delete(Long id) {
        Optional<Direccion> DireccionID = DireccionRepository.findById(id);
        DireccionID.ifPresent( ec -> {
            DireccionRepository.delete(ec);
        });
        return DireccionID;
    }

}
