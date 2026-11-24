
package com.sena.skyheart.services;

import java.util.List;

import com.sena.skyheart.dtos.MetodoPagoDto;

public interface MetodoPagoService {

    // Registrar un nuevo método de pago
    MetodoPagoDto guardar(MetodoPagoDto metodoPagoDto);

    // Listar todos los métodos de pago
    List<MetodoPagoDto> listarTodos();

    // Consultar método de pago por ID
    MetodoPagoDto buscarPorId(Long id);

    // Actualizar método de pago
    MetodoPagoDto actualizar(Long id, MetodoPagoDto metodoPagoDto);

    // Eliminar método de pago
    void eliminar(Long id);
}
