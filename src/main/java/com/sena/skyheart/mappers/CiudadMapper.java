
package com.sena.skyheart.mappers;

import com.sena.skyheart.dtos.CiudadDto;
import com.sena.skyheart.models.usuario.Ciudad;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CiudadMapper {

    // De Ciudad a CiudadDto
    @Mapping(source = "departamento.codigo", target = "departamentoCodigo")
    CiudadDto toDto(Ciudad ciudad);

    // Actualizar una Ciudad existente
    @Mapping(target = "departamento", ignore = true)
    void actualizarEntidad(CiudadDto ciudadDto, @MappingTarget Ciudad ciudad);

    // De CiudadDto a Ciudad
    default Ciudad toEntidad(CiudadDto ciudadDto) {
        Ciudad ciudad = Ciudad.crear();
        actualizarEntidad(ciudadDto, ciudad);
        return ciudad;
    }
}
