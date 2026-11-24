package com.sena.skyheart.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.skyheart.dtos.ProductoDto;
import com.sena.skyheart.services.ProductoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    // Registrar nuevo producto
    @PostMapping
    public ResponseEntity<ProductoDto> guardar(
            @Valid @RequestBody ProductoDto productoDto) {

        ProductoDto productoGuardado = productoService.crearProducto(productoDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productoGuardado);
    }

    // Listar todos los productos
    @GetMapping
    public ResponseEntity<List<ProductoDto>> listarTodos() {

        return ResponseEntity.ok(productoService.listarProductos());
    }

    // Consultar producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> consultaId(
            @PathVariable Integer id) {

        return ResponseEntity.ok(productoService.buscarPorId(id));
    }

    // Consultar producto por POST
    @PostMapping("/buscar")
    public ResponseEntity<ProductoDto> consultaIdPost(
            @RequestBody ProductoDto dto) {

        ProductoDto encontrado =
                productoService.buscarPorId(dto.getProducto());

        return ResponseEntity.ok(encontrado);
    }

    // Actualizar producto por ID
    @PutMapping("/{id}")
    public ResponseEntity<ProductoDto> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody ProductoDto dto) {

        ProductoDto productoActualizado =
                productoService.actualizarProducto(id, dto);

        return ResponseEntity.ok(productoActualizado);
    }

    // Eliminar producto
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Integer id) {

        productoService.eliminarProducto(id);

        return ResponseEntity.ok("Producto eliminado correctamente");
    }
}
