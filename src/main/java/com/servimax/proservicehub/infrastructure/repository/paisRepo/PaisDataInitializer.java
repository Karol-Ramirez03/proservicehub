package com.servimax.proservicehub.infrastructure.repository.paisRepo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.servimax.proservicehub.domain.entity.Pais;

@Component
public class PaisDataInitializer implements CommandLineRunner {

     @Autowired
    private PaisRepository paisRepository;

    @Override
    public void run(String... args) throws Exception {
    List<String> entidades = Arrays.asList(
        "Colombia",
        "Mexico",
        "España",
        "Ecuador",
        "Chile"
    );

    for (String nombre : entidades) {
        if (!paisRepository.findByNombre(nombre).isPresent()) {
            paisRepository.save(new Pais(nombre));
        }
    }
    }
}
