package com.sena.skyheart.models.usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;

@Entity
@Table(name = "ciudades")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ciudad {

    @Id
    @Column(name = "codigo", length = 5)
    private String codigo;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nomb;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departamento_codigo", nullable = false)
    private Departamento departamento;

    public static Ciudad crear() {
    return new Ciudad();
}
}
