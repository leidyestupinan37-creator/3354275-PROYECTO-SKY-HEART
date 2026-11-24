package com.sena.skyheart.servicesImpl;

import com.sena.skyheart.dtos.DevolucionesDto;
import com.sena.skyheart.models.usuario.Devoluciones;
import com.sena.skyheart.repository.DevolucionesRepository;
import com.sena.skyheart.services.DevolucionesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DevolucionesServiceImpl implements DevolucionesService {

    private final DevolucionesRepository devolucionesRepository;

    public DevolucionesServiceImpl(DevolucionesRepository devolucionesRepository) {
        this.devolucionesRepository = devolucionesRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DevolucionesDto> listarTodas() {
        return devolucionesRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public DevolucionesDto buscarPorId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID de la devolución no puede ser nulo");
        }
        Devoluciones devolucion = devolucionesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Devolución no encontrada: " + id));
        return toDto(devolucion);
    }

    @Override
    @Transactional
    public DevolucionesDto crear(DevolucionesDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Los datos de la devolución no pueden ser nulos");
        }
        Devoluciones entity = toEntity(dto);
        entity.setDevoluciones(null);
        if (entity.getFechaSolicitud() == null) {
            entity.setFechaSolicitud(LocalDate.now());
        }
        if (entity.getFechaRegistro() == null) {
            entity.setFechaRegistro(LocalDateTime.now());
        }
        if (entity.getEstado() == null || entity.getEstado().isBlank()) {
            entity.setEstado("PENDIENTE");
        }
        if (entity.getReembolsoAutorizado() == null) {
            entity.setReembolsoAutorizado(false);
        }
        Devoluciones guardada = devolucionesRepository.save(entity);
        return toDto(guardada);
    }

    @Override
    @Transactional
    public DevolucionesDto actualizar(Integer id, DevolucionesDto dto) {
        if (id == null) {
            throw new IllegalArgumentException("El ID de la devolución no puede ser nulo");
        }
        Devoluciones existente = devolucionesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Devolución no encontrada: " + id));

        existente.setMetodoReembolso(dto.getMetodoReembolso());
        if (dto.getFechaSolicitud() != null) {
            existente.setFechaSolicitud(dto.getFechaSolicitud());
        }
        if (dto.getEstado() != null) {
            existente.setEstado(dto.getEstado());
        }
        if (dto.getFechaRegistro() != null) {
            existente.setFechaRegistro(dto.getFechaRegistro());
        }
        existente.setMontoReembolso(dto.getMontoReembolso());
        existente.setMotivo(dto.getMotivo());
        if (dto.getReembolsoAutorizado() != null) {
            existente.setReembolsoAutorizado(dto.getReembolsoAutorizado());
        }

        Devoluciones actualizada = devolucionesRepository.save(existente);
        return toDto(actualizada);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID de la devolución no puede ser nulo");
        }
        if (!devolucionesRepository.existsById(id)) {
            throw new RuntimeException("Devolución no encontrada: " + id);
        }
        devolucionesRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean validarMotivo(Integer devolucionesId) {
        Devoluciones devolucion = devolucionesRepository.findById(devolucionesId)
                .orElseThrow(() -> new RuntimeException("Devolución no encontrada: " + devolucionesId));
        return devolucion.getMotivo() != null && !devolucion.getMotivo().trim().isEmpty();
    }

    @Override
    @Transactional
    public DevolucionesDto autorizarReembolso(Integer devolucionesId) {
        Devoluciones devolucion = devolucionesRepository.findById(devolucionesId)
                .orElseThrow(() -> new RuntimeException("Devolución no encontrada: " + devolucionesId));
        devolucion.setReembolsoAutorizado(true);
        devolucion.setEstado("APROBADA");
        Devoluciones guardada = devolucionesRepository.save(devolucion);
        return toDto(guardada);
    }

    // --- Métodos auxiliares de mapeo ---

    private DevolucionesDto toDto(Devoluciones entity) {
        DevolucionesDto dto = new DevolucionesDto();
        dto.setDevoluciones(entity.getDevoluciones());
        dto.setMetodoReembolso(entity.getMetodoReembolso());
        dto.setFechaSolicitud(entity.getFechaSolicitud());
        dto.setEstado(entity.getEstado());
        dto.setFechaRegistro(entity.getFechaRegistro());
        dto.setMontoReembolso(entity.getMontoReembolso());
        dto.setMotivo(entity.getMotivo());
        dto.setReembolsoAutorizado(entity.getReembolsoAutorizado());
        return dto;
    }

    private Devoluciones toEntity(DevolucionesDto dto) {
        Devoluciones entity = new Devoluciones();
        entity.setDevoluciones(dto.getDevoluciones());
        entity.setMetodoReembolso(dto.getMetodoReembolso());
        entity.setFechaSolicitud(dto.getFechaSolicitud());
        entity.setEstado(dto.getEstado());
        entity.setFechaRegistro(dto.getFechaRegistro());
        entity.setMontoReembolso(dto.getMontoReembolso());
        entity.setMotivo(dto.getMotivo());
        entity.setReembolsoAutorizado(dto.getReembolsoAutorizado());
        return entity;
    }
}