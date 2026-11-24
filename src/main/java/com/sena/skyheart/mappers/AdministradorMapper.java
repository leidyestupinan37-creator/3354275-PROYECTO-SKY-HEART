
package com.sena.skyheart.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sena.skyheart.dtos.AdministradorDto;
import com.sena.skyheart.models.usuario.Administrador;

@Mapper(componentModel = "spring")
public interface AdministradorMapper {

    // Convertir de Entidad a DTO Response
    @Mapping(source = "numIde", target = "numIden")
    @Mapping(source = "nom", target = "nomb")
    @Mapping(source = "ape", target = "apell")
    @Mapping(source = "corr", target = "corre")
    @Mapping(source = "dir", target = "direc")
    @Mapping(source = "contra", target = "contras")
    @Mapping(source = "fechaNac", target = "fechaNaci")
    @Mapping(source = "tel", target = "tele")
    AdministradorDto toDto(Administrador administrador);

    // Convertir de DTO a Entidad
    @Mapping(source = "numIden", target = "numIde")
    @Mapping(source = "nomb", target = "nom")
    @Mapping(source = "apell", target = "ape")
    @Mapping(source = "corre", target = "corr")
    @Mapping(source = "direc", target = "dir")
    @Mapping(source = "contras", target = "contra")
    @Mapping(source = "fechaNaci", target = "fechaNac")
    @Mapping(source = "tele", target = "tel")
    Administrador toEntidad(AdministradorDto administradorDto);
}


}