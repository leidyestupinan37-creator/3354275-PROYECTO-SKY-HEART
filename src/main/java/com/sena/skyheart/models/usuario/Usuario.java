package com.sena.skyheart.models.usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SuperBuilder;

@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Usuario {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero de identificacion", nullable = false, length = 10)
    private String numIde;

    @Column(name = "nombre", nullable = false, length = 60)
    private String nom;

    @Column(name = "apellido", nullable = false, length = 60)
    private String ape;

    @Column (name = "correo", nullable = false, length = 60)
    private String corr;

    @Column (name = "direccion", nullable = false, length = 20)
    private String dir;

    @Column (name = "contraseña", nullable = false, length = 60)
    private String contra;

    @Column (name = "fecha de nacimiento", nullable = false, length = 10)
    private String fechaNac;

    @Column (name = "telefono", nullable = false, length = 10)
    private String tel;
}
