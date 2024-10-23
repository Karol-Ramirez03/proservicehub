package com.servimax.proservicehub.infrastructure.repository.usuario;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servimax.proservicehub.domain.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    Optional<Usuario> findByUsername(String username);
}
