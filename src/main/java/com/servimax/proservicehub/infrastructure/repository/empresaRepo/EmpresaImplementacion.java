package com.servimax.proservicehub.infrastructure.repository.empresaRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servimax.proservicehub.application.service.EmpresaServiceI;
import com.servimax.proservicehub.domain.entity.Empresa;

@Service
public class EmpresaImplementacion implements EmpresaServiceI {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public List<Empresa> findAll() {
        return ((List<Empresa>) empresaRepository.findAll());
    }

    @Override
    public Optional<Empresa> findById(Long id) {
        return empresaRepository.findById(id);
    }

    @Override
    public Empresa save(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public Optional<Empresa> update(Long id, Empresa empresa) {
        Optional<Empresa> empresaID = empresaRepository.findById(id);
        if (empresaID.isPresent()) {
            Empresa empresaCopy = empresaID.orElseThrow();
            empresaCopy.setNombre(empresa.getNombre());
            empresaCopy.setTipo_empresa(empresa.getTipo_empresa());
            return Optional.of(empresaRepository.save(empresaCopy));
            
        }
        return Optional.empty();
    }

    @Override
    public Optional<Empresa> delete(Long id) {
        Optional<Empresa> empresaID = empresaRepository.findById(id);
        empresaID.ifPresent( ec -> {
            empresaRepository.delete(ec);
        });
        return empresaID;
    }


}
