package com.sena.skyheart.models.usuario;

import jakarta.persistence.*;

@Entity
@Table(name = "pedido_devolucion")
public class PedidoDevolucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedidoDevolucion")
    private Integer pedidoDevolucion;

    @Column(name = "motivoDevolucion")
    private String motivoDevolucion;

    public PedidoDevolucion() {}

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