package com.servimax.proservicehub.infrastructure.repository.tipoCompra;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servimax.proservicehub.application.service.TipoCompraServiceI;
import com.servimax.proservicehub.domain.entity.TipoCompra;

@Service
public class TipoCompraImplemetation implements TipoCompraServiceI{

    @Autowired
    private TipoCompraRepositoryI tipoCompraRepositoryI;

    @Override
    public List<TipoCompra> findAll() {
        return ((List<TipoCompra>) tipoCompraRepositoryI.findAll());
    }

    @Override
    public Optional<TipoCompra> findById(Long id) {
        return tipoCompraRepositoryI.findById(id);
    }

    @Override
    public TipoCompra save(TipoCompra tipoCompra) {
        return tipoCompraRepositoryI.save(tipoCompra);
    }

    @Override
    public Optional<TipoCompra> update(Long id, TipoCompra tipoCompra) {
        Optional<TipoCompra> OTtipoCompra= tipoCompraRepositoryI.findById(id);
        if (OTtipoCompra.isPresent()) {
            TipoCompra  TipoCompra2 = OTtipoCompra.orElseThrow();
            TipoCompra2.setNombre(tipoCompra.getNombre());
            return Optional.of(tipoCompraRepositoryI.save(TipoCompra2));
        }
        return Optional.empty();
    }

    @Override
    public Optional<TipoCompra> delete(Long id) {
        Optional<TipoCompra> OTtipoCompra= tipoCompraRepositoryI.findById(id);
        OTtipoCompra.ifPresent( tipCom-> {
            tipoCompraRepositoryI.delete(tipCom);
        });
        return OTtipoCompra;
    }

    
}
