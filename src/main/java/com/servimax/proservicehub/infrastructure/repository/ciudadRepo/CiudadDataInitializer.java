// package com.servimax.proservicehub.infrastructure.repository.ciudadRepo;

// import java.util.Arrays;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;

// import com.servimax.proservicehub.domain.entity.Ciudad;
// import com.servimax.proservicehub.domain.entity.Pais;
// import com.servimax.proservicehub.domain.entity.Region;
// import com.servimax.proservicehub.infrastructure.repository.paisRepo.PaisRepository;
// import com.servimax.proservicehub.infrastructure.repository.regionRepo.RegionRepository;

// @Component
// public class CiudadDataInitializer implements CommandLineRunner {
     
//     @Autowired
//     private CiudadRepository ciudadRepository;

//     @Autowired
//     private RegionRepository regionRepository;

//     @Autowired
//     private PaisRepository paisRepository;

//     @Override
//     public void run(String... args) throws Exception {
//     List<String> entidades = Arrays.asList(
//         "Bucaramanga",
//         "Cucuta",
//         "Giron",
//         "Piedecuesta"
//     );
//     String nombrePais="Colombia";
//     Pais pais=new Pais(1L,"Colombia");
//     if (!paisRepository.findByNombre(nombrePais).isPresent()) {
//         paisRepository.save(new Pais(nombrePais));
//     }
//     String nombreRegion="Santander";
//     Region region=new Region(26L,"Santander");
//     if (!regionRepository.findByNombre(nombreRegion).isPresent()) {
//         regionRepository.save(new Region(nombreRegion,pais));
//     }

//     for (String nombre : entidades) {
//         if (!ciudadRepository.findByNombre(nombre).isPresent()) {
//             ciudadRepository.save(new Ciudad(nombre,region));
//         }
//     }
//     }
// }
