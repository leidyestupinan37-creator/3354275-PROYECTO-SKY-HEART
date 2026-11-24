package com.sena.skyheart.repository;

import com.sena.skyheart.models.usuario.PedidoDevolucion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoDevolucionRepository extends JpaRepository<PedidoDevolucion, Integer> {
}