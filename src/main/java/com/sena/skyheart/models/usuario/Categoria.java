package com.sena.skyheart.models.usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity 
@Table (name = "categoria")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer categoria;

    @Column(name = "fk_producto")
    private Integer fkProducto;

    @Column(name = "ofertas_productos", length = 255)
    private String ofertasProductos;
}
