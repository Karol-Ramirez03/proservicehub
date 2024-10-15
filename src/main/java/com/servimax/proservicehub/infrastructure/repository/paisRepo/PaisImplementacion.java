package com.servimax.proservicehub.infrastructure.repository.paisRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servimax.proservicehub.application.service.PaisServiceI;
import com.servimax.proservicehub.domain.entity.Pais;

@Service
public class PaisImplementacion implements PaisServiceI{

    @Autowired
    private PaisRepository PaisRepository;

    @Override
    public List<Pais> findAll() {
        return ((List<Pais>) PaisRepository.findAll());
    }

    @Override
    public Optional<Pais> findById(Long id) {
        return PaisRepository.findById(id);
    }

    @Override
    public Pais save(Pais Pais) {
        return PaisRepository.save(Pais);
    }

    @Override
    public Optional<Pais> update(Long id, Pais Pais) {
        Optional<Pais> PaisID = PaisRepository.findById(id);
        if (PaisID.isPresent()) {
            Pais PaisCopy = PaisID.orElseThrow();
            PaisCopy.setNombre(Pais.getNombre());
            PaisCopy.setRegion(Pais.getRegion());
            return Optional.of(PaisRepository.save(PaisCopy));
            
        }
        return Optional.empty();
    }

    @Override
    public Optional<Pais> delete(Long id) {
        Optional<Pais> PaisID = PaisRepository.findById(id);
        PaisID.ifPresent( ec -> {
            PaisRepository.delete(ec);
        });
        return PaisID;
    }
}
