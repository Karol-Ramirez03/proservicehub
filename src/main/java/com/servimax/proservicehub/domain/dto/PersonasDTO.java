package com.servimax.proservicehub.domain.dto;

import com.servimax.proservicehub.domain.entity.Insumo;

public class PersonasDTO {

    private String nombre;
    private String apellido;
    private Insumo insumo;
    private Long cantidad;
    private Long telefono;
    
    
    public PersonasDTO(String nombre, String apellido, Insumo insumo, Long cantidad, Long telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.insumo = insumo;
        this.cantidad = cantidad;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Insumo getInsumo() {
        return insumo;
    }
    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }
    public Long getCantidad() {
        return cantidad;
    }
    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
    public Long getTelefono() {
        return telefono;
    }
    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    
}
