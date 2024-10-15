package com.servimax.proservicehub.infrastructure.repository.ciudadRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servimax.proservicehub.application.service.CiudadServiceI;
import com.servimax.proservicehub.domain.entity.Ciudad;

@Service
public class CiudadImplementacion implements CiudadServiceI{

    @Autowired
    private CiudadRepository CiudadRepository;

    @Override
    public List<Ciudad> findAll() {
        return ((List<Ciudad>) CiudadRepository.findAll());
    }

    @Override
    public Optional<Ciudad> findById(Long id) {
        return CiudadRepository.findById(id);
    }

    @Override
    public Ciudad save(Ciudad Ciudad) {
        return CiudadRepository.save(Ciudad);
    }

    @Override
    public Optional<Ciudad> update(Long id, Ciudad Ciudad) {
        Optional<Ciudad> CiudadID = CiudadRepository.findById(id);
        if (CiudadID.isPresent()) {
            Ciudad CiudadCopy = CiudadID.orElseThrow();
            CiudadCopy.setNombre(Ciudad.getNombre());
            CiudadCopy.setRegion(Ciudad.getRegion());
            return Optional.of(CiudadRepository.save(CiudadCopy));
            
        }
        return Optional.empty();
    }

    @Override
    public Optional<Ciudad> delete(Long id) {
        Optional<Ciudad> CiudadID = CiudadRepository.findById(id);
        CiudadID.ifPresent( ec -> {
            CiudadRepository.delete(ec);
        });
        return CiudadID;
    }
}
