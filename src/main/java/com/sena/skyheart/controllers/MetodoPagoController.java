
package com.sena.skyheart.controllers;

import com.sena.skyheart.dtos.MetodoPagoDto;
import com.sena.skyheart.services.MetodoPagoService;

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
@RequestMapping("/api/metodos-pago")
@RequiredArgsConstructor
public class MetodoPagoController {

    private final MetodoPagoService metodoPagoService;

    // Registrar nuevo método de pago
    @PostMapping
    public ResponseEntity<MetodoPagoDto> guardar(
            @Valid @RequestBody MetodoPagoDto metodoPagoDto) {

        MetodoPagoDto guardado = metodoPagoService.guardar(metodoPagoDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(guardado);
    }

    // Listar todos los métodos de pago
    @GetMapping
    public ResponseEntity<List<MetodoPagoDto>> listarTodos() {
        return ResponseEntity.ok(metodoPagoService.listarTodos());
    }

    // Consultar método de pago por ID
    @GetMapping("/{id}")
    public ResponseEntity<MetodoPagoDto> consultaId(
            @PathVariable Long id) {

        return ResponseEntity.ok(metodoPagoService.buscarPorId(id));
    }

    // Consultar método de pago por POST
    @PostMapping("/buscar")
    public ResponseEntity<MetodoPagoDto> consultaIdPost(
            @RequestBody MetodoPagoDto dto) {

        MetodoPagoDto encontrado =
                metodoPagoService.buscarPorId(dto.getId());

        return ResponseEntity.ok(encontrado);
    }

    // Actualizar método de pago por ID
    @PutMapping("/{id}")
    public ResponseEntity<MetodoPagoDto> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody MetodoPagoDto dto) {

        MetodoPagoDto actualizado =
                metodoPagoService.actualizar(id, dto);

        return ResponseEntity.ok(actualizado);
    }

    // Eliminar método de pago
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id) {

        metodoPagoService.eliminar(id);

        return ResponseEntity.ok("Método de pago eliminado correctamente");
    }
}
