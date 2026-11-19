package com.sena.skyheart.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UsuarioDto {

    private Long id;

    @NotBlank(message = "El numero de identificacion es obligatorio")
    @Size(min = 10, max = 10,
        message = "El numero de identificacion debe tener 10 caracteres")
    private String numIden;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 60,
        message = "El nombre debe tener entre 3 y 60 caracteres")
    private String nomb;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(min = 3, max = 60,
        message = "El apellido debe tener entre 3 y 60 caracteres")
    private String apell;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo debe ser valido")
    @Size(min = 3, max = 60,
        message = "El correo debe tener entre 3 y 60 caracteres")
    private String corre;

    @NotBlank(message = "La direccion es obligatoria")
    @Size(min = 3, max = 20,
        message = "La direccion debe tener entre 3 y 20 caracteres")
    private String direc;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 3, max = 60,
        message = "La contraseña debe tener entre 3 y 60 caracteres")
    private String contras;

    @NotBlank(message = "La fecha de nacimiento es obligatoria")
    @Size(min = 10, max = 10,
        message = "La fecha de nacimiento debe tener 10 caracteres")
    private String fechaNaci;

    @NotBlank(message = "El telefono es obligatorio")
    @Size(min = 10, max = 10,
        message = "El telefono debe tener 10 caracteres")
    private String tele;
}