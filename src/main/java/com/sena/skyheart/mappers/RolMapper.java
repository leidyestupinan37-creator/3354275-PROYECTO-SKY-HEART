package com.sena.skyheart.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.sena.skyheart.dtos.RolDto;
import com.sena.skyheart.models.usuario.Rol;

@Mapper(componentModel = "spring")
public interface RolMapper {

    RolDto ToDto(Rol rol);

    Rol ToEntidad(RolDto rolDto);

    List<RolDto> toDtoList(List<Rol> roles);
}