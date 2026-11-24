package com.sena.skyheart.mappers;

import com.sena.skyheart.dtos.UsuarioAuthResponseDto;
import com.sena.skyheart.models.usuario.auth.UsuarioAuth;
import com.sena.skyheart.models.usuario.auth.UsuarioAuthRol;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioAuthMapper {

    @Mapping(source = "usuario.id", target = "usuarioId")
    @Mapping(source = "usuario.corr", target = "correoUsuario")
    @Mapping(target = "roles", expression = "java(mapRoles(entity.getRoles()))")
    UsuarioAuthResponseDto toResponseDto(UsuarioAuth entity);

    default Set<String> mapRoles(Set<UsuarioAuthRol> roles) {
        if (roles == null || roles.isEmpty()) {
            return Collections.emptySet();
        }
        return roles.stream()
                .filter(UsuarioAuthRol::isActivo)
                .map(uar -> uar.getRol().getNombre())
                .collect(Collectors.toSet());
    }
}