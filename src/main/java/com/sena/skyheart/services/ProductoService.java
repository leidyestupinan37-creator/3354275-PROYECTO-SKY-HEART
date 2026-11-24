package com.sena.skyheart.services;

import java.util.List;

import com.sena.skyheart.dtos.ProductoDto;

public interface ProductoService {

    List<ProductoDto> listarProductos();

    ProductoDto buscarPorId(Integer id);

    ProductoDto crearProducto(ProductoDto productoDto);

    ProductoDto actualizarProducto(Integer id, ProductoDto productoDto);

    void eliminarProducto(Integer id);
}
