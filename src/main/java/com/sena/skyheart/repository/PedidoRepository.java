package com.sena.skyheart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sena.skyheart.models.usuario.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}