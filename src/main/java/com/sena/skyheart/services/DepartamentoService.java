
package com.sena.skyheart.services;

import java.util.List;

import com.sena.skyheart.dtos.DepartamentoDto;

public interface DepartamentoService {

    // Registrar un nuevo departamento
    DepartamentoDto guardar(DepartamentoDto departamentoDto);

    // Listar todos los departamentos
    List<DepartamentoDto> listarTodos();

    // Consultar departamento por código
    DepartamentoDto buscarPorId(String codigo);

    // Actualizar departamento
    DepartamentoDto actualizar(String codigo, DepartamentoDto departamentoDto);

    // Eliminar departamento
    void eliminar(String codigo);

}
