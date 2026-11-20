package com.sena.skyheart.mappers;

import com.sena.skyheart.dtos.UsuarioDto;
import com.sena.skyheart.models.usuario.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioDto ConvierteaDto(Usuario usuario);

    @Mapping(target = "contra", ignore = true)
    Usuario ConvierteaEntidad(UsuarioDto usuarioDto);
}