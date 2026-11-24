
package com.sena.skyheart.controllers;

import com.sena.skyheart.dtos.DetalleIngresoDto;
import com.sena.skyheart.services.DetalleIngresoService;

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
@RequestMapping("/api/detalles-ingreso")
@RequiredArgsConstructor
public class DetalleIngresoController {

    private final DetalleIngresoService detalleIngresoService;

    // Registrar nuevo detalle de ingreso
    @PostMapping
    public ResponseEntity<DetalleIngresoDto> guardar(
            @Valid @RequestBody DetalleIngresoDto detalleIngresoDto) {

        DetalleIngresoDto guardado = detalleIngresoService.guardar(detalleIngresoDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(guardado);
    }

    // Listar todos los detalles de ingreso
    @GetMapping
    public ResponseEntity<List<DetalleIngresoDto>> listarTodos() {
        return ResponseEntity.ok(detalleIngresoService.listarTodos());
    }

    // Consultar detalle de ingreso por ID
    @GetMapping("/{id}")
    public ResponseEntity<DetalleIngresoDto> consultaId(
            @PathVariable Long id) {

        return ResponseEntity.ok(detalleIngresoService.buscarPorId(id));
    }

    // Consultar detalle de ingreso por POST
    @PostMapping("/buscar")
    public ResponseEntity<DetalleIngresoDto> consultaIdPost(
            @RequestBody DetalleIngresoDto dto) {

        DetalleIngresoDto encontrado =
                detalleIngresoService.buscarPorId(dto.getId());

        return ResponseEntity.ok(encontrado);
    }

    // Actualizar detalle de ingreso por ID
    @PutMapping("/{id}")
    public ResponseEntity<DetalleIngresoDto> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody DetalleIngresoDto dto) {

        DetalleIngresoDto actualizado =
                detalleIngresoService.actualizar(id, dto);

        return ResponseEntity.ok(actualizado);
    }

    // Eliminar detalle de ingreso
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id) {

        detalleIngresoService.eliminar(id);

        return ResponseEntity.ok("Detalle de ingreso eliminado correctamente");
    }
}
