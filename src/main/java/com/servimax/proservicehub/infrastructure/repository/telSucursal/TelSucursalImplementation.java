package com.servimax.proservicehub.infrastructure.repository.telSucursal;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servimax.proservicehub.application.service.TelSucursalServiceI;
import com.servimax.proservicehub.domain.entity.TelSucursal;

@Service
public class TelSucursalImplementation implements TelSucursalServiceI{

    @Autowired
    private TelSucursalReporitoryI telSucursalReporitoryI;

    @Override
    public List<TelSucursal> findAll() {
        return ((List<TelSucursal>) telSucursalReporitoryI.findAll());
    }

    @Override
    public Optional<TelSucursal> findById(Long id) {
        return telSucursalReporitoryI.findById(id);
    }

    @Override
    public TelSucursal save(TelSucursal telSucursal) {
        return telSucursalReporitoryI.save(telSucursal);
    }

    @Override
    public Optional<TelSucursal> update(Long id, TelSucursal telSucursal) {
        Optional<TelSucursal> OTelSucursal = telSucursalReporitoryI.findById(id);
        if (OTelSucursal.isPresent()) {
            TelSucursal  telAdic = OTelSucursal.orElseThrow();
            telAdic.setNumero(telSucursal.getNumero());
            return Optional.of(telSucursalReporitoryI.save(telAdic));
        }
        return Optional.empty();
    }

    @Override
    public Optional<TelSucursal> delete(Long id) {
        Optional<TelSucursal> OTelSucursal = telSucursalReporitoryI.findById(id);
        OTelSucursal.ifPresent( telSuc -> {
            telSucursalReporitoryI.delete(telSuc);
        });
        return OTelSucursal;
    }

}
