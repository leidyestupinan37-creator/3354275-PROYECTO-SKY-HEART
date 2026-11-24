package com.sena.skyheart.mappers;

import com.sena.skyheart.dtos.DevolucionesDto;
import com.sena.skyheart.models.usuario.Devoluciones;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DevolucionesMapper {

    DevolucionesDto toDto(Devoluciones entity);

    @Mapping(target = "devoluciones", ignore = true)
    Devoluciones toEntidad(DevolucionesDto dto);
}