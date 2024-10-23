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
import com.servimax.proservicehub.infrastructure.utils.exceptions.ObjectNotFoundException;

@Configuration
public class SecurityBeansInjector {
    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Autowired
    private LoginRepositoryI userRepository;

    @Bean
    public AuthenticationManager authenticationManager() throws Exception{
        /*
         * Es el componente que autentica 
         * a los usuarios según la configuración que hayas definido 
         * (puede ser con usuarios en memoria, 
         * en una base de datos, o algún otro mecanismo).
        */
       return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        /*
         * Este método define un bean de tipo AuthenticationProvider, 
         * en este caso un DaoAuthenticationProvider. 
         * Esto es parte de Spring Security y se usa 
         * para autenticar a los usuarios mediante los detalles 
         * proporcionados por un servicio que implemente UserDetailsService 
         * y la verificación de contraseñas con un codificador de contraseñas.
        */
        DaoAuthenticationProvider authenticationStrategy = new DaoAuthenticationProvider();
        authenticationStrategy.setPasswordEncoder( passwordEncoder() );
        authenticationStrategy.setUserDetailsService( userDetailsService() );

        return authenticationStrategy;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        /*
         * 
         * Este método define un bean de tipo PasswordEncoder. 
         * En este caso, estás usando BCryptPasswordEncoder, 
         * que es uno de los algoritmos más comunes y seguros 
         * para encriptar contraseñas.
        */
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        /*
         * Este método define un bean de tipo UserDetailsService. 
         * Spring Security usa este servicio para cargar los detalles 
         * de un usuario dado su nombre de usuario.
        */
        return (username) -> {
            return userRepository.findByUsuario(username)
                    .orElseThrow(() -> new ObjectNotFoundException("User not found with username " + username));
        };
    }
}
