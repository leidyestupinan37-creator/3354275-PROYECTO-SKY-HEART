
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
@Table(name = "detalle_ingreso")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DetalleIngreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_ingreso")
    private Long id;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "precio_compra", nullable = false)
    private float precioCompra;

    public float calcularSubtotal() {
        return cantidad * precioCompra;
    }
}
