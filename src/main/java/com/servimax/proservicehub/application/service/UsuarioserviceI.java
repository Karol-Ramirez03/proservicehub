package com.servimax.proservicehub.application.service;

import java.util.Optional;

import com.servimax.proservicehub.domain.dto.UsuarioDTO;
import com.servimax.proservicehub.domain.entity.Usuario;

public interface UsuarioserviceI {
    Usuario registerOneUsser(UsuarioDTO newUsuario);

    Optional<Usuario> findOneByUsername(String username);

}
