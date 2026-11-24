package com.sena.skyheart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.skyheart.models.usuario.Ingreso;

public interface IngresoRepository extends JpaRepository<Ingreso, Long> {

}