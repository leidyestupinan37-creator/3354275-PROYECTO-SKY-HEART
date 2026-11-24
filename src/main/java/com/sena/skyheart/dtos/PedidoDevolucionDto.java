package com.sena.skyheart.dtos;

public class PedidoDevolucionDto {

    private Integer pedidoDevolucion;
    private String motivoDevolucion;

    public PedidoDevolucionDto() {}

    public PedidoDevolucionDto(Integer pedidoDevolucion, String motivoDevolucion) {
        this.pedidoDevolucion = pedidoDevolucion;
        this.motivoDevolucion = motivoDevolucion;
    }

    public Integer getPedidoDevolucion() {
        return pedidoDevolucion;
    }

    public void setPedidoDevolucion(Integer pedidoDevolucion) {
        this.pedidoDevolucion = pedidoDevolucion;
    }

    public String getMotivoDevolucion() {
        return motivoDevolucion;
    }

    public void setMotivoDevolucion(String motivoDevolucion) {
        this.motivoDevolucion = motivoDevolucion;
    }
}