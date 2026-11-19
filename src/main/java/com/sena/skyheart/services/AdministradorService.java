package com.sena.skyheart.services;

import java.util.List;

import com.sena.skyheart.dtos.AdministradorDto;




public interface AdministradorService {

    //Registrar un nuevo usuario
    AdministradorDto guardar(AdministradorDto administradorDto);

// Registrar múltiples usuarios por lote
    List<AdministradorDto> guardarTodos(List<AdministradorDto> administradorDtos);

    // Listar todos los usuarios
    List<AdministradorDto> listarTodos();

    // Consultar usuario por ID
    AdministradorDto buscarPorId(long id);

    // Actualizar usuario
    AdministradorDto actualizar(Long id, AdministradorDto administradorDto);

    // Eliminar usuario
    void eliminar(Long id);

}
