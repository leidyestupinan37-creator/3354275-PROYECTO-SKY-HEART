package com.sena.skyheart.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DevolucionesDto {

    private Integer devoluciones;
    private String metodoReembolso;
    private LocalDate fechaSolicitud;
    private String estado;
    private LocalDateTime fechaRegistro;
    private BigDecimal montoReembolso;
    private String motivo;
    private Boolean reembolsoAutorizado;

    public DevolucionesDto() {
        // Constructor vacío requerido para serialización/mapeo
    }

    public DevolucionesDto(
            Integer devoluciones,
            String metodoReembolso,
            LocalDate fechaSolicitud,
            String estado,
            LocalDateTime fechaRegistro,
            BigDecimal montoReembolso,
            String motivo,
            Boolean reembolsoAutorizado
    ) {
        this.devoluciones = devoluciones;
        this.metodoReembolso = metodoReembolso;
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
        this.montoReembolso = montoReembolso;
        this.motivo = motivo;
        this.reembolsoAutorizado = reembolsoAutorizado;
    }

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