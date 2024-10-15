package com.servimax.proservicehub.infrastructure.repository.empresaServicioRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

import com.servimax.proservicehub.application.service.EmpresaServicioServiceI;
import com.servimax.proservicehub.domain.entity.EmpresaServicio;
import com.servimax.proservicehub.domain.entity.EmpresaServicioPk;

@Service
public class EmpresaServicioImplementacion implements EmpresaServicioServiceI{

    
    @Autowired
    private EmpresaServicioRepository EmpresaServicioRepositoryI;

    // @Transactional(readOnly = true)
    @Override
    public List<EmpresaServicio> findAll() {
        return (List<EmpresaServicio>) EmpresaServicioRepositoryI.findAll();
    }

    // @Transactional(readOnly = true)
    @Override
    public Optional<EmpresaServicio> findById(Long  idSucursal, Long idServicio) {
        EmpresaServicioPk key =new EmpresaServicioPk(idSucursal,idServicio);
        return EmpresaServicioRepositoryI.findById(key);
    }

    @Override
    public EmpresaServicio save(EmpresaServicio EmpresaServicio) {
        return EmpresaServicioRepositoryI.save(EmpresaServicio);
    }

    @Override
    public Optional<EmpresaServicio> update(Long  idSucursal, Long idServicio, EmpresaServicio EmpresaServicio) {
        EmpresaServicioPk key =new EmpresaServicioPk(idSucursal,idServicio);
        Optional<EmpresaServicio> EmpresaServicioOptional = EmpresaServicioRepositoryI.findById(key);
        if (EmpresaServicioOptional.isPresent()) {
            EmpresaServicio EmpresaServicioCopy = EmpresaServicioOptional.orElseThrow();
            EmpresaServicioCopy.setValorServicio(EmpresaServicio.getValorServicio());
            EmpresaServicioCopy.setSucursal(EmpresaServicio.getSucursal());
            EmpresaServicioCopy.setServicio(EmpresaServicio.getServicio());
            return Optional.of(EmpresaServicioRepositoryI.save(EmpresaServicioCopy));
        }
        return Optional.empty();
    }

    @Override
    public Optional<EmpresaServicio> delete(Long  idSucursal, Long idServicio) {
        EmpresaServicioPk key =new EmpresaServicioPk(idSucursal,idServicio);
        Optional<EmpresaServicio> EmpresaServicioOptional = EmpresaServicioRepositoryI.findById(key);
        EmpresaServicioOptional.ifPresent(cP -> {
            EmpresaServicioRepositoryI.delete(cP);
        });
        return EmpresaServicioOptional;
    }

}
