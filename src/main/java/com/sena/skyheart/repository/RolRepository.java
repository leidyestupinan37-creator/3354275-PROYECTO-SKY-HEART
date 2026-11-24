package com.sena.skyheart.repository;

<<<<<<< HEAD

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.skyheart.models.usuario.Rol;

=======
import com.sena.skyheart.models.usuario.auth.Rol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

>>>>>>> fd62b46a5aecbce00e98cd1d9df13506beb871cb
public interface RolRepository extends JpaRepository<Rol, Byte> {

    Optional<Rol> findByNombre(String nombre);
}