package com.sena.skyheart.repository;

import com.sena.skyheart.models.usuario.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}