package com.servimax.proservicehub.domain.dto;

import java.io.Serializable;

import com.servimax.proservicehub.domain.entity.Personas;
import com.servimax.proservicehub.domain.entity.Rol;

import jakarta.validation.constraints.Size;

public class UserDTO implements Serializable {

    @Size(min =3)
    private String name;

    @Size(min = 3)
    private String usuario;

    @Size(min = 8)
    private String contraseña;
    private Rol rol;

    private Personas persona_id;

    
    public UserDTO() {
    }

    public UserDTO(@Size(min = 3) String name, @Size(min = 3) String usuario, @Size(min = 8) String contraseña,
            Rol rol, Personas persona_id) {
        this.name = name;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.rol = rol;
        this.persona_id = persona_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Personas getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(Personas persona_id) {
        this.persona_id = persona_id;
    }

    

}
