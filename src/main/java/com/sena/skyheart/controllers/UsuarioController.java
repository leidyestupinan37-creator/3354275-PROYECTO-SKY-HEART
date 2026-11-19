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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.skyheart.dtos.UsuarioDto;
import com.sena.skyheart.services.UsuarioService; 

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService; 
    // 1. Registrar nuevo usuario
    @PostMapping
    public ResponseEntity<UsuarioDto> guardar(
            @Valid @RequestBody UsuarioDto usuarioDto) {

        UsuarioDto usuarioguardado = usuarioService.guardar(usuarioDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usuarioguardado);
    }

    // 1.1 Registrar múltiples usuarios por lote
    @PostMapping("/lote")
    public ResponseEntity<List<UsuarioDto>> guardarTodos(
            @Valid @RequestBody List<UsuarioDto> usuarioDtos) {

        List<UsuarioDto> usuariosGuardados = usuarioService.guardarTodos(usuarioDtos);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usuariosGuardados);
    }

    // 2. Listar todos los usuarios
    @GetMapping
    public ResponseEntity<List<UsuarioDto>> listarTodos() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }

    // 4. Consultar usuario por POST
    @PostMapping("/buscar")
    public ResponseEntity<UsuarioDto> consultaIdpost(
            @RequestBody UsuarioDto dto) {

        UsuarioDto encontrado =
                usuarioService.buscarPorId(dto.getId());

        return ResponseEntity.ok(encontrado);
    }

    // 5. Actualizar usuario sin exponer el ID en la URL
    @PutMapping("/actualizar")
    public ResponseEntity<UsuarioDto> actualizar(
            @RequestHeader("id") Long id,
            @RequestBody UsuarioDto dto) {

        UsuarioDto usuarioActualizado =
                usuarioService.actualizar(id, dto);

        return ResponseEntity.ok(usuarioActualizado);
    }

    // 6. Eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        usuarioService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}