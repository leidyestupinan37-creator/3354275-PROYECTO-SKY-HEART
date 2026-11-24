
package com.sena.skyheart.mappers;

import com.sena.skyheart.dtos.EstadoPedidoDto;
import com.sena.skyheart.models.usuario.EstadoPedido;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EstadoPedidoMapper {

    // De EstadoPedido a EstadoPedidoDto
    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombreEstado", target = "nombreEstado")
    EstadoPedidoDto toDto(EstadoPedido estadoPedido);

    // De EstadoPedidoDto a EstadoPedido
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "nombreEstado", target = "nombreEstado")
    EstadoPedido toEntidad(EstadoPedidoDto estadoPedidoDto);
}
