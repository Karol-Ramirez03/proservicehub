package com.servimax.proservicehub.domain.entity;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column 
    private String nombre;
    private Boolean requiere_insumo;
    private String  tiempo_ejecucion;

    @OneToMany(mappedBy = "servicio")
    private List<EmpresaServicio> empresa_servicio;






    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Boolean getRequiere_insumo() {
        return requiere_insumo;
    }
    public void setRequiere_insumo(Boolean requiere_insumo) {
        this.requiere_insumo = requiere_insumo;
    }
    public String getTiempo_ejecucion() {
        return tiempo_ejecucion;
    }
    public void setTiempo_ejecucion(String tiempo_ejecucion) {
        this.tiempo_ejecucion = tiempo_ejecucion;
    } 

    

}
