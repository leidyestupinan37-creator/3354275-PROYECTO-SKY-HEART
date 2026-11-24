package com.sena.skyheart.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sena.skyheart.dtos.RolDto;
import com.sena.skyheart.mappers.RolMapper;
import com.sena.skyheart.models.usuario.Rol;
import com.sena.skyheart.repository.RolRepository;
import com.sena.skyheart.services.RolService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;
    private final RolMapper rolMapper;

    @Override
    public List<RolDto> listarRoles() {
        return rolRepository.findAll()
                .stream()
                .map(rolMapper::ToDto)
                .toList();
    }

    @Override
    public RolDto buscarPorId(Integer id) {
        Rol rol = rolRepository.findById(id)
                .orElseThrow(() ->
                    new EntityNotFoundException(
                        "Rol no encontrado con ID: " + id));

        return rolMapper.ToDto(rol);
    }

    @Override
    public RolDto crearRol(RolDto rolDto) {
        Rol rol = rolMapper.ToEntidad(rolDto);
        Rol rolGuardado = rolRepository.save(rol);

        return rolMapper.ToDto(rolGuardado);
    }

    @Override
    public RolDto actualizarRol(Integer id, RolDto rolDto) {
        Rol rolEncontrado = rolRepository.findById(id)
                .orElseThrow(() ->
                    new EntityNotFoundException(
                        "No se encuentra rol con ID: " + id));

        rolEncontrado.setNombre(rolDto.getNombre());
        rolEncontrado.setDescripcion(rolDto.getDescripcion());

        Rol rolActualizado = rolRepository.save(rolEncontrado);

        return rolMapper.ToDto(rolActualizado);
    }

    @Override
    public void eliminarRol(Integer id) {
        Rol rolEncontrado = rolRepository.findById(id)
                .orElseThrow(() ->
                    new EntityNotFoundException(
                        "No se encuentra rol con ID: " + id));

        rolRepository.delete(rolEncontrado);
    }
}