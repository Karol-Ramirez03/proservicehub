package com.servimax.proservicehub.domain.dto.auth;

import java.io.Serializable;

public class LogoutResponse implements Serializable{

    
    private String mensaje;

    public LogoutResponse(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    

}
