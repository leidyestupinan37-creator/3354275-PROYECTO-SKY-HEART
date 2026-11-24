
package com.sena.skyheart.mappers;

import com.sena.skyheart.dtos.MetodoPagoDto;
import com.sena.skyheart.models.usuario.MetodoPago;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MetodoPagoMapper {

    // De MetodoPago a MetodoPagoDto
    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombreMetodoPago", target = "nombreMetodoPago")
    MetodoPagoDto toDto(MetodoPago metodoPago);

    // De MetodoPagoDto a MetodoPago
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "nombreMetodoPago", target = "nombreMetodoPago")
    MetodoPago toEntidad(MetodoPagoDto metodoPagoDto);
}
