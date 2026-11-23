package com.sena.skyheart.models.usuario.auth;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UsuarioAuthRolId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "usuario_auth_id", nullable = false)
    private Long usuarioAuthId;

    @Column(name = "rol_id", nullable = false)
    private Long rolId;
}