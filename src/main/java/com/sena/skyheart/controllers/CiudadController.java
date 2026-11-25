
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

import com.sena.skyheart.dtos.CiudadDto;
import com.sena.skyheart.services.CiudadService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/ciudades")
@RequiredArgsConstructor
public class CiudadController {

    private final CiudadService ciudadService;

    // Registrar una ciudad
    @PostMapping
    public ResponseEntity<CiudadDto> guardar(@RequestBody CiudadDto ciudadDto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ciudadService.guardar(ciudadDto));
    }

    // Listar todas las ciudades
    @GetMapping
    public ResponseEntity<List<CiudadDto>> listarTodos() {

        return ResponseEntity.ok(ciudadService.listarTodos());
    }

    // Buscar ciudad por código
    @GetMapping("/{codigo}")
    public ResponseEntity<CiudadDto> buscarPorId(@PathVariable String codigo) {

        return ResponseEntity.ok(ciudadService.buscarPorId(codigo));
    }

    // Actualizar ciudad
    @PutMapping("/{codigo}")
    public ResponseEntity<CiudadDto> actualizar(
            @PathVariable String codigo,
            @RequestBody CiudadDto ciudadDto) {

        return ResponseEntity.ok(ciudadService.actualizar(codigo, ciudadDto));
    }

    // Eliminar ciudad
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> eliminar(@PathVariable String codigo) {

        ciudadService.eliminar(codigo);

        return ResponseEntity.noContent().build();
    }
}
