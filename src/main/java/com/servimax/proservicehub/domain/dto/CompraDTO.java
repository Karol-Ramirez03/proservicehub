package com.servimax.proservicehub.domain.dto;

public class CompraDTO {

    private Long idCliente;
    private Long idProducto;
    private int cantidad;
    private int tipo_compra;
    
    public CompraDTO() {
    }

    public CompraDTO(Long idCliente, Long idServicio) {
        this.idCliente = idCliente;
        this.idProducto = idServicio;
    }

    public CompraDTO(Long idCliente, Long idProducto, int cantidad) {
        this.idCliente = idCliente;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idServicio) {
        this.idProducto = idServicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTipo_compra() {
        return tipo_compra;
    }

    public void setTipo_compra(int tipo_compra) {
        this.tipo_compra = tipo_compra;
    }

    
}
