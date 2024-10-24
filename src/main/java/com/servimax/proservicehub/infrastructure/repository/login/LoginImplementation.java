package com.servimax.proservicehub.infrastructure.repository.login;

import java.util.List;
import java.util.Optional;
import org.springframework.util.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.servimax.proservicehub.application.service.LoginServiceI;
import com.servimax.proservicehub.application.service.RolServiceI;
import com.servimax.proservicehub.domain.dto.UserDto;
import com.servimax.proservicehub.domain.entity.Login;
import com.servimax.proservicehub.domain.entity.Rol;
import com.servimax.proservicehub.infrastructure.utils.exceptions.InvalidPasswordException;
import com.servimax.proservicehub.infrastructure.utils.exceptions.ObjectNotFoundException;

@Service
public class LoginImplementation implements LoginServiceI{

    @Autowired 
    private LoginRepositoryI loginRepositoryI;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RolServiceI roleService;

    @Override
    public Login registrOneCustomer(UserDto newUser) {
        validatePassword(newUser);

        Login user = new Login();
        user.setContraseña(passwordEncoder.encode(newUser.getPassword()));// Codifica la contraseña
        user.setUsuario(newUser.getUsername()); // Establece el nombre de usuario
        user.setPersonas(newUser.getIdPersonas());
        user.setRol(newUser.getRole());

        // Rol defaultRole = roleService.findDefaultRole() // Busca un rol predeterminado
        //                 .orElseThrow(() -> new ObjectNotFoundException("Role not found. Default Role"));
        // user.setRol(defaultRole); // Asigna el rol predeterminado al nuevo usuario

        return loginRepositoryI.save(user); // Guarda el usuario en la base de datos
    }

    @Override
    public Optional<Login> findOneByUsername(String username) {
        return loginRepositoryI.findByUsuario(username);
    }
    
    private void validatePassword(UserDto dto) {

        if(!StringUtils.hasText(dto.getPassword()) || !StringUtils.hasText(dto.getRepeatedPassword())){
            throw new InvalidPasswordException("Passwords don't match");
        }

        if(!dto.getPassword().equals(dto.getRepeatedPassword())){
            throw new InvalidPasswordException("Passwords don't match");
        }

    }

    @Override
    public List<Login> findAll() {
        return ((List<Login>) loginRepositoryI.findAll());
    }

    @Override
    public Optional<Login> findById(Long id) {
        return loginRepositoryI.findById(id);
    }

    @Override
    public Login save(Login login) {
        return loginRepositoryI.save(login);
    }

    @Override
    public Optional<Login> update(Long id, Login login) {
        Optional<Login> OLogin = loginRepositoryI.findById(id);
        if (OLogin.isPresent()) {
            Login login2 = OLogin.orElseThrow();
            login2.setUsuario(login.getUsuario());
            login2.setContraseña(login.getContraseña());
            login2.setPersonas(login.getPersonas());
            login2.setRol(login.getRol());
            return Optional.of(loginRepositoryI.save(login2));
            
        }
        return Optional.empty();
    }

    @Override
    public Optional<Login> delete(Long id) {
        Optional<Login> OLogin = loginRepositoryI.findById(id);
        OLogin.ifPresent( log-> {
            loginRepositoryI.delete(log);
        });
        return OLogin;
    }

    @Override
    public Optional<Login> findByUsuario(String usuario) {
        return loginRepositoryI.findByUsuario(usuario);
    }

    @Override
    public List<Login> findByRolId(Long rolId) {
        return loginRepositoryI.findByRolId(rolId);
    }
}
