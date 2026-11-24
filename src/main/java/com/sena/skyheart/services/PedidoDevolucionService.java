package com.sena.skyheart.services;

import com.sena.skyheart.dtos.PedidoDevolucionDto;
import java.util.List;

public interface PedidoDevolucionService {
    List<PedidoDevolucionDto> listarTodos();
    PedidoDevolucionDto buscarPorId(Integer id);
    PedidoDevolucionDto crear(PedidoDevolucionDto dto);
    PedidoDevolucionDto actualizar(Integer id, PedidoDevolucionDto dto);
    void eliminar(Integer id);
    PedidoDevolucionDto procesarDevolucion(Integer id);
}