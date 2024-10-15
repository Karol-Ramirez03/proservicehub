package com.servimax.proservicehub.infrastructure.repository.servicioInsumo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servimax.proservicehub.application.service.ServicioInsumoServiceI;
import com.servimax.proservicehub.domain.entity.ServicioInsumo;
import com.servimax.proservicehub.domain.entity.ServicioInsumoPk;

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

    @Override
    public Optional<ServicioInsumo> findById(Long idInsumo, Long idServicio) {
        ServicioInsumoPk key=new ServicioInsumoPk(idInsumo,idServicio);
        return servicioInsumoRepositoryI.findById(key);
    }

    @Override
    public Optional<ServicioInsumo> update(Long idInsumo, Long idServicio, ServicioInsumo servicioInsumo) {
        ServicioInsumoPk key=new ServicioInsumoPk(idInsumo,idServicio);
        Optional<ServicioInsumo> OServicioInsumo= servicioInsumoRepositoryI.findById(key);
        if(OServicioInsumo.isPresent()){
            ServicioInsumo servicioInsumo2= OServicioInsumo.orElseThrow();
            servicioInsumo2.setCantidad(servicioInsumo.getCantidad());
            return Optional.of(servicioInsumoRepositoryI.save(servicioInsumo2));
        }
        return Optional.empty();
    }

    @Override
    public Optional<ServicioInsumo> delete(Long idInsumo, Long idServicio) {
        ServicioInsumoPk key=new ServicioInsumoPk(idInsumo,idServicio);
        servicioInsumoRepositoryI.deleteById(key);
        return null;
    }

    

}
