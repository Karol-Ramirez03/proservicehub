package com.servimax.proservicehub.domain.dto.auth;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable{
    private String jwt;
    private String refreshToken;
    

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String jwt, String refreshToken) {
        this.jwt = jwt;
        this.refreshToken = refreshToken;
    }

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
    
}