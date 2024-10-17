package com.servimax.proservicehub.infrastructure.repository.tipoEmpresa;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.servimax.proservicehub.domain.entity.TipoEmpresa;

@Component
public class TipoEmpresaDataInitializer implements CommandLineRunner{

    @Autowired
    private TipoEmpresaRepositoryI tipoEmpresaRepositoryI;

    @Override
    public void run(String... args) throws Exception {
    List<String> tipos = Arrays.asList(
        "Publica",
        "Privada",
        "Guvernamental",
        "Internacional"
    );

    for (String nombreTipo : tipos) {
        if (!tipoEmpresaRepositoryI.findByDescripcion(nombreTipo).isPresent()) {
            tipoEmpresaRepositoryI.save(new TipoEmpresa(nombreTipo));
        }
    }
}
}
