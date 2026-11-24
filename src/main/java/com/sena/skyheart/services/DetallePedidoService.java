package com.sena.skyheart.services;

import com.sena.skyheart.dtos.DetallePedidoDto;
import java.math.BigDecimal;
import java.util.List;

public interface DetallePedidoService {
    List<DetallePedidoDto> listarTodos();
    DetallePedidoDto buscarPorId(Integer id);
    DetallePedidoDto crear(DetallePedidoDto dto);
    DetallePedidoDto actualizar(Integer id, DetallePedidoDto dto);
    void eliminar(Integer id);
    BigDecimal calcularSubtotal(Integer id);
    BigDecimal calcularTotalDetalles();
}