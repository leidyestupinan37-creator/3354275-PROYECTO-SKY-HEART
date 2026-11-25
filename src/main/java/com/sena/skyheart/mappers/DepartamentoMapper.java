
package com.sena.skyheart.mappers;

import com.sena.skyheart.dtos.DepartamentoDto;
import com.sena.skyheart.models.usuario.Departamento;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DepartamentoMapper {

    // De Departamento a DepartamentoDto
    @Mapping(source = "codigo", target = "codigo")
    @Mapping(source = "nombre", target = "nombre")
    DepartamentoDto toDto(Departamento departamento);

    // De DepartamentoDto a Departamento
    default Departamento toEntidad(DepartamentoDto departamentoDto) {

        Departamento departamento = Departamento.crear();

        departamento.setCodigo(departamentoDto.getCodigo());
        departamento.setNombre(departamentoDto.getNombre());

        return departamento;
    }
}
