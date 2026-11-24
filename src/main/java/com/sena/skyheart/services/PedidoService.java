package com.sena.skyheart.services;

import com.sena.skyheart.dtos.PedidoDto;
import java.math.BigDecimal;
import java.util.List;

public interface PedidoService {
    List<PedidoDto> listarTodos();
    PedidoDto buscarPorId(Integer id);
    PedidoDto crear(PedidoDto dto);
    PedidoDto actualizar(Integer id, PedidoDto dto);
    void eliminar(Integer id);
    BigDecimal calcularTotal(Integer id, BigDecimal montoCalculado);
    PedidoDto cambiarEstado(Integer id, String nuevoEstado);
}