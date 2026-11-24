package com.sena.skyheart.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.skyheart.dtos.LoginRequestDto;
import com.sena.skyheart.dtos.UsuarioAuthCreateDTO;
import com.sena.skyheart.dtos.UsuarioAuthResponseDto;
import com.sena.skyheart.services.UsuarioAuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuarios-auth")
@RequiredArgsConstructor
public class UsuarioAuthController {

    private final UsuarioAuthService usuarioAuthService;

    // 1. Crear credenciales de usuario
    @PostMapping("/registro")
    public ResponseEntity<?> crear(@RequestBody UsuarioAuthCreateDTO dto) {

        try {
            UsuarioAuthResponseDto respuesta = usuarioAuthService.crear(dto);

            return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 2. Iniciar sesión
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto request) {

        try {
            UsuarioAuthResponseDto respuesta = usuarioAuthService.login(request);

            return ResponseEntity.ok(respuesta);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(e.getMessage());

        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(e.getMessage());
        }
    }
}