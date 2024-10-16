package com.servimax.proservicehub.infrastructure.repository.tipotelefono;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.servimax.proservicehub.domain.entity.TipoTelefono;

@Component
public class TipoTelefonoDataInitializer implements CommandLineRunner{

    @Autowired
    private TipotelefonoRepositoryI tipotelefonoRepositoryI;

    @Override
    public void run(String... args) throws Exception {
    List<String> tipos = Arrays.asList(
        "Fijo",
        "Movil",
        "Personal",
        "Laboral",
        "Hogar"
    );

    for (String nombreTipo : tipos) {
        if (!tipotelefonoRepositoryI.findByNombre(nombreTipo).isPresent()) {
            tipotelefonoRepositoryI.save(new TipoTelefono(nombreTipo));
        }
    }
}

}