
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

import com.sena.skyheart.dtos.DepartamentoDto;
import com.sena.skyheart.services.DepartamentoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/departamentos")
@RequiredArgsConstructor
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    // Registrar un departamento
    @PostMapping
    public ResponseEntity<DepartamentoDto> guardar(@RequestBody DepartamentoDto departamentoDto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(departamentoService.guardar(departamentoDto));
    }

    // Listar todos los departamentos
    @GetMapping
    public ResponseEntity<List<DepartamentoDto>> listarTodos() {

        return ResponseEntity.ok(departamentoService.listarTodos());
    }

    // Buscar departamento por código
    @GetMapping("/{codigo}")
    public ResponseEntity<DepartamentoDto> buscarPorId(@PathVariable String codigo) {

        return ResponseEntity.ok(departamentoService.buscarPorId(codigo));
    }

    // Actualizar departamento
    @PutMapping("/{codigo}")
    public ResponseEntity<DepartamentoDto> actualizar(
            @PathVariable String codigo,
            @RequestBody DepartamentoDto departamentoDto) {

        return ResponseEntity.ok(departamentoService.actualizar(codigo, departamentoDto));
    }

    // Eliminar departamento
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> eliminar(@PathVariable String codigo) {

        departamentoService.eliminar(codigo);

        return ResponseEntity.noContent().build();
    }
}
