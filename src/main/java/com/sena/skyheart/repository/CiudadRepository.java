package com.sena.skyheart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.skyheart.models.usuario.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, String>{
List<Ciudad> findByDepartamentoCodigo(String codigo);
}
