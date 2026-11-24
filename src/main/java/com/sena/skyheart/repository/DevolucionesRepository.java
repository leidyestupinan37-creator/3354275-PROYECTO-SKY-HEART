package com.sena.skyheart.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.skyheart.models.usuario.Devoluciones;

public interface DevolucionesRepository extends JpaRepository<Devoluciones, Integer> {}