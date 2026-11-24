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

import com.sena.skyheart.dtos.GeneroDto;
import com.sena.skyheart.services.GeneroService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController 
@RequestMapping ("/api/generos")
@RequiredArgsConstructor 
public class GeneroController {

    private final GeneroService generoService;

    // Registrar nuevo género
    @PostMapping
    public ResponseEntity<GeneroDto> guardar(
            @Valid @RequestBody GeneroDto generoDto) {

        GeneroDto generoGuardado = generoService.crearGenero(generoDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(generoGuardado);
    }

    // Listar todos los géneros
    @GetMapping
    public ResponseEntity<List<GeneroDto>> listarTodos() {

        return ResponseEntity.ok(generoService.listarGeneros());
    }

    // Consultar género por ID
    @GetMapping("/{id}")
    public ResponseEntity<GeneroDto> consultaId(
            @PathVariable Integer id) {

        return ResponseEntity.ok(generoService.buscarPorId(id));
    }

    // Consultar género por POST
    @PostMapping("/buscar")
    public ResponseEntity<GeneroDto> consultaIdPost(
            @RequestBody GeneroDto dto) {

        GeneroDto encontrado =
                generoService.buscarPorId(dto.getIdGenero());

        return ResponseEntity.ok(encontrado);
    }

    // Actualizar género por ID
    @PutMapping("/{id}")
    public ResponseEntity<GeneroDto> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody GeneroDto dto) {

        GeneroDto generoActualizado =
                generoService.actualizarGenero(id, dto);

        return ResponseEntity.ok(generoActualizado);
    }

    // Eliminar género
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Integer id) {

        generoService.eliminarGenero(id);

        return ResponseEntity.ok("Género eliminado correctamente");
    }
}
