package com.sena.skyheart.services;

import java.util.List;

import com.sena.skyheart.dtos.UsuarioDto;

public interface UsuarioService {

    //Registrar un nuevo usuario
    UsuarioDto guardar(UsuarioDto usuarioDto);

// Registrar múltiples usuarios por lote
    List<UsuarioDto> guardarTodos(List<UsuarioDto> usuarioDtos);

    // Listar todos los usuarios
    List<UsuarioDto> listarTodos();

    // Consultar usuario por ID
    UsuarioDto buscarPorId(long id);

    // Actualizar usuario
    UsuarioDto actualizar(Long id, UsuarioDto usuarioDto);

    // Eliminar usuario
    UsuarioDto eliminar(Long id);


}
