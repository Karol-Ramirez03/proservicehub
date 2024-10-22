package com.servimax.proservicehub.domain.dto;

public class ValidarStockRequest {

    private int insumoId;
    private int cantidadSolicitada;
    
    public ValidarStockRequest() {
    }

    public ValidarStockRequest(int insumoId, int cantidadSolicitada) {
        this.insumoId = insumoId;
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public int getInsumoId() {
        return insumoId;
    }

    public void setInsumoId(int insumoId) {
        this.insumoId = insumoId;
    }

    public int getCantidadSolicitada() {
        return cantidadSolicitada;
    }

    public void setCantidadSolicitada(int cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
    }

    

}
