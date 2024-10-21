package com.servimax.proservicehub.domain.dto;

public class AprobacionDTO {

    
    private Long orden_trabajo;
    private String hallazgo;
    private String solucion;

    public AprobacionDTO(Long orden_trabajo, String hallazgo, String solucion) {
        this.orden_trabajo = orden_trabajo;
        this.hallazgo = hallazgo;
        this.solucion = solucion;
    }

    
    public AprobacionDTO() {
    }


    public Long getOrden_trabajo() {
        return orden_trabajo;
    }
    public void setOrden_trabajo(Long orden_trabajo) {
        this.orden_trabajo = orden_trabajo;
    }
    public String getHallazgo() {
        return hallazgo;
    }
    public void setHallazgo(String hallazgo) {
        this.hallazgo = hallazgo;
    }
    public String getSolucion() {
        return solucion;
    }
    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }


    

}
