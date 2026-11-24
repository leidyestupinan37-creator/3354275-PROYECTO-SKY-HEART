package com.sena.skyheart.services;

import java.util.List;

import com.sena.skyheart.dtos.RolDto;

public interface RolService {

    List<RolDto> listarRoles();

    RolDto buscarPorId(Integer id);

    RolDto crearRol(RolDto rolDto);

    RolDto actualizarRol(Integer id, RolDto rolDto);

    void eliminarRol(Integer id);
}
