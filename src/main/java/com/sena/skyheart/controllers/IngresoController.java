
package com.sena.skyheart.controllers;

import com.sena.skyheart.dtos.IngresoDto;
import com.sena.skyheart.services.IngresoService;

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
@RequestMapping("/api/ingresos")
@RequiredArgsConstructor
public class IngresoController {

    private final IngresoService ingresoService;

    // Registrar nuevo ingreso
    @PostMapping
    public ResponseEntity<IngresoDto> guardar(
            @Valid @RequestBody IngresoDto ingresoDto) {

        IngresoDto guardado = ingresoService.guardar(ingresoDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(guardado);
    }

    // Listar todos los ingresos
    @GetMapping
    public ResponseEntity<List<IngresoDto>> listarTodos() {
        return ResponseEntity.ok(ingresoService.listarTodos());
    }

    // Consultar ingreso por número
    @GetMapping("/{id}")
    public ResponseEntity<IngresoDto> consultaId(
            @PathVariable Long id) {

        return ResponseEntity.ok(ingresoService.buscarPorId(id));
    }

    // Consultar ingreso por POST
    @PostMapping("/buscar")
    public ResponseEntity<IngresoDto> consultaIdPost(
            @RequestBody IngresoDto dto) {

        IngresoDto encontrado =
                ingresoService.buscarPorId(dto.getNumero());

        return ResponseEntity.ok(encontrado);
    }

    // Actualizar ingreso por número
    @PutMapping("/{id}")
    public ResponseEntity<IngresoDto> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody IngresoDto dto) {

        IngresoDto actualizado =
                ingresoService.actualizar(id, dto);

        return ResponseEntity.ok(actualizado);
    }

    // Eliminar ingreso
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id) {

        ingresoService.eliminar(id);

        return ResponseEntity.ok("Ingreso eliminado correctamente");
    }
}
