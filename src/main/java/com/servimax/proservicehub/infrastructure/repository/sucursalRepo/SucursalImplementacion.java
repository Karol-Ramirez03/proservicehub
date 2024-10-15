package com.servimax.proservicehub.infrastructure.repository.sucursalRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servimax.proservicehub.application.service.SucursalServiceI;
import com.servimax.proservicehub.domain.entity.Sucursal;


@Service
public class SucursalImplementacion implements SucursalServiceI{

    @Autowired
    private SucursalRepositoryI SucursalRepository;

    @Override
    public List<Sucursal> findAll() {
        return ((List<Sucursal>) SucursalRepository.findAll());
    }

    @Override
    public Optional<Sucursal> findById(Long id) {
        return SucursalRepository.findById(id);
    }

    @Override
    public Sucursal save(Sucursal Sucursal) {
        return SucursalRepository.save(Sucursal);
    }

    @Override
    public Optional<Sucursal> update(Long id, Sucursal Sucursal) {
        Optional<Sucursal> SucursalID = SucursalRepository.findById(id);
        if (SucursalID.isPresent()) {
            Sucursal SucursalCopy = SucursalID.orElseThrow();
            SucursalCopy.setNombre(Sucursal.getNombre());
            SucursalCopy.setDireccion(Sucursal.getDireccion());
            SucursalCopy.setEmpresa(Sucursal.getEmpresa());
            SucursalCopy.setFecha_creacion(Sucursal.getFecha_creacion());
            SucursalCopy.setNit(Sucursal.getNit());
            return Optional.of(SucursalRepository.save(SucursalCopy));
            
        }
        return Optional.empty();
    }

    @Override
    public Optional<Sucursal> delete(Long id) {
        Optional<Sucursal> SucursalID = SucursalRepository.findById(id);
        SucursalID.ifPresent( ec -> {
            SucursalRepository.delete(ec);
        });
        return SucursalID;
    }
}
