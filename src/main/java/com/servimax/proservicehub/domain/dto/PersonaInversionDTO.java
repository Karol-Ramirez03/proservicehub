package com.servimax.proservicehub.domain.dto;

public class PersonaInversionDTO {
    private String nombre;
    private String apellido;
    private Double total;
    private Long telefono;

    
    public PersonaInversionDTO(String nombre, String apellido, Double total, Long telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.total = total;
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
    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

}
