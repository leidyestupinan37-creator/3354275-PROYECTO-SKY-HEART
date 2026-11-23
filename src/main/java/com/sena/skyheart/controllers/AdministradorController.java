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

import com.sena.skyheart.dtos.AdministradorDto;

import com.sena.skyheart.services.AdministradorService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/administradores")
@RequiredArgsConstructor
public class AdministradorController {

    private final AdministradorService administradorService;

    @PostMapping
    public ResponseEntity <AdministradorDto> Guardar (@Valid @RequestBody AdministradorDto administradorDto) {
        AdministradorDto administradorGuardado = administradorService.guardar(administradorDto);
        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(administradorGuardado);
    }
    
    //listar Administradores
    @GetMapping
    public ResponseEntity<List<AdministradorDto>> ListarTodos() {
        return ResponseEntity.ok(administradorService.listarTodos());
    }
    
    //Consultar administrador por Id
    @GetMapping("/{id}")
    public ResponseEntity<AdministradorDto> consultaId(@PathVariable Long id){
        return ResponseEntity.ok(administradorService.buscarPorId(id));
    }

    //Consultar administrador por Post
    @PostMapping("/buscar")
    public ResponseEntity<AdministradorDto> consultarIdPost(@RequestBody AdministradorDto dto){
        AdministradorDto encontrado = administradorService.buscarPorId(dto.getId());
        return ResponseEntity.ok(encontrado);
    }

   //Actualizar administrador
    @PutMapping("/{id}")
    public ResponseEntity<AdministradorDto> update(@PathVariable Long id, @RequestBody AdministradorDto administradorDto) {
        AdministradorDto administradorActualizado = administradorService.actualizar(id, administradorDto);
        return ResponseEntity.ok(administradorActualizado);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<AdministradorDto> update(@RequestBody AdministradorDto administradorDto) {
        AdministradorDto administradorActualizado = administradorService.actualizar(administradorDto.getId(), administradorDto);
        return ResponseEntity.ok(administradorActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id, @RequestBody AdministradorDto administradorDto) {
        administradorService.eliminar(id);
        return ResponseEntity.ok("Administrador eliminado correctamente");
    }
}
