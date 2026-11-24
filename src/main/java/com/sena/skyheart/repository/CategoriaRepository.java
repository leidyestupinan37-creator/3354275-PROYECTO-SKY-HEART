package com.sena.skyheart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.skyheart.models.usuario.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
