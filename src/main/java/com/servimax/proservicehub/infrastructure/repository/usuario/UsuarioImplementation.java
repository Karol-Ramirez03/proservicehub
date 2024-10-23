package com.servimax.proservicehub.infrastructure.repository.usuario;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;

import com.servimax.proservicehub.application.service.UsuarioserviceI;
import com.servimax.proservicehub.domain.dto.UsuarioDTO;
import com.servimax.proservicehub.domain.entity.Usuario;
import com.servimax.proservicehub.infrastructure.utils.enums.Role;
import com.servimax.proservicehub.infrastructure.utils.exeptions.InvalidPasswordException;

public class UsuarioImplementation implements UsuarioserviceI{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Usuario registerOneUsser(UsuarioDTO newUsuario) {
        validatePassword(newUsuario);

        Usuario user = new Usuario();
        user.setPassword(passwordEncoder.encode(newUsuario.getPassword()));
        user.setUsername(newUsuario.getUsername());
        user.setName(newUsuario.getName());
        user.setRole(Role.ROLE_CLIENTE);

        return usuarioRepository.save(user);
    }

    @Override
    public Optional<Usuario> findOneByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
    
    private void validatePassword(UsuarioDTO dto) {

        if(!StringUtils.hasText(dto.getPassword()) || !StringUtils.hasText(dto.getRepeatedPassword())){
            throw new InvalidPasswordException("Passwords don't match");
        }

        if(!dto.getPassword().equals(dto.getRepeatedPassword())){
            throw new InvalidPasswordException("Passwords don't match");
        }

    }

}
