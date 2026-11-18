package com.sena.skyheart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.skyheart.models.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
