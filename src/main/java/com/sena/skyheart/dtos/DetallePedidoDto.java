package com.sena.skyheart.dtos;

import java.math.BigDecimal;

public class DetallePedidoDto {

    private Integer detallePedido;
    private Integer cantidad;
    private Float precioVenta;
    private BigDecimal subtotal;

    public DetallePedidoDto() {}

    public DetallePedidoDto(Integer detallePedido, Integer cantidad, Float precioVenta, BigDecimal subtotal) {
        this.detallePedido = detallePedido;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.subtotal = subtotal;
    }

    public Integer getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(Integer detallePedido) {
        this.detallePedido = detallePedido;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}