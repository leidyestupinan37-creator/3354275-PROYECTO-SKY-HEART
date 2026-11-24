
package com.sena.skyheart.models.usuario.auth;

import com.sena.skyheart.models.usuario.Usuario;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios_auth")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioAuth {

    @Id
    private Long id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "username", nullable = false, unique = true, length = 80)
    private String user;

    @Column(name = "password", nullable = false)
    private String pass;

    @Builder.Default
    @Column(name = "habilitado", nullable = false)
    private boolean habilitado = true;

    @Builder.Default
    @Column(name = "intentos_fallidos", nullable = false)
    private Integer intentosFallidos = 0;

    @Column(name = "bloqueado_hasta")
    private LocalDateTime bloqueadoHasta;

    @OneToMany(mappedBy = "usuarioAuth", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<UsuarioAuthRol> roles = new HashSet<>();

    public void agregarRol(UsuarioAuthRol rolAsignado) {
        if (rolAsignado == null) {
            return;
        }

        rolAsignado.setUsuarioAuth(this);
        this.roles.add(rolAsignado);
    }
}
