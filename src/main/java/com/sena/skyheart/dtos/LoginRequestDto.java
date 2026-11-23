package com.sena.skyheart.dtos;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto {

    @NotBlank(message = "El usuario es obligatorio")
    private String user;

    @NotBlank(message = "La contraseña es obligatoria")
    private String pass;
}