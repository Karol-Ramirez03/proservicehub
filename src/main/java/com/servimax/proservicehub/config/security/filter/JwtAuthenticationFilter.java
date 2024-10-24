package com.servimax.proservicehub.config.security.filter;


import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.servimax.proservicehub.application.service.LoginServiceI;
import com.servimax.proservicehub.application.service.auth.JwtService;
import com.servimax.proservicehub.domain.entity.Login;
import com.servimax.proservicehub.domain.entity.segurity.JwtToken;
import com.servimax.proservicehub.infrastructure.repository.jwttoken.JwtTokenRepository;
import com.servimax.proservicehub.infrastructure.utils.exceptions.ObjectNotFoundException;

import org.springframework.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private LoginServiceI userService;

    @Autowired
    private JwtTokenRepository jwtTokenRepository;
    
    @SuppressWarnings("null")
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

       
        System.out.println("filter");
        String jwt = jwtService.extractJwtFromRequest(request);
        // if (jwt == null || StringUtils.hasText(jwt)) {
        if (jwt == null || !StringUtils.hasText(jwt)) {
            filterChain.doFilter(request, response);
            return;
        }

        Optional<JwtToken> token = jwtTokenRepository.findByToken(jwt);
        boolean isValid = validateToken(token);

        if (!isValid) {
            filterChain.doFilter(request, response);
            return;
        }
        // // 1. Obtener encabezado http llamado Authorization
        // String authorizationHeader = request.getHeader("Authorization");//Bearer jwt
        // if(!StringUtils.hasText(authorizationHeader) || !authorizationHeader.startsWith("Bearer ")){
        //     filterChain.doFilter(request, response);
        //     return;
        // }

        //2. Obtener token JWT desde el encabezado
        // String jwt = authorizationHeader.split(" ")[1];

        //3. Obtener el subject/username desde el token
        // esta accion a su vez valida el formato del token, firma y fecha de expiración
        String username = jwtService.extractUsername(jwt);

        //4. Setear objeto authentication dentro de security context holder

        Login user = userService.findOneByUsername(username)
                .orElseThrow(() -> new ObjectNotFoundException("User not found. Username: " + username));

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
            username, null, user.getAuthorities()
        );
        authToken.setDetails(new WebAuthenticationDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authToken);
        System.out.println("Se acaba de setear el authentication");

        //5. Ejecutar el registro de filtros
        filterChain.doFilter(request, response);
    }

    // private void SaveUserToken(Login user, String jwt){
    //     JwtToken token = new JwtToken();
    //     token.setToken(jwt);
    //     token.setLogin(user);
    //     token.setExpiration(jwtService.extractExpiration(jwt));
    //     token.setValid(true);

    //     jwtTokenRepository.save(token);
    // }

    private boolean validateToken (Optional <JwtToken> optionalJwtToken) {
        if(!optionalJwtToken.isPresent()){
            System.out.println("Token no existe o no fue generado en nuestro sistema");
            return false;
        }

        JwtToken token = optionalJwtToken.get();
        Date now = new Date(System.currentTimeMillis());
        boolean isValid = token.isValid() && token.getExpiration().after(now);

        if(!isValid){
            System.out.println("Token inválido"); 
            updateTokenStatus(token);
        }
        return isValid;
    }
        private void updateTokenStatus (JwtToken token) {
        token.setValid(false); 
        jwtTokenRepository.save(token);
    
    }
}