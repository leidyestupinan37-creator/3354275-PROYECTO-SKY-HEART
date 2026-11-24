
package com.sena.skyheart.controllers;

import com.sena.skyheart.dtos.EstadoPedidoDto;
import com.sena.skyheart.services.EstadoPedidoService;

import jakarta.validation.Valid;
import java.util.List;

import lombok.RequiredArgsConstructor;

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

@RestController
@RequestMapping("/api/estados-pedido")
@RequiredArgsConstructor
public class EstadoPedidoController {

    private final EstadoPedidoService estadoPedidoService;

    // Registrar nuevo estado de pedido
    @PostMapping
    public ResponseEntity<EstadoPedidoDto> guardar(
            @Valid @RequestBody EstadoPedidoDto estadoPedidoDto) {

        EstadoPedidoDto guardado = estadoPedidoService.guardar(estadoPedidoDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(guardado);
    }

    // Listar todos los estados de pedido
    @GetMapping
    public ResponseEntity<List<EstadoPedidoDto>> listarTodos() {
        return ResponseEntity.ok(estadoPedidoService.listarTodos());
    }

    // Consultar estado de pedido por ID
    @GetMapping("/{id}")
    public ResponseEntity<EstadoPedidoDto> consultaId(
            @PathVariable Long id) {

        return ResponseEntity.ok(estadoPedidoService.buscarPorId(id));
    }

    // Consultar estado de pedido por POST
    @PostMapping("/buscar")
    public ResponseEntity<EstadoPedidoDto> consultaIdPost(
            @RequestBody EstadoPedidoDto dto) {

        EstadoPedidoDto encontrado =
                estadoPedidoService.buscarPorId(dto.getId());

        return ResponseEntity.ok(encontrado);
    }

    // Actualizar estado de pedido por ID
    @PutMapping("/{id}")
    public ResponseEntity<EstadoPedidoDto> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody EstadoPedidoDto dto) {

        EstadoPedidoDto actualizado =
                estadoPedidoService.actualizar(id, dto);

        return ResponseEntity.ok(actualizado);
    }

    // Eliminar estado de pedido
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id) {

        estadoPedidoService.eliminar(id);

        return ResponseEntity.ok("Estado de pedido eliminado correctamente");
    }
}
