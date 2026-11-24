package com.sena.skyheart.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.sena.skyheart.dtos.CategoriaDto;
import com.sena.skyheart.models.usuario.Categoria;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    CategoriaDto ToDto(Categoria categoria);

    @Mapping(target = "categoria", ignore = true)
    Categoria ToEntidad(CategoriaDto categoriaDto);

    List<CategoriaDto> toDtoList(List<Categoria> categorias);
}
