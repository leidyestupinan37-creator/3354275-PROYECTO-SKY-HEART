package com.sena.skyheart.dtos;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDto {

    private Integer categoria;

    private Integer fkProducto;

    @Size(max = 255, message = "Las ofertas de productos no pueden superar los 255 caracteres")
    private String ofertasProductos;
}