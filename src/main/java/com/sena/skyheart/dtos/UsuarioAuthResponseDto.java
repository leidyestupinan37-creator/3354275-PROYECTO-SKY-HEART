package com.sena.skyheart.dtos;

import java.time.LocalDateTime;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioAuthResponseDto {

    private Long id;
    private Long usuarioId;
    private String correoUsuario;
    private String user;
    private boolean habilitado;
    private Integer intentosFallidos;
    private LocalDateTime bloqueadoHasta;
    private Set<String> roles;
}