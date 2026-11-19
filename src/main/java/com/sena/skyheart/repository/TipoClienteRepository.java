package com.sena.skyheart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.skyheart.models.usuario.TiposCliente;

public interface TipoClienteRepository extends JpaRepository<TiposCliente, Integer> {

}