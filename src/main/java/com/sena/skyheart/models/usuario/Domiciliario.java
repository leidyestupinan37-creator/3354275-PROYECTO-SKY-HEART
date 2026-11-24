package com.sena.skyheart.models.usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "domiciliarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Domiciliario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "domiciliario_id")
    private Long domiciliario;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "zona_entrega", nullable = false, length = 100)
    private String zonaEntrega;

    @Column(name = "telefono", nullable = false, length = 20)
    private String telefono;
}