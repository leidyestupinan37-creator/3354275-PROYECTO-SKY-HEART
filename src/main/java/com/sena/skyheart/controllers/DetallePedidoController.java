package com.sena.skyheart.controllers;

import com.sena.skyheart.dtos.DetallePedidoDto;
import com.sena.skyheart.services.DetallePedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/detalle-pedidos")
public class DetallePedidoController {

    private final DetallePedidoService detallePedidoService;

    public DetallePedidoController(DetallePedidoService detallePedidoService) {
        this.detallePedidoService = detallePedidoService;
    }

    @GetMapping
    public ResponseEntity<List<DetallePedidoDto>> listarTodos() {
        return ResponseEntity.ok(detallePedidoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedidoDto> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(detallePedidoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<DetallePedidoDto> crear(@RequestBody DetallePedidoDto dto) {
        DetallePedidoDto creado = detallePedidoService.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallePedidoDto> actualizar(@PathVariable Integer id,
                                                         @RequestBody DetallePedidoDto dto) {
        return ResponseEntity.ok(detallePedidoService.actualizar(id, dto));
    }

    @GetMapping("/{id}/subtotal")
    public ResponseEntity<BigDecimal> calcularSubtotal(@PathVariable Integer id) {
        return ResponseEntity.ok(detallePedidoService.calcularSubtotal(id));
    }

    @GetMapping("/total")
    public ResponseEntity<BigDecimal> calcularTotalDetalles() {
        return ResponseEntity.ok(detallePedidoService.calcularTotalDetalles());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        detallePedidoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}