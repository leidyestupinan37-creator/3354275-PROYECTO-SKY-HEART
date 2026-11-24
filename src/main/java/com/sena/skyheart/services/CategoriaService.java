package com.sena.skyheart.services;

import java.util.List;

import com.sena.skyheart.dtos.CategoriaDto;

public interface CategoriaService {

    List<CategoriaDto> listarCategorias();

    CategoriaDto buscarPorId(Integer id);

    CategoriaDto crearCategoria(CategoriaDto categoriaDto);

    CategoriaDto actualizarCategoria(Integer id, CategoriaDto categoriaDto);

    void eliminarCategoria(Integer id);
}
