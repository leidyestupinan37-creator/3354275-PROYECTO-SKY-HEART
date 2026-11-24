
package com.sena.skyheart.services;

import java.util.List;

import com.sena.skyheart.dtos.EstadoPedidoDto;

public interface EstadoPedidoService {

    // Registrar un nuevo estado de pedido
    EstadoPedidoDto guardar(EstadoPedidoDto estadoPedidoDto);

    // Listar todos los estados de pedido
    List<EstadoPedidoDto> listarTodos();

    // Consultar estado de pedido por ID
    EstadoPedidoDto buscarPorId(Long id);

    // Actualizar estado de pedido
    EstadoPedidoDto actualizar(Long id, EstadoPedidoDto estadoPedidoDto);

    // Eliminar estado de pedido
    void eliminar(Long id);
}
