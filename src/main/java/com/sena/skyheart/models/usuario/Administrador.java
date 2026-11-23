package com.sena.skyheart.models.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import lombok.SuperBuilder;
>>>>>>> 0a83aacd33e6b55de47a108dc58ebf555b55b797
=======
import lombok.experimental.SuperBuilder;
>>>>>>> 048d8a2bc1f60df8c63ec3dad47ce852219b5e0f

@Entity
@Table(name = "administrador")
@PrimaryKeyJoinColumn(name = "administrador_id")
@Getter
@Setter
@NoArgsConstructor
<<<<<<< HEAD
<<<<<<< HEAD
=======
@SuperBuilder
>>>>>>> 0a83aacd33e6b55de47a108dc58ebf555b55b797

=======
@SuperBuilder
>>>>>>> 048d8a2bc1f60df8c63ec3dad47ce852219b5e0f
public class Administrador extends Usuario {

}