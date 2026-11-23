package com.sena.skyheart.controllers;

import com.sena.skyheart.dtos.DomiciliarioDto;
import com.sena.skyheart.dtos.DomiciliarioDtoResponse;
import com.sena.skyheart.services.DomiciliarioService;

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
@RequestMapping("/api/domiciliarios")
@RequiredArgsConstructor
public class DomiciliarioController {

    private final DomiciliarioService domiciliarioService;

    // Registrar nuevo domiciliario
    @PostMapping
    public ResponseEntity<DomiciliarioDtoResponse> guardar(
            @Valid @RequestBody DomiciliarioDto domiciliarioDto) {

        DomiciliarioDtoResponse domiciliarioGuardado = domiciliarioService.guardar(domiciliarioDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(domiciliarioGuardado);
    }

    // Listar todos los domiciliarios
    @GetMapping
    public ResponseEntity<List<DomiciliarioDtoResponse>> listarTodos() {

        return ResponseEntity.ok(domiciliarioService.listarTodos());
    }

    // Consultar domiciliario por ID
    @GetMapping("/{id}")
    public ResponseEntity<DomiciliarioDtoResponse> consultaId(
            @PathVariable Long id) {

        return ResponseEntity.ok(domiciliarioService.buscarPorId(id));
    }

// Consultar domiciliario por POST
@PostMapping("/buscar")
public ResponseEntity<DomiciliarioDtoResponse> consultaIdPost(
        @RequestBody DomiciliarioDtoResponse dto) {

    DomiciliarioDtoResponse encontrado =
            domiciliarioService.buscarPorId(dto.getDomiciliario());

    return ResponseEntity.ok(encontrado);
}

    // Actualizar domiciliario por ID
    @PutMapping("/{id}")
    public ResponseEntity<DomiciliarioDtoResponse> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody DomiciliarioDto dto) {

        DomiciliarioDtoResponse domiciliarioActualizado =
                domiciliarioService.actualizar(id, dto);

        return ResponseEntity.ok(domiciliarioActualizado);
    }

// Eliminar domiciliario
@DeleteMapping("/{id}")
public ResponseEntity<String> delete(
        @PathVariable Long id) {

    domiciliarioService.eliminar(id);

    return ResponseEntity.ok("Domiciliario eliminado correctamente");
}
}