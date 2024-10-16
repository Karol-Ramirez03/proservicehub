package com.servimax.proservicehub.infrastructure.repository.regionRepo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.servimax.proservicehub.domain.entity.Pais;
import com.servimax.proservicehub.domain.entity.Region;
import com.servimax.proservicehub.infrastructure.repository.paisRepo.PaisRepository;


@Component
public class RegionDataInitializer implements CommandLineRunner {

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Override
    public void run(String... args) throws Exception {
    List<String> entidades = Arrays.asList(
        "Amazonas",
        "Antioquia",
        "Arauca",
        "Atlantico",
        "Bolivar",
        "Boyaca",
        "Caldas",
        "Caqueta",
        "Cauca",
        "Cesar",
        "Choco",
        "Cordoba",
        "Cundinamarca",
        "Guainia",
        "Guaviare",
        "Huila",
        "La Guajira",
        "Magdalena",
        "Meta",
        "Narino",
        "Norte de Santander",
        "Putumayo",
        "Quindio",
        "Risaralda",
        "San Andres y Providencia",
        "Santander",
        "Sucre",
        "Tolima",
        "Valle del Cauca",
        "Vaupes",
        "Vichada"
    );
    String nombrePais="Colombia";
    Pais pais=new Pais(1L,"Colombia");
    if (!paisRepository.findByNombre(nombrePais).isPresent()) {
        paisRepository.save(new Pais(nombrePais));
    }
    for (String nombre : entidades) {
        if (!regionRepository.findByNombre(nombre).isPresent()) {
            regionRepository.save(new Region(nombre,pais));
        }
    }
    }
}
