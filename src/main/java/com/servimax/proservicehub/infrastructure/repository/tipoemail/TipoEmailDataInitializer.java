package com.servimax.proservicehub.infrastructure.repository.tipoemail;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.servimax.proservicehub.domain.entity.TipoEmail;

@Component
public class TipoEmailDataInitializer implements CommandLineRunner {

    @Autowired
    private TipoEmailRepositoryI tipoEmailRepositoryI;

    @Override
    public void run(String... args) throws Exception {
    List<String> tipos = Arrays.asList(
        "Profesional",
        "Personal",
        "Educativo"
    );

    for (String nombreTipo : tipos) {
        if (!tipoEmailRepositoryI.findByNombre(nombreTipo).isPresent()) {
            tipoEmailRepositoryI.save(new TipoEmail(nombreTipo));
        }
    }
}
}
