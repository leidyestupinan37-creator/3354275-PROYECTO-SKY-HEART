package com.sena.skyheart.services;

import java.util.List;

import com.sena.skyheart.dtos.GeneroDto;

public interface GeneroService {

    List<GeneroDto> listarGeneros();

    GeneroDto buscarPorId(Integer id);

    GeneroDto crearGenero(GeneroDto generoDto);

    GeneroDto actualizarGenero(Integer id, GeneroDto generoDto);

    void eliminarGenero(Integer id);
}
