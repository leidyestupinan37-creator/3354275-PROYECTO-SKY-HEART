package com.sena.skyheart.mappers;

import com.sena.skyheart.dtos.DetallePedidoDto;
import com.sena.skyheart.models.usuario.DetallePedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;

@Mapper(componentModel = "spring")
public interface DetallePedidoMapper {

    @Mapping(target = "subtotal", expression = "java(calcularSubtotal(entity))")
    DetallePedidoDto toDto(DetallePedido entity);

    DetallePedido toEntity(DetallePedidoDto dto);

    default BigDecimal calcularSubtotal(DetallePedido entity) {
        if (entity == null || entity.getCantidad() == null || entity.getPrecioVenta() == null) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(entity.getPrecioVenta().doubleValue())
                .multiply(BigDecimal.valueOf(entity.getCantidad()));
    }
}