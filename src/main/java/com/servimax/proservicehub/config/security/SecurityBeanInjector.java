package com.servimax.proservicehub.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.servimax.proservicehub.infrastructure.repository.login.LoginRepositoryI;
import com.servimax.proservicehub.infrastructure.utils.exceptiones.ObjectNotFoundException;

@Configuration
public class SecurityBeanInjector {

    /*
     * Spring se encarga de gestionar la configuración de seguridad de la aplicación, 
     * y esta clase te permite acceder al AuthenticationManager, 
     * que es el componente central encargado de la autenticación de usuarios.
    */

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;


    @Autowired
    private LoginRepositoryI loginRepository;

    @Bean
    public AuthenticationManager authenticationManager() throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationStrategy = new DaoAuthenticationProvider();
        authenticationStrategy.setPasswordEncoder( passwordEncoder() );
        authenticationStrategy.setUserDetailsService( userDetailsService() );

        return authenticationStrategy;
    }
    
        @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return (username) -> {
            return loginRepository.findByUsuario(username)
                    .orElseThrow(() -> new ObjectNotFoundException("User not found with username " + username));
        };
    }
}
