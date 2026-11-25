
package com.sena.skyheart.services;

import java.util.List;

import com.sena.skyheart.dtos.CiudadDto;

public interface CiudadService {

    // Registrar una nueva ciudad
    CiudadDto guardar(CiudadDto ciudadDto);

    // Listar todas las ciudades
    List<CiudadDto> listarTodos();

    // Consultar ciudad por código
    CiudadDto buscarPorId(String codigo);

    // Actualizar ciudad
    CiudadDto actualizar(String codigo, CiudadDto ciudadDto);

    // Eliminar ciudad
    void eliminar(String codigo);

}
