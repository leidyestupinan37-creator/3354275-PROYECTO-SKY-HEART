package com.sena.skyheart.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDto {

    private Integer producto;

    private Integer fkCategoria;

    @NotBlank(message = "El nombre del producto es obligatorio")
    @Size(max = 100, message = "El nombre del producto no puede superar los 100 caracteres")
    private String nombreProducto;

    @NotNull(message = "El precio del producto es obligatorio")
    @PositiveOrZero(message = "El precio del producto no puede ser negativo")
    private Float precioProducto;

    @NotNull(message = "El estado del producto es obligatorio")
    private Boolean estadoProducto;

    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer stock;
}
