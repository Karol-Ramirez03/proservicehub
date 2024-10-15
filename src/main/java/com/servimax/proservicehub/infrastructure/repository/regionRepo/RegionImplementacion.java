package com.servimax.proservicehub.infrastructure.repository.regionRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servimax.proservicehub.application.service.RegionServiceI;
import com.servimax.proservicehub.domain.entity.Region;

@Service
public class RegionImplementacion implements RegionServiceI {

    @Autowired
    private RegionRepository RegionRepository;

    @Override
    public List<Region> findAll() {
        return ((List<Region>) RegionRepository.findAll());
    }

    @Override
    public Optional<Region> findById(Long id) {
        return RegionRepository.findById(id);
    }

    @Override
    public Region save(Region Region) {
        return RegionRepository.save(Region);
    }

    @Override
    public Optional<Region> update(Long id, Region Region) {
        Optional<Region> RegionID = RegionRepository.findById(id);
        if (RegionID.isPresent()) {
            Region RegionCopy = RegionID.orElseThrow();
            RegionCopy.setNombre(Region.getNombre());
            return Optional.of(RegionRepository.save(RegionCopy));
            
        }
        return Optional.empty();
    }

    @Override
    public Optional<Region> delete(Long id) {
        Optional<Region> RegionID = RegionRepository.findById(id);
        RegionID.ifPresent( ec -> {
            RegionRepository.delete(ec);
        });
        return RegionID;
    }
}
