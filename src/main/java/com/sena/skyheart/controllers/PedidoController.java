package com.sena.skyheart.controllers;

import com.sena.skyheart.dtos.PedidoDto;
import com.sena.skyheart.services.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public ResponseEntity<List<PedidoDto>> listarTodos() {
        return ResponseEntity.ok(pedidoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDto> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(pedidoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<PedidoDto> crear(@RequestBody PedidoDto dto) {
        PedidoDto creado = pedidoService.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDto> actualizar(@PathVariable Integer id,
                                                  @RequestBody PedidoDto dto) {
        return ResponseEntity.ok(pedidoService.actualizar(id, dto));
    }

    @PatchMapping("/{id}/total")
    public ResponseEntity<BigDecimal> calcularTotal(@PathVariable Integer id,
                                                    @RequestParam BigDecimal monto) {
        return ResponseEntity.ok(pedidoService.calcularTotal(id, monto));
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<PedidoDto> cambiarEstado(@PathVariable Integer id,
                                             @RequestParam String estado) {
        return ResponseEntity.ok(pedidoService.cambiarEstado(id, estado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        pedidoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}