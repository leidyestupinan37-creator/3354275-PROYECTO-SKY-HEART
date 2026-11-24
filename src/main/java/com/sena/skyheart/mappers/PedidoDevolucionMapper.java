package com.sena.skyheart.mappers;

import com.sena.skyheart.dtos.PedidoDevolucionDto;
import com.sena.skyheart.models.usuario.PedidoDevolucion;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoDevolucionMapper {
    PedidoDevolucionDto toDto(PedidoDevolucion entity);
    PedidoDevolucion toEntity(PedidoDevolucionDto dto);
}