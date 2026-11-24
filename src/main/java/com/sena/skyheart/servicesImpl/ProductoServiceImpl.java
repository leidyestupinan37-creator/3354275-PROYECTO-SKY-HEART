package com.sena.skyheart.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sena.skyheart.dtos.ProductoDto;
import com.sena.skyheart.mappers.ProductoMapper;
import com.sena.skyheart.models.usuario.Categoria;
import com.sena.skyheart.models.usuario.Producto;
import com.sena.skyheart.repository.CategoriaRepository;
import com.sena.skyheart.repository.ProductoRepository;
import com.sena.skyheart.services.ProductoService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    private final ProductoMapper productoMapper;

    @Override
    public List<ProductoDto> listarProductos() {
        return productoRepository.findAll()
                .stream()
                .map(productoMapper::ConvierteaDto)
                .toList();
    }

    @Override
    public ProductoDto buscarPorId(Integer id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() ->
                    new EntityNotFoundException(
                        "Producto no encontrado con ID: " + id));

        return productoMapper.ConvierteaDto(producto);
    }

    @Override
    public ProductoDto crearProducto(ProductoDto productoDto) {
        Producto producto = productoMapper.ToEntidad(productoDto);

        if (productoDto.getFkCategoria() != null) {
            Categoria categoria = categoriaRepository.findById(productoDto.getFkCategoria())
                    .orElseThrow(() ->
                        new EntityNotFoundException(
                            "Categoría no encontrada con ID: " + productoDto.getFkCategoria()));
            producto.setCategoria(categoria);
        }

        Producto productoGuardado = productoRepository.save(producto);

        return productoMapper.ConvierteaDto(productoGuardado);
    }

    @Override
    public ProductoDto actualizarProducto(Integer id, ProductoDto productoDto) {
        Producto productoEncontrado = productoRepository.findById(id)
                .orElseThrow(() ->
                    new EntityNotFoundException(
                        "No se encuentra producto con ID: " + id));

        productoEncontrado.setNombreProducto(productoDto.getNombreProducto());
        productoEncontrado.setPrecioProducto(productoDto.getPrecioProducto());
        productoEncontrado.setEstadoProducto(productoDto.getEstadoProducto());
        productoEncontrado.setStock(productoDto.getStock());

        if (productoDto.getFkCategoria() != null) {
            Categoria categoria = categoriaRepository.findById(productoDto.getFkCategoria())
                    .orElseThrow(() ->
                        new EntityNotFoundException(
                            "Categoría no encontrada con ID: " + productoDto.getFkCategoria()));
            productoEncontrado.setCategoria(categoria);
        } else {
            productoEncontrado.setCategoria(null);
        }

        Producto productoActualizado = productoRepository.save(productoEncontrado);

        return productoMapper.ConvierteaDto(productoActualizado);
    }

    @Override
    public void eliminarProducto(Integer id) {
        Producto productoEncontrado = productoRepository.findById(id)
                .orElseThrow(() ->
                    new EntityNotFoundException(
                        "No se encuentra producto con ID: " + id));

        productoRepository.delete(productoEncontrado);
    }
}
