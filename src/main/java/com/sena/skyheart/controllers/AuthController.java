package com.sena.skyheart.controllers;

import com.sena.skyheart.dtos.LoginRequestDto;
import com.sena.skyheart.dtos.UsuarioAuthCreateDTO;
import com.sena.skyheart.dtos.UsuarioAuthResponseDto;
import com.sena.skyheart.services.UsuarioAuthService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {

    private final UsuarioAuthService usuarioAuthService;

    @PostMapping("/registro")
    public ResponseEntity<UsuarioAuthResponseDto> registrar(@Valid @RequestBody UsuarioAuthCreateDTO dto) {
        UsuarioAuthResponseDto creado = usuarioAuthService.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioAuthResponseDto> login(@Valid @RequestBody LoginRequestDto request) {
        UsuarioAuthResponseDto respuesta = usuarioAuthService.login(request);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioAuthResponseDto>> listarTodos() {
        return ResponseEntity.ok(usuarioAuthService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioAuthResponseDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioAuthService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioAuthService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}