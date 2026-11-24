package com.sena.skyheart.controllers;

import com.sena.skyheart.dtos.RolDto;
import com.sena.skyheart.services.RolService;

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
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RolController {

    private final RolService rolService;

    // Registrar nuevo rol
    @PostMapping
    public ResponseEntity<RolDto> guardar(
            @Valid @RequestBody RolDto rolDto) {

        RolDto rolGuardado = rolService.crearRol(rolDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(rolGuardado);
    }

    // Listar todos los roles
    @GetMapping
    public ResponseEntity<List<RolDto>> listarTodos() {

        return ResponseEntity.ok(rolService.listarRoles());
    }

    // Consultar rol por ID
    @GetMapping("/{id}")
    public ResponseEntity<RolDto> consultaId(
            @PathVariable Integer id) {

        return ResponseEntity.ok(rolService.buscarPorId(id));
    }

    // Consultar rol por POST
    @PostMapping("/buscar")
    public ResponseEntity<RolDto> consultaIdPost(
            @RequestBody RolDto dto) {

        RolDto encontrado =
                rolService.buscarPorId(dto.getIdRol());

        return ResponseEntity.ok(encontrado);
    }

    // Actualizar rol por ID
    @PutMapping("/{id}")
    public ResponseEntity<RolDto> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody RolDto dto) {

        RolDto rolActualizado =
                rolService.actualizarRol(id, dto);

        return ResponseEntity.ok(rolActualizado);
    }

    // Eliminar rol
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Integer id) {

        rolService.eliminarRol(id);

        return ResponseEntity.ok("Rol eliminado correctamente");
    }
}