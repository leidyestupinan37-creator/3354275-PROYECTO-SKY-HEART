package com.sena.skyheart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.skyheart.models.usuario.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

}
