package com.servimax.proservicehub.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.servimax.proservicehub.config.security.filter.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity //@EnableWebSecurity habilita las características de seguridad web de Spring Security.
public class HttpSecurityConfig {

        @Autowired
        private AuthenticationProvider daoAuthProvider;
        //Es el proveedor de autenticación (por ejemplo, usando credenciales desde una base de datos).

        @Autowired
        private JwtAuthenticationFilter jwtAuthenticationFilter;
        //Filtro que se encargará de validar los tokens JWT antes de permitir el acceso a recursos protegidos.

        @Autowired
        private AuthenticationEntryPoint authenticationEntryPoint;
        //Se usa para manejar casos donde un usuario no autenticado intenta acceder a recursos protegidos.

        @Autowired
        private AccessDeniedHandler accessDeniedHandler;
        //Manejador de errores para cuando un usuario autenticado intenta acceder a un recurso para el que no tiene los permisos adecuados.

        @Autowired
        private AuthorizationManager<RequestAuthorizationContext> authorizationManager;

        // @Bean
        // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //         //Este método define las políticas de seguridad aplicadas a las peticiones HTTP. Las principales configuraciones son:

        //         SecurityFilterChain filterChain = http
        //                         .csrf(csrfConfig -> csrfConfig.disable())
        //                         /*
        //                          * CSRF (Cross-Site Request Forgery) está deshabilitado porque la aplicación 
        //                          * utiliza una política de sesiones STATELESS, lo cual es común cuando se utilizan 
        //                          * tokens JWT en lugar de sesiones para mantener la autenticación del usuario.
        //                         */
        //                         .sessionManagement(
        //                                         sessMagConfig -> sessMagConfig
        //                                                         .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        //                         /*
        //                          * Con la política de creación de sesiones STATELESS, 
        //                          * no se almacena ninguna información de sesión del usuario en el servidor. 
        //                          * Todo se maneja a través de tokens (como JWT).
        //                         */
        //                         .authenticationProvider(daoAuthProvider)
        //                         /*
        //                          * Se especifica un proveedor de autenticación personalizado 
        //                          * (puede ser basado en base de datos o cualquier otra fuente de autenticación).
        //                         */
        //                         .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
        //                         /*
        //                          * Se añade un filtro personalizado (jwtAuthenticationFilter) 
        //                          * que intercepta las solicitudes antes del filtro estándar de autenticación. 
        //                          * Este filtro se encarga de la validación del token JWT.
        //                         */
        //                         .authorizeHttpRequests( authReqConfig -> {
        //                                 authReqConfig.anyRequest().access(authorizationManager);
        //                         } )
        //                         /*
        //                          * Todas las solicitudes deben pasar por el authorizationManager, 
        //                          * que controla las reglas de acceso basadas en los permisos del usuario.
        //                         */
        //                         .exceptionHandling( exceptionConfig -> {
        //                                 exceptionConfig.authenticationEntryPoint(authenticationEntryPoint);
        //                                 exceptionConfig.accessDeniedHandler(accessDeniedHandler);
        //                         })
        //                         /*
        //                          * Se configura el manejo de excepciones personalizadas para usuarios no autenticados o sin permisos suficientes:
        //                          *  -authenticationEntryPoint: Gestiona las solicitudes no autenticadas.
        //                          *  -accessDeniedHandler: Gestiona los casos donde un usuario autenticado no tiene permiso para acceder a un recurso.
        //                         */
        //                         .build();

        //         return filterChain;
        //         //Finalmente, se retorna una instancia de SecurityFilterChain que incluye todas estas configuraciones:
        // }
        @Bean
        public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:5173"); // Permitir el origen del frontend
        config.addAllowedHeader("*"); // Permitir todos los encabezados
        config.addAllowedMethod("*"); // Permitir todos los métodos
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
        }
        
        @SuppressWarnings("removal")
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http.cors() // Habilitar CORS
                .and()
                .csrf(csrfConfig -> csrfConfig.disable())
                .sessionManagement(sessMagConfig -> sessMagConfig
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(daoAuthProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(authReqConfig -> {
                        authReqConfig.requestMatchers(HttpMethod.GET, "/auth/validate-token").permitAll(); // Permitir acceso a la ruta
                        authReqConfig.anyRequest().access(authorizationManager);
                })
                .exceptionHandling(exceptionConfig -> {
                        exceptionConfig.authenticationEntryPoint(authenticationEntryPoint);
                        exceptionConfig.accessDeniedHandler(accessDeniedHandler);
                });

                return http.build();
        }

       
        /*
         * Este archivo configura la seguridad en la aplicación para trabajar 
         * con JWT como mecanismo de autenticación, gestionando la autorización 
         * a nivel de cada solicitud HTTP. También se encarga de deshabilitar 
         * el manejo de sesiones en el servidor (STATELESS), y utiliza manejadores 
         * personalizados para el acceso denegado y los errores de autenticación.
        */

        // private static void buildRequestMatchers(
        //                 AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authReqConfig) {
        //         authReqConfig.requestMatchers(HttpMethod.GET, "/products")
        //                         .hasAnyRole(RoleEnum.ADMINISTRATOR.name(), RoleEnum.ASSISTANT_ADMINISTRATOR.name());

        //         // authReqConfig.requestMatchers(HttpMethod.GET, "/products/{productId}")
        //         // .hasAnyRole(Role.ADMINISTRATOR.name(), Role.ASSISTANT_ADMINISTRATOR.name());

        //         authReqConfig.requestMatchers(RegexRequestMatcher.regexMatcher(HttpMethod.GET, "/products/[0-9]*"))
        //                         .hasAnyRole(RoleEnum.ADMINISTRATOR.name(), RoleEnum.ASSISTANT_ADMINISTRATOR.name());

        //         authReqConfig.requestMatchers(HttpMethod.POST, "/products")
        //                         .hasRole(RoleEnum.ADMINISTRATOR.name());

        //         authReqConfig.requestMatchers(HttpMethod.PUT, "/products/{productId}")
        //                         .hasAnyRole(RoleEnum.ADMINISTRATOR.name(), RoleEnum.ASSISTANT_ADMINISTRATOR.name());

        //         authReqConfig.requestMatchers(HttpMethod.PUT, "/products/{productId}/disabled")
        //                         .hasRole(RoleEnum.ADMINISTRATOR.name());

        //         authReqConfig.requestMatchers(HttpMethod.POST, "/customers").permitAll();
        //         authReqConfig.requestMatchers(HttpMethod.POST, "/auth/authenticate").permitAll();
        //         authReqConfig.requestMatchers(HttpMethod.GET, "/auth/validate-token").permitAll();

        //         authReqConfig.anyRequest().authenticated();
        // }

}
