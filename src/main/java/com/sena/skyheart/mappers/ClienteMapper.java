package com.sena.skyheart.mappers;

import com.sena.skyheart.dtos.ClienteDto;
import com.sena.skyheart.dtos.ClienteDtoResponse;
import com.sena.skyheart.models.usuario.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = UsuarioMapper.class)
public interface ClienteMapper {

    @Mapping(source = "tipoCliente.id", target = "tipoClienteId")
    @Mapping(source = "tipoCliente.nombre", target = "tipoClienteNombre")
    ClienteDtoResponse toDto(Cliente cliente);

    @Mapping(source = "tipoClienteId", target = "tipoCliente.id")
    @Mapping(target = "contra", ignore = true)
    Cliente toEntidad(ClienteDto clienteDto);
}