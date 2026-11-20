package com.sena.skyheart.models.usuario;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SuperBuilder;

@Entity
@Table(name = "administrador")
@Getter @Setter
@NoArgsConstructor
@SuperBuilder

public class Administrador extends Usuario {

}
