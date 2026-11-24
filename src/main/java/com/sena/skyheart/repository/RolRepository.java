package com.sena.skyheart.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.skyheart.models.usuario.Rol;

public interface RolRepository extends JpaRepository<Rol, Byte> {

    Optional<Rol> findByNombre(String nombre);
}