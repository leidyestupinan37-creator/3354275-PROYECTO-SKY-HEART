
package com.sena.skyheart.models.usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "ingresos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Ingreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero")
    private Integer numero;

    @Column(name = "fecha", nullable = false)
    private String fecha;

    @Column(name = "usuario", nullable = false)
    private String usuario;

    @Column(name = "nombre_producto", nullable = false)
    private String nombreProducto;

    @Column(name = "factura", nullable = false)
    private String factura;

    public void registrarIngreso() {
    }

    public void modificarIngreso() {
    }

    public void consultarIngreso() {
    }
}
