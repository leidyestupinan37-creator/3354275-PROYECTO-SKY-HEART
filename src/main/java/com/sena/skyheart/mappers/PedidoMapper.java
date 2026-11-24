package com.sena.skyheart.mappers;

import com.sena.skyheart.dtos.PedidoDto;
import com.sena.skyheart.models.usuario.Pedido;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoMapper {
    PedidoDto toDto(Pedido entity);
    Pedido toEntity(PedidoDto dto);
}