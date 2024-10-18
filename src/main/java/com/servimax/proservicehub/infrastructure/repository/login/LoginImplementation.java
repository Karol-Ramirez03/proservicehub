package com.servimax.proservicehub.infrastructure.repository.login;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servimax.proservicehub.application.service.LoginServiceI;
import com.servimax.proservicehub.domain.entity.Login;

@Service
public class LoginImplementation implements LoginServiceI{

    @Autowired 
    private LoginRepositoryI loginRepositoryI;

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
    public List<Login> findByRolId(Long id) {
        return  loginRepositoryI.findByRolId(id);
    }

}
