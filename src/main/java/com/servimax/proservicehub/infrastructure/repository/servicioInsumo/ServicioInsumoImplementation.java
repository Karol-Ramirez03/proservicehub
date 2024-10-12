package com.servimax.proservicehub.infrastructure.repository.servicioInsumo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servimax.proservicehub.application.service.ServicioInsumoServiceI;
import com.servimax.proservicehub.domain.entity.ServicioInsumo;

@Service
public class ServicioInsumoImplementation implements ServicioInsumoServiceI{

    @Autowired
    private ServicioInsumoRepositoryI servicioInsumoRepositoryI;

    @Override
    public List<ServicioInsumo> findAll() {
        return ((List<ServicioInsumo>) servicioInsumoRepositoryI.findAll());
    }

    @Override
    public ServicioInsumo save(ServicioInsumo servicioInsumo) {
        return servicioInsumoRepositoryI.save(servicioInsumo);
    }

    

}
