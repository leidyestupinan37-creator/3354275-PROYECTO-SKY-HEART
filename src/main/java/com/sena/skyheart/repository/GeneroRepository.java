package com.sena.skyheart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sena.skyheart.models.usuario.Genero;


public interface GeneroRepository extends JpaRepository<Genero, Integer> {
}