package com.sena.skyheart.controllers;

import com.sena.skyheart.dtos.DevolucionesDto;
import com.sena.skyheart.services.DevolucionesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devoluciones")
public class DevolucionesController {

    private final DevolucionesService devolucionService;

    public DevolucionesController(DevolucionesService devolucionService) {
        this.devolucionService = devolucionService;
    }

    @GetMapping
    public ResponseEntity<List<DevolucionesDto>> listarTodas() {
        return ResponseEntity.ok(devolucionService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DevolucionesDto> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(devolucionService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<DevolucionesDto> crear(@RequestBody DevolucionesDto dto) {
        DevolucionesDto creada = devolucionService.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DevolucionesDto> actualizar(@PathVariable Integer id,
                                                    @RequestBody DevolucionesDto dto) {
        return ResponseEntity.ok(devolucionService.actualizar(id, dto));
    }

    @PatchMapping("/{id}/autorizar-reembolso")
    public ResponseEntity<DevolucionesDto> autorizarReembolso(@PathVariable Integer id) {
        return ResponseEntity.ok(devolucionService.autorizarReembolso(id));
    }

    @GetMapping("/{id}/validar-motivo")
    public ResponseEntity<Boolean> validarMotivo(@PathVariable Integer id) {
        return ResponseEntity.ok(devolucionService.validarMotivo(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        devolucionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}