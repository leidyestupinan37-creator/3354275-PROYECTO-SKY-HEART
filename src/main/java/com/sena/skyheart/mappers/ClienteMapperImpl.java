
package com.sena.skyheart.mappers;

import org.springframework.stereotype.Component;

import com.sena.skyheart.dtos.ClienteDto;
import com.sena.skyheart.dtos.ClienteDtoResponse;
import com.sena.skyheart.models.usuario.Cliente;

@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteDtoResponse toDto(Cliente cliente) {

        // Validar que tenga datos
        if (cliente == null) {
            return null;
        }

        // Convertir de Cliente a ClienteDtoResponse
        return ClienteDtoResponse.builder()

                // Atributos heredados de UsuarioDto
                .id(cliente.getId())
                .numIden(cliente.getNumIde())
                .nomb(cliente.getNom())
                .apell(cliente.getApe())
                .corre(cliente.getCorr())
                .direc(cliente.getDir())
                .contras(cliente.getContra())
                .fechaNaci(cliente.getFechaNac())
                .tele(cliente.getTel())

                // Atributos propios de ClienteDtoResponse
                .tipoClienteId(cliente.getTipoCliente().getId())
                .tipoClienteNombre(cliente.getTipoCliente().getNombre())

                .build();
    }

    @Override
    public Cliente toEntidad(ClienteDto clienteDto) {

        // Validar que tenga datos
        if (clienteDto == null) {
            return null;
        }

        // Convertir de ClienteDto a Cliente
        return Cliente.builder()

                // Atributos heredados de Usuario
                .numIde(clienteDto.getNumIden())
                .nom(clienteDto.getNomb())
                .ape(clienteDto.getApell())
                .corr(clienteDto.getCorre())
                .dir(clienteDto.getDirec())
                .contra(clienteDto.getContras())
                .fechaNac(clienteDto.getFechaNaci())
                .tel(clienteDto.getTele())

                // La relación tipoCliente se asigna desde el Service
                .build();
    }
}
