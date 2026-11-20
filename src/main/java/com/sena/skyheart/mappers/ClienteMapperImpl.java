package com.sena.skyheart.mappers;

import com.sena.skyheart.dtos.ClienteDto;
import com.sena.skyheart.dtos.ClienteDtoResponse;
import com.sena.skyheart.models.usuario.Cliente;
import com.sena.skyheart.models.usuario.TiposCliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteDtoResponse toDto(Cliente cliente) {
        if (cliente == null) {
            return null;
        }

        Integer tipoId = cliente.getTipoCliente() != null ? cliente.getTipoCliente().getId() : null;
        String tipoNombre = cliente.getTipoCliente() != null ? cliente.getTipoCliente().getNombre() : null;

        return ClienteDtoResponse.builder()
                .id(cliente.getId())
                .numIde(cliente.getNumIde())
                .nom(cliente.getNom())
                .ape(cliente.getApe())
                .corr(cliente.getCorr())
                .dir(cliente.getDir())
                .fechaNac(cliente.getFechaNac())
                .tel(cliente.getTel())
                .tipoClienteId(tipoId)
                .tipoClienteNombre(tipoNombre)
                .build();
    }

    @Override
    public Cliente toEntidad(ClienteDto clienteDto) {
        if (clienteDto == null) {
            return null;
        }

        Cliente cliente = Cliente.builder()
                .id(clienteDto.getId())
                .numIde(clienteDto.getNumIde())
                .nom(clienteDto.getNom())
                .ape(clienteDto.getApe())
                .corr(clienteDto.getCorr())
                .dir(clienteDto.getDir())
                .fechaNac(clienteDto.getFechaNac())
                .tel(clienteDto.getTel())
                .build();

        if (clienteDto.getTipoClienteId() != null) {
            TiposCliente tipoCliente = TiposCliente.builder()
                    .id(clienteDto.getTipoClienteId())
                    .build();
            cliente.setTipoCliente(tipoCliente);
        }

        return cliente;
    }
}