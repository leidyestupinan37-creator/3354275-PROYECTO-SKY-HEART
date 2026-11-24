
package com.sena.skyheart.services;

import java.util.List;

import com.sena.skyheart.dtos.IngresoDto;

public interface IngresoService {

    // Registrar un nuevo ingreso
    IngresoDto guardar(IngresoDto ingresoDto);

    // Listar todos los ingresos
    List<IngresoDto> listarTodos();

    // Consultar ingreso por número
    IngresoDto buscarPorId(Long id);

    // Actualizar ingreso
    IngresoDto actualizar(Long id, IngresoDto ingresoDto);

    // Eliminar ingreso
    void eliminar(Long id);
}
