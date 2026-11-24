package com.sena.skyheart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.skyheart.models.usuario.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
