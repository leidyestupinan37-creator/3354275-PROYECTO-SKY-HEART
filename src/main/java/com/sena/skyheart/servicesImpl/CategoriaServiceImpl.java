package com.sena.skyheart.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sena.skyheart.dtos.CategoriaDto;
import com.sena.skyheart.mappers.CategoriaMapper;
import com.sena.skyheart.models.usuario.Categoria;
import com.sena.skyheart.repository.CategoriaRepository;
import com.sena.skyheart.services.CategoriaService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CategoriaDto> listarCategorias() {
        return categoriaRepository.findAll()
                .stream()
                .map(categoriaMapper::ToDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CategoriaDto buscarPorId(Integer id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Categoría no encontrada con ID: " + id));

        return categoriaMapper.ToDto(categoria);
    }

    @Override
    @Transactional
    public CategoriaDto crearCategoria(CategoriaDto categoriaDto) {
        Categoria categoria = categoriaMapper.ToEntidad(categoriaDto);
        Categoria categoriaGuardada = categoriaRepository.save(categoria);

        return categoriaMapper.ToDto(categoriaGuardada);
    }

    @Override
    @Transactional
    public CategoriaDto actualizarCategoria(Integer id, CategoriaDto categoriaDto) {
        Categoria categoriaEncontrada = categoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "No se encuentra categoría con ID: " + id));

        categoriaEncontrada.setFkProducto(categoriaDto.getFkProducto());
        categoriaEncontrada.setOfertasProductos(categoriaDto.getOfertasProductos());

        Categoria categoriaActualizada = categoriaRepository.save(categoriaEncontrada);

        return categoriaMapper.ToDto(categoriaActualizada);
    }

    @Override
    @Transactional
    public void eliminarCategoria(Integer id) {
        Categoria categoriaEncontrada = categoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "No se encuentra categoría con ID: " + id));

        categoriaRepository.delete(categoriaEncontrada);
    }
}
