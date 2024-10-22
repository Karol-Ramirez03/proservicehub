package com.servimax.proservicehub.infrastructure.repository.tipoPersonaRepo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.servimax.proservicehub.domain.entity.TipoPersona;

@Component
public class TipoPersonaDataInitializer implements CommandLineRunner {

    @Autowired
    private TipoPersonaRepositoryI tipoPersonaRepositoryI;

    @Override
    public void run(String... args) throws Exception {
    List<String> tipos = Arrays.asList(
        "Empleado",
        "Cliente",
        "Proveedor",
        "Profesional"
    );

    for (String nombreTipo : tipos) {
        if (!tipoPersonaRepositoryI.findByNombre(nombreTipo).isPresent()) {
            tipoPersonaRepositoryI.save(new TipoPersona(nombreTipo));
        }
    }
}
}
