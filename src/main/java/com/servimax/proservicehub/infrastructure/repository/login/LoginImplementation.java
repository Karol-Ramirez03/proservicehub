package com.servimax.proservicehub.infrastructure.repository.login;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.servimax.proservicehub.application.service.LoginServiceI;
import com.servimax.proservicehub.domain.dto.UserDTO;
import com.servimax.proservicehub.domain.entity.Login;
import com.servimax.proservicehub.domain.entity.Personas;
import com.servimax.proservicehub.infrastructure.utils.exceptiones.InvalidPasswordException;

@Service
public class LoginImplementation implements LoginServiceI{

    @Autowired 
    private LoginRepositoryI loginRepositoryI;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

    @Override
    public Login resgistroCliente(UserDTO newUser) {
        // validatePassword(newUser);
        Login usuario = new Login();
        usuario.setContraseña(passwordEncoder.encode(newUser.getContraseña()));
        usuario.setUsuario(newUser.getUsuario());
        usuario.setRol(newUser.getRol());// areglar le debo pasar el rol a que hace referencia
        usuario.setPersonas(newUser.getPersona_id());

        return loginRepositoryI.save(usuario);
    }

    // private void validatePassword(UserDTO dto) {

    //     if(!StringUtils.hasText(dto.getContraseña()) || !StringUtils.hasText(dto.getRepeatedPassword())){
    //         throw new InvalidPasswordException("Passwords don't match");
    //     }

    //     if(!dto.getPassword().equals(dto.getRepeatedPassword())){
    //         throw new InvalidPasswordException("Passwords don't match");
    //     }

    // }

}
