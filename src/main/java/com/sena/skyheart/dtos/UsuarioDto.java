package com.sena.skyheart.dtos;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {

    private Long id;
    private String numIde;
    private String nom;
    private String ape;
    private String corr;
    private String dir;
    private String fechaNac;
    private String tel;
}