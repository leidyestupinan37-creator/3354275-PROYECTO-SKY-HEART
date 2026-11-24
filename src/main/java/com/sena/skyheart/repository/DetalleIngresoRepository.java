package com.sena.skyheart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.skyheart.models.usuario.DetalleIngreso;

public interface DetalleIngresoRepository extends JpaRepository<DetalleIngreso, Long> {

}