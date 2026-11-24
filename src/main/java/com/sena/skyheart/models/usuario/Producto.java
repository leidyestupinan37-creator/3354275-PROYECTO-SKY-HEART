package com.sena.skyheart.models.usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_categoria")
    private Categoria categoria;

    @Column(name = "nombre_producto", nullable = false, length = 100)
    private String nombreProducto;

    @Column(name = "precio_producto", nullable = false)
    private Float precioProducto;

    @Column(name = "estado_producto", nullable = false)
    private Boolean estadoProducto = true;

    @Column(name = "stock", nullable = false)
    private Integer stock;
}
