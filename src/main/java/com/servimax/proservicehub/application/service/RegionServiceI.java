package com.servimax.proservicehub.application.service;

import java.util.List;
import java.util.Optional;

import com.servimax.proservicehub.domain.entity.Region;

public interface RegionServiceI {

    List<Region> findAll();
    Optional<Region> findById(Long id);
    Region save(Region Region);
    Optional<Region> update(Long id, Region Region);
    Optional<Region> delete(Long id);
}
