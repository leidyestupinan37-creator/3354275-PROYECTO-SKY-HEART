package com.sena.skyheart.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DomiciliarioDtoResponse {

    private Long domiciliario;
    private String nombre;
    private String zonaEntrega;
    private String telefono;
}