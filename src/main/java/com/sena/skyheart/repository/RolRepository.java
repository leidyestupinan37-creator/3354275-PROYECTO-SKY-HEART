package com.sena.skyheart.repository;


import com.sena.skyheart.models.usuario.auth.Rol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RolRepository extends JpaRepository<Rol, Byte> {

    Optional<Rol> findByNombre(String nombre);
}