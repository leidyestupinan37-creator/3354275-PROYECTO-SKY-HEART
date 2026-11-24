
package com.sena.skyheart.mappers;

import com.sena.skyheart.dtos.IngresoDto;
import com.sena.skyheart.models.usuario.Ingreso;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IngresoMapper {

    // De Ingreso a IngresoDto
    @Mapping(source = "numero", target = "numero")
    @Mapping(source = "fecha", target = "fecha")
    @Mapping(source = "usuario", target = "usuario")
    @Mapping(source = "nombreProducto", target = "nombreProducto")
    @Mapping(source = "factura", target = "factura")
    IngresoDto toDto(Ingreso ingreso);

    // De IngresoDto a Ingreso
    @Mapping(target = "numero", ignore = true)
    @Mapping(source = "fecha", target = "fecha")
    @Mapping(source = "usuario", target = "usuario")
    @Mapping(source = "nombreProducto", target = "nombreProducto")
    @Mapping(source = "factura", target = "factura")
    Ingreso toEntidad(IngresoDto ingresoDto);
}
