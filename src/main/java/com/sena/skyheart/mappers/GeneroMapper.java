package com.sena.skyheart.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sena.skyheart.dtos.GeneroDto;
import com.sena.skyheart.models.usuario.Genero;

@Mapper(componentModel = "spring")
public interface GeneroMapper {

    @Mapping(source = "genero", target = "idGenero")
    GeneroDto ToDto(Genero genero);

    @Mapping(target = "genero", ignore = true)
    Genero ToEntidad(GeneroDto generoDto);

    List<GeneroDto> toDtoList(List<Genero> generos);
}