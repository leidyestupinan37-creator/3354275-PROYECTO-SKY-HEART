
package com.sena.skyheart.servicesImpl;

import com.sena.skyheart.dtos.DomiciliarioDto;
import com.sena.skyheart.dtos.DomiciliarioDtoResponse;
import com.sena.skyheart.mappers.DomiciliarioMapper;
import com.sena.skyheart.models.usuario.Domiciliario;
import com.sena.skyheart.repository.DomiciliarioRepository;
import com.sena.skyheart.services.DomiciliarioService;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DomiciliarioServiceImpl implements DomiciliarioService {

    private final DomiciliarioRepository domiciliarioRepository;
    private final DomiciliarioMapper domiciliarioMapper;

    // Registrar domiciliario
    @Override
    public DomiciliarioDtoResponse guardar(DomiciliarioDto domiciliarioDto) {

        Domiciliario domiciliario = domiciliarioMapper.toEntidad(domiciliarioDto);
        domiciliario.setDomiciliario(null);

        Domiciliario domiciliarioGuardado = domiciliarioRepository.save(domiciliario);

        return domiciliarioMapper.toDto(domiciliarioGuardado);
    }

    // Listar todos los domiciliarios
    @Override
    @Transactional(readOnly = true)
    public List<DomiciliarioDtoResponse> listarTodos() {

        return domiciliarioRepository.findAll()
                .stream()
                .map(domiciliarioMapper::toDto)
                .toList();
    }

    // Buscar por ID
    @Override
    @Transactional(readOnly = true)
    public DomiciliarioDtoResponse buscarPorId(Long id) {

        Domiciliario domiciliario = domiciliarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Domiciliario no encontrado con ID: " + id));

        return domiciliarioMapper.toDto(domiciliario);
    }

    // Actualizar domiciliario
    @Override
    public DomiciliarioDtoResponse actualizar(Long id, DomiciliarioDto domiciliarioDto) {

        Domiciliario domiciliario = domiciliarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Domiciliario no encontrado con ID: " + id));

        domiciliario.setNombre(domiciliarioDto.getNombre());
        domiciliario.setZonaEntrega(domiciliarioDto.getZonaEntrega());
        domiciliario.setTelefono(domiciliarioDto.getTelefono());

        Domiciliario actualizado = domiciliarioRepository.save(domiciliario);

        return domiciliarioMapper.toDto(actualizado);
    }
// Eliminar domiciliario
@Override
public void eliminar(Long id) {

    Domiciliario domiciliario = domiciliarioRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(
                    "Domiciliario no encontrado con ID: " + id));

    domiciliarioRepository.delete(domiciliario);
}
}