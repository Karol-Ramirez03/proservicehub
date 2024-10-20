package com.servimax.proservicehub.infrastructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servimax.proservicehub.application.service.AprobacionServicioServiceI;
import com.servimax.proservicehub.application.service.PersonasServiceI;
import com.servimax.proservicehub.domain.dto.AprobacionDTO;
import com.servimax.proservicehub.domain.entity.AprobacionServicio;
import com.servimax.proservicehub.domain.entity.EstadoAprobacion;
import com.servimax.proservicehub.domain.entity.Personas;
import com.servimax.proservicehub.validations.ValidatedFields;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/aprobacionservicio")
public class AprobacionServicioController {

    @Autowired
    private AprobacionServicioServiceI aprobacionServicioServiceI;

    @Autowired
    private PersonasServiceI personasServiceI;

    @GetMapping
    public List<AprobacionServicio> list(){
        return aprobacionServicioServiceI.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<AprobacionServicio> OAprobacionServicio = aprobacionServicioServiceI.findById(id);
        if (OAprobacionServicio.isPresent()) {
            return ResponseEntity.ok(OAprobacionServicio.orElseThrow());
        }   
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody AprobacionServicio AprobacionServicio, BindingResult result){
        if (result.hasFieldErrors()) {
            return ValidatedFields.validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(aprobacionServicioServiceI.save(AprobacionServicio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AprobacionServicio> update(@PathVariable Long id, @RequestBody AprobacionServicio aprobacionServicio) {
        Optional<AprobacionServicio> aprobacionExistenteOpt = aprobacionServicioServiceI.findById(id);
        
        if (!aprobacionExistenteOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        AprobacionServicio aprobacionExistente = aprobacionExistenteOpt.get();

        // Solo actualiza los campos que no son nulos en el objeto recibido
        if (aprobacionServicio.getHallazgo() != null) {
            aprobacionExistente.setHallazgo(aprobacionServicio.getHallazgo());
        }
        if (aprobacionServicio.getSolucion() != null) {
            aprobacionExistente.setSolucion(aprobacionServicio.getSolucion());
        }
        if (aprobacionServicio.getMotivoRechazo() != null) {
            aprobacionExistente.setMotivoRechazo(aprobacionServicio.getMotivoRechazo());
        }
        if (aprobacionServicio.getOrden_trabajo()!= null) {
            aprobacionExistente.setOrden_trabajo(aprobacionServicio.getOrden_trabajo());
        }
        if (aprobacionServicio.getEstado_aprobacion() != null) {
            aprobacionExistente.setEstado_aprobacion(aprobacionServicio.getEstado_aprobacion());
        }

        // Guarda el objeto actualizado
        aprobacionServicioServiceI.update(id, aprobacionExistente);
        return ResponseEntity.ok(aprobacionExistente);
}


    @GetMapping("/persona/{personaId}")
    public ResponseEntity<List<AprobacionServicio>> findByPersonaId(@PathVariable Long personaId) {
        // Primero, busca la persona por ID
        Optional<Personas> persona = personasServiceI.findById(personaId);
        if (persona == null) {
            return ResponseEntity.notFound().build(); // Retorna 404 si la persona no se encuentra
        }
        Personas newPersona=persona.get();
        // Busca las compras asociadas a la persona
        List<AprobacionServicio> aproServ = aprobacionServicioServiceI.findByPersonasId(newPersona);
        if (aproServ.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna 204 si no hay compras
        }
        return ResponseEntity.ok(aproServ); // Retorna 200 con las compras
    }

    @DeleteMapping("/{id}") 
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<AprobacionServicio> CiudadId =  aprobacionServicioServiceI.delete(id);
        if (CiudadId.isPresent()) {
            return ResponseEntity.ok(CiudadId.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/aprobacion/{estadoId}")
    public ResponseEntity<List<AprobacionServicio>> findByEstadoId(@PathVariable long estadoId) {
        List<AprobacionServicio> ordenServicios = aprobacionServicioServiceI.findByEstadoId(estadoId);
        if (ordenServicios.isEmpty()) {
            return ResponseEntity.noContent().build(); 
        }
        return ResponseEntity.ok(ordenServicios);
    }

    @GetMapping("/aprobacionPer/{estado_aprobacion}/{idempleado}")
    public ResponseEntity<List<AprobacionServicio>> findByEstadoPersona(@PathVariable EstadoAprobacion estado_aprobacion,@PathVariable Long idempleado) {
        List<AprobacionServicio> ordenServicios = aprobacionServicioServiceI.findByEstadoPersona(estado_aprobacion, idempleado);
        if (ordenServicios.isEmpty()) {
            return ResponseEntity.noContent().build(); 
        }
        return ResponseEntity.ok(ordenServicios);
    }

    @PostMapping("/agregar")
    public ResponseEntity<Void> insertAprobacionServicio(@RequestBody AprobacionDTO aprobacionDTO) {
        try {
            aprobacionServicioServiceI.insertAprobacionServicio(aprobacionDTO.getOrden_trabajo(), 
                aprobacionDTO.getHallazgo(), aprobacionDTO.getSolucion());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace(); // Imprimir el stack trace para depurar
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
