
package com.sena.skyheart.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class IngresoDto {

    private Long numero;
    private String fecha;
    private String usuario;
    private String nombreProducto;
    private String factura;
}
