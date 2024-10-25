// package com.servimax.proservicehub.infrastructure.repository.ciudadRepo;

// import java.util.Arrays;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;

// import com.servimax.proservicehub.domain.entity.Ciudad;
// import com.servimax.proservicehub.domain.entity.Region;
// import com.servimax.proservicehub.infrastructure.repository.regionRepo.RegionRepository;

// @Component
// public class CiudadDataInitializer implements CommandLineRunner {
    
//     @Autowired
//     private CiudadRepository ciudadRepository;

//     @Autowired
//     private RegionRepository regionRepository;


//     @Override
//     public void run(String... args) throws Exception {
//     List<String> entidades = Arrays.asList(
//         "Bucaramanga",
//         "Cucuta",
//         "Giron",
//         "Piedecuesta"
//     );
//     Region region = regionRepository.findByNombre("Santander")
//     .orElseGet(() -> {
//         Region nuevaRegion = new Region();
//         nuevaRegion.setNombre("Santander");
//         return regionRepository.save(nuevaRegion);
//     });
//     if(regionRepository.count()!=0){
//         for (String nombre : entidades) {
//             if (!ciudadRepository.findByNombre(nombre).isPresent()) {
//                 ciudadRepository.save(new Ciudad(nombre,region));
//             }
//         }
//     }
//     }
// }
