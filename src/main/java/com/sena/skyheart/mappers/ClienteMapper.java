
package com.sena.skyheart.mappers;

import com.sena.skyheart.dtos.ClienteDto;
import com.sena.skyheart.dtos.ClienteDtoResponse;
import com.sena.skyheart.models.usuario.Cliente;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    // De Cliente a ClienteDtoResponse
    @Mapping(source = "tipoCliente.id", target = "tipoClienteId")
    @Mapping(source = "tipoCliente.nombre", target = "tipoClienteNombre")
    @Mapping(source = "numIde", target = "numIden")
    @Mapping(source = "nom", target = "nomb")
    @Mapping(source = "ape", target = "apell")
    @Mapping(source = "corr", target = "corre")
    @Mapping(source = "dir", target = "direc")
    @Mapping(source = "contra", target = "contras")
    @Mapping(source = "fechaNac", target = "fechaNaci")
    @Mapping(source = "tel", target = "tele")
    ClienteDtoResponse toDto(Cliente cliente);

    // De ClienteDto a Cliente
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tipoCliente", ignore = true)
    @Mapping(source = "numIden", target = "numIde")
    @Mapping(source = "nomb", target = "nom")
    @Mapping(source = "apell", target = "ape")
    @Mapping(source = "corre", target = "corr")
    @Mapping(source = "direc", target = "dir")
    @Mapping(source = "contras", target = "contra")
    @Mapping(source = "fechaNaci", target = "fechaNac")
    @Mapping(source = "tele", target = "tel")
    Cliente toEntidad(ClienteDto clienteDto);
}
