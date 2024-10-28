package com.servimax.proservicehub.domain.entity;

import java.util.Collection;
import java.util.List;
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
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="login")
public class Login implements UserDetails{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "no puede estar vacio")
    @Column(unique=true)
    private String usuario;

    @NotBlank(message = "no puede estar vacio")
    private String contraseña;

    @ManyToOne
    @NotNull(message = "no puede estar vacio")
    @JoinColumn(name="id_rol")
    private Rol rol;

    @ManyToOne
    @NotNull(message = "no puede estar vacio")
    @JoinColumn(name="id_persona")
    private Personas personas;

    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(rol == null) return null;

        if(rol.getPermissions() == null) return null;

        List<SimpleGrantedAuthority> authorities = rol.getPermissions().stream()
                .map(each -> each.getOperation().getName())// Convertir a nombre de operación
                .map(each -> new SimpleGrantedAuthority(each)) // Convertir a autoridad de Spring Security
                /*
                 *  Cada nombre de operación se transforma en una instancia 
                 * de SimpleGrantedAuthority, 
                 * que es el formato que Spring Security requiere 
                 * para manejar las autorizaciones.
                */

//                .map(each -> {
//                    String permission = each.name();
//                    return new SimpleGrantedAuthority(permission);
//                })
                .collect(Collectors.toList());// Coleccionarlos en una lista

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.rol.getNombre()));
        /*
         * El método devuelve la lista de autoridades 
         * (permisos y roles) que será utilizada por Spring Security 
         * para verificar las autorizaciones del usuario.
        */
        return authorities;
    }

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

    @Override
    public String getPassword() {
        return contraseña;
    }

    @Override
    public String getUsername() {
        return usuario;
    }

    


}
