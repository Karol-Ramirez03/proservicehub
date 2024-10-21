package com.servimax.proservicehub.domain.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="login")
public class Login implements UserDetails{

    /*
     * La interfaz UserDetails es clave en Spring Security
     *  para encapsular la información del usuario que necesita 
     * el sistema de seguridad para autenticar y autorizar a los usuarios.
    */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique=true)
    private String usuario;

    @NotBlank
    @Column(unique=true)
    private String contraseña;

    @ManyToOne
    @JoinColumn(name="id_rol")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name="id_persona")
    private Personas personas;

    public Login() {
    }

    
    public Login(Long id, @NotBlank String usuario) {
        this.id = id;
        this.usuario = usuario;
    }


    public Login(@NotBlank String usuario, @NotBlank String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public Login(Long id, String usuario, String contraseña, Rol rol, Personas personas) {
        this.id = id;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.rol = rol;
        this.personas = personas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Personas getPersonas() {
        return personas;
    }

    public void setPersonas(Personas personas) {
        this.personas = personas;
    }

    /*
     *  Devuelve los permisos asociados al rol del usuario, 
     * creando instancias de SimpleGrantedAuthority para cada permiso. 
     * Este método ahora maneja correctamente casos donde rol o rol.getPermisos() 
     * pueden ser null, devolviendo una lista vacía si no hay permisos.
    */

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
         if (rol == null || rol.getPermisos() == null) {
            return new ArrayList<>(); 
         }
         return rol.getPermisos().stream()
            .map(permiso -> new SimpleGrantedAuthority(permiso.getNombre()))
            .collect(Collectors.toList());
    }


    @Override
    public String getPassword() {
        return contraseña;
    }


    @Override
    public String getUsername() {
        return usuario;
    }

    public Long getIdPersona() {
        return personas != null ? personas.getNro_Doc() : null;  
    }

    public Long getIdRol() {
        return rol != null ? rol.getId() : null;  
    }

}
