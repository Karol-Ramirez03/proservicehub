package com.servimax.proservicehub.infrastructure.repository.jwttoken;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servimax.proservicehub.domain.entity.segurity.JwtToken;

public interface JwtTokenRepository extends JpaRepository<JwtToken,Long>{
    Optional<JwtToken> findByToken(String jwt);

}
