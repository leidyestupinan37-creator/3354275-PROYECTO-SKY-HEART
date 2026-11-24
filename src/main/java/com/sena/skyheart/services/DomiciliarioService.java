package com.sena.skyheart.services;

import java.util.List;

import com.sena.skyheart.dtos.DomiciliarioDto;
import com.sena.skyheart.dtos.DomiciliarioDtoResponse;

public interface DomiciliarioService {

    // Registrar un nuevo domiciliario
    DomiciliarioDtoResponse guardar(DomiciliarioDto domiciliarioDto);

    // Listar todos los domiciliarios
    List<DomiciliarioDtoResponse> listarTodos();

    // Consultar domiciliario por ID
    DomiciliarioDtoResponse buscarPorId(Long id);

    // Actualizar domiciliario
    DomiciliarioDtoResponse actualizar(Long id, DomiciliarioDto domiciliarioDto);

    // Eliminar domiciliario
    void eliminar(Long id);

}