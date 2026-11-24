package com.sena.skyheart.controllers;

import com.sena.skyheart.dtos.PedidoDevolucionDto;
import com.sena.skyheart.services.PedidoDevolucionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido-devoluciones")
public class PedidoDevolucionController {

    private final PedidoDevolucionService pedidoDevolucionService;

    public PedidoDevolucionController(PedidoDevolucionService pedidoDevolucionService) {
        this.pedidoDevolucionService = pedidoDevolucionService;
    }

    @GetMapping
    public ResponseEntity<List<PedidoDevolucionDto>> listarTodos() {
        return ResponseEntity.ok(pedidoDevolucionService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDevolucionDto> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(pedidoDevolucionService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<PedidoDevolucionDto> crear(@RequestBody PedidoDevolucionDto dto) {
        PedidoDevolucionDto creada = pedidoDevolucionService.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDevolucionDto> actualizar(@PathVariable Integer id,
                                                            @RequestBody PedidoDevolucionDto dto) {
        return ResponseEntity.ok(pedidoDevolucionService.actualizar(id, dto));
    }

    @PatchMapping("/{id}/procesar")
    public ResponseEntity<PedidoDevolucionDto> procesarDevolucion(@PathVariable Integer id) {
        return ResponseEntity.ok(pedidoDevolucionService.procesarDevolucion(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        pedidoDevolucionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}