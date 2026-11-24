package com.sena.skyheart.models.usuario;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_pedido")
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detallePedido")
    private Integer detallePedido;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "precioVenta")
    private Float precioVenta;

    public DetallePedido() {
        // Constructor requerido por JPA
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
}