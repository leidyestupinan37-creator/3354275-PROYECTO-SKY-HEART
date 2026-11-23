package com.sena.skyheart.mappers;

import com.sena.skyheart.dtos.DomiciliarioDto;
import com.sena.skyheart.dtos.DomiciliarioDtoResponse;
import com.sena.skyheart.models.usuario.Domiciliario;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DomiciliarioMapper {

    // De Domiciliario a DomiciliarioDtoResponse
    @Mapping(source = "domiciliario", target = "domiciliario")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "zonaEntrega", target = "zonaEntrega")
    @Mapping(source = "telefono", target = "telefono")
    DomiciliarioDtoResponse toDto(Domiciliario domiciliario);

    // De DomiciliarioDto a Domiciliario
    @Mapping(target = "domiciliario", ignore = true)
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "zonaEntrega", target = "zonaEntrega")
    @Mapping(source = "telefono", target = "telefono")
    Domiciliario toEntidad(DomiciliarioDto domiciliarioDto);
}