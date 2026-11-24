package com.sena.skyheart.services;

import com.sena.skyheart.dtos.LoginRequestDto;
import com.sena.skyheart.dtos.UsuarioAuthCreateDTO;
import com.sena.skyheart.dtos.UsuarioAuthResponseDto;
import java.util.List;

public interface UsuarioAuthService {

    UsuarioAuthResponseDto crear(UsuarioAuthCreateDTO dto);

    List<UsuarioAuthResponseDto> listarTodos();

    UsuarioAuthResponseDto buscarPorId(Long id);

    UsuarioAuthResponseDto login(LoginRequestDto request);

    void eliminar(Long id);
}