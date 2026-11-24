
package com.sena.skyheart.models.usuario;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "devoluciones")
public class Devoluciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "devoluciones")
    private Integer devoluciones;

    @Column(name = "metodo_reembolso")
    private String metodoReembolso;

    @Column(name = "fecha_solicitud")
    private LocalDate fechaSolicitud;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column(name = "monto_reembolso")
    private BigDecimal montoReembolso;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "reembolso_autorizado")
    private Boolean reembolsoAutorizado;

    public Devoluciones() {}

    public Integer getDevoluciones() {
        return devoluciones;
    }

    public void setDevoluciones(Integer devoluciones) {
        this.devoluciones = devoluciones;
    }

    public String getMetodoReembolso() {
        return metodoReembolso;
    }

    public void setMetodoReembolso(String metodoReembolso) {
        this.metodoReembolso = metodoReembolso;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public BigDecimal getMontoReembolso() {
        return montoReembolso;
    }

    public void setMontoReembolso(BigDecimal montoReembolso) {
        this.montoReembolso = montoReembolso;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Boolean getReembolsoAutorizado() {
        return reembolsoAutorizado;
    }

    public void setReembolsoAutorizado(Boolean reembolsoAutorizado) {
        this.reembolsoAutorizado = reembolsoAutorizado;
    }
}
