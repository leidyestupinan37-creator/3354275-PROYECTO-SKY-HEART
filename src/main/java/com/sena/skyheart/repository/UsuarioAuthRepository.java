package com.sena.skyheart.repository;

import com.sena.skyheart.models.usuario.auth.UsuarioAuth;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioAuthRepository extends JpaRepository<UsuarioAuth, Long> {

    Optional<UsuarioAuth> findByUser(String user);

    boolean existsByUser(String user);

    boolean existsByUsuarioId(Long usuarioId);
}