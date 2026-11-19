
package com.sena.skyheart.controllers;

import com.sena.skyheart.dtos.ClienteDto;
import com.sena.skyheart.dtos.ClienteDtoResponse;
import com.sena.skyheart.services.ClienteService;

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
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    // Registrar nuevo cliente
    @PostMapping
    public ResponseEntity<ClienteDtoResponse> guardar(
            @Valid @RequestBody ClienteDto clienteDto) {

        ClienteDtoResponse clienteGuardado = clienteService.guardar(clienteDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(clienteGuardado);
    }

    // Listar todos los clientes
    @GetMapping
    public ResponseEntity<List<ClienteDtoResponse>> listarTodos() {

        return ResponseEntity.ok(clienteService.listarTodos());
    }

    // Consultar cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDtoResponse> consultaId(
            @PathVariable Long id) {

        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    // Consultar cliente por POST
    @PostMapping("/buscar")
    public ResponseEntity<ClienteDtoResponse> consultaIdPost(
            @RequestBody ClienteDto dto) {

        ClienteDtoResponse encontrado =
                clienteService.buscarPorId(dto.getId());

        return ResponseEntity.ok(encontrado);
    }

    // Actualizar cliente por ID
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDtoResponse> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody ClienteDto dto) {

        ClienteDtoResponse clienteActualizado =
                clienteService.actualizar(id, dto);

        return ResponseEntity.ok(clienteActualizado);
    }

    // Eliminar cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id) {

        clienteService.eliminar(id);

        return ResponseEntity.ok("Cliente eliminado correctamente");
    }
}
