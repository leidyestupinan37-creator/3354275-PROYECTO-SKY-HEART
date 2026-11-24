
package com.sena.skyheart.services;

import java.util.List;

import com.sena.skyheart.dtos.DetalleIngresoDto;

public interface DetalleIngresoService {

    // Registrar un nuevo detalle de ingreso
    DetalleIngresoDto guardar(DetalleIngresoDto detalleIngresoDto);

    // Listar todos los detalles de ingreso
    List<DetalleIngresoDto> listarTodos();

    // Consultar detalle de ingreso por ID
    DetalleIngresoDto buscarPorId(Long id);

    // Actualizar detalle de ingreso
    DetalleIngresoDto actualizar(Long id, DetalleIngresoDto detalleIngresoDto);

    // Eliminar detalle de ingreso
    void eliminar(Long id);
}
