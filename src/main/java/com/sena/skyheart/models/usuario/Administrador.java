package com.sena.skyheart.models.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
<<<<<<< HEAD
=======

>>>>>>> fd62b46a5aecbce00e98cd1d9df13506beb871cb

@Entity
@Table(name = "administrador")
@PrimaryKeyJoinColumn(name = "administrador_id")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Administrador extends Usuario {

}