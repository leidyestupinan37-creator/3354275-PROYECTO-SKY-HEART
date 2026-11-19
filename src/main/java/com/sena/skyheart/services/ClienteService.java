
package com.sena.skyheart.services;

import java.util.List;

import com.sena.skyheart.dtos.ClienteDto;
import com.sena.skyheart.dtos.ClienteDtoResponse;

public interface ClienteService {

    // Registrar un nuevo cliente
    ClienteDtoResponse guardar(ClienteDto clienteDto);

    // Listar todos los clientes
    List<ClienteDtoResponse> listarTodos();

    // Consultar cliente por ID
    ClienteDtoResponse buscarPorId(Long id);

    // Actualizar cliente
    ClienteDtoResponse actualizar(Long id, ClienteDto clienteDto);

    // Eliminar cliente
    void eliminar(Long id);

}
