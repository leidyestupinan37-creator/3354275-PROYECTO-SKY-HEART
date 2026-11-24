package com.sena.skyheart.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sena.skyheart.dtos.ProductoDto;
import com.sena.skyheart.models.usuario.Producto;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    @Mapping(source = "categoria.categoria", target = "fkCategoria")
    ProductoDto ConvierteaDto(Producto producto);

    @Mapping(target = "producto", ignore = true)
    @Mapping(target = "categoria", ignore = true)
    Producto ToEntidad(ProductoDto productoDto);

    List<ProductoDto> toDtoList(List<Producto> productos);
}
