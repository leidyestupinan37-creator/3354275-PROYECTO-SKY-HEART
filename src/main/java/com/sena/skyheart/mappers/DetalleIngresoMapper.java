
package com.sena.skyheart.mappers;

import com.sena.skyheart.dtos.DetalleIngresoDto;
import com.sena.skyheart.models.usuario.DetalleIngreso;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DetalleIngresoMapper {

    // De DetalleIngreso a DetalleIngresoDto
    @Mapping(source = "id", target = "id")
    @Mapping(source = "cantidad", target = "cantidad")
    @Mapping(source = "precioCompra", target = "precioCompra")
    DetalleIngresoDto toDto(DetalleIngreso detalleIngreso);

    // De DetalleIngresoDto a DetalleIngreso
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "cantidad", target = "cantidad")
    @Mapping(source = "precioCompra", target = "precioCompra")
    DetalleIngreso toEntidad(DetalleIngresoDto detalleIngresoDto);
}
