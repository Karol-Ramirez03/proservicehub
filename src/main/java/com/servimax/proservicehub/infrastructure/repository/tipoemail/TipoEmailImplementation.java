package com.servimax.proservicehub.infrastructure.repository.tipoemail;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servimax.proservicehub.application.service.TipoEmailServiceI;
import com.servimax.proservicehub.domain.entity.TipoEmail;



@Service
public class TipoEmailImplementation implements  TipoEmailServiceI{

    @Autowired
    private TipoEmailRepositoryI tipoEmailRepositoryI;

    
    @Override
    public List<TipoEmail> findAll() {
       return ((List<TipoEmail>) tipoEmailRepositoryI.findAll());
    }

    @Transactional(readOnly =true )
    @Override
    public Optional<TipoEmail> findById(Long id) {
        return tipoEmailRepositoryI.findById(id);
    }

    @Override
    public TipoEmail save(TipoEmail tipoEmail) {
        return tipoEmailRepositoryI.save(tipoEmail);
    }

    @Override
    public Optional<TipoEmail> update(Long id, TipoEmail tipoEmail) {
        Optional<TipoEmail> OTipoEmail= tipoEmailRepositoryI.findById(id);
        if (OTipoEmail.isPresent()) {
            TipoEmail  tipoEmailAdic = OTipoEmail.orElseThrow();
            tipoEmailAdic.setNombre(tipoEmail.getNombre());
            return Optional.of(tipoEmailRepositoryI.save(tipoEmailAdic));
        }
        return Optional.empty();
    }

    @Override
    public Optional<TipoEmail> delete(Long id) {
        Optional<TipoEmail> OTipoEmail = tipoEmailRepositoryI.findById(id);
        OTipoEmail.ifPresent( tipo -> {
            tipoEmailRepositoryI.delete(tipo);
        });
        return OTipoEmail;
    }

}
