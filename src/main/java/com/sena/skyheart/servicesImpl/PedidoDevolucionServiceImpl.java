package com.sena.skyheart.servicesImpl;

import com.sena.skyheart.dtos.PedidoDevolucionDto;
import com.sena.skyheart.models.usuario.PedidoDevolucion;
import com.sena.skyheart.repository.PedidoDevolucionRepository;
import com.sena.skyheart.services.PedidoDevolucionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidoDevolucionServiceImpl implements PedidoDevolucionService {

    private final PedidoDevolucionRepository pedidoDevolucionRepository;

    public PedidoDevolucionServiceImpl(PedidoDevolucionRepository pedidoDevolucionRepository) {
        this.pedidoDevolucionRepository = pedidoDevolucionRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PedidoDevolucionDto> listarTodos() {
        return pedidoDevolucionRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public PedidoDevolucionDto buscarPorId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID de pedidoDevolucion no puede ser nulo");
        }
        PedidoDevolucion entity = pedidoDevolucionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PedidoDevolucion no encontrado: " + id));
        return toDto(entity);
    }

    @Override
    @Transactional
    public PedidoDevolucionDto crear(PedidoDevolucionDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Los datos de pedidoDevolucion no pueden ser nulos");
        }
        PedidoDevolucion entity = toEntity(dto);
        entity.setPedidoDevolucion(null);
        PedidoDevolucion guardada = pedidoDevolucionRepository.save(entity);
        return toDto(guardada);
    }

    @Override
    @Transactional
    public PedidoDevolucionDto actualizar(Integer id, PedidoDevolucionDto dto) {
        if (id == null) {
            throw new IllegalArgumentException("El ID de pedidoDevolucion no puede ser nulo");
        }
        PedidoDevolucion existente = pedidoDevolucionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PedidoDevolucion no encontrado: " + id));

        existente.setMotivoDevolucion(dto.getMotivoDevolucion());
        PedidoDevolucion actualizada = pedidoDevolucionRepository.save(existente);
        return toDto(actualizada);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID de pedidoDevolucion no puede ser nulo");
        }
        if (!pedidoDevolucionRepository.existsById(id)) {
            throw new RuntimeException("PedidoDevolucion no encontrado: " + id);
        }
        pedidoDevolucionRepository.deleteById(id);
    }

    @Override
    @Transactional
    public PedidoDevolucionDto procesarDevolucion(Integer id) {
        PedidoDevolucion existente = pedidoDevolucionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PedidoDevolucion no encontrado: " + id));

        if (existente.getMotivoDevolucion() == null || existente.getMotivoDevolucion().isBlank()) {
            existente.setMotivoDevolucion("Devolución procesada");
        }
        PedidoDevolucion procesada = pedidoDevolucionRepository.save(existente);
        return toDto(procesada);
    }

    // --- Métodos auxiliares ---

    private PedidoDevolucionDto toDto(PedidoDevolucion entity) {
        PedidoDevolucionDto dto = new PedidoDevolucionDto();
        dto.setPedidoDevolucion(entity.getPedidoDevolucion());
        dto.setMotivoDevolucion(entity.getMotivoDevolucion());
        return dto;
    }

    private PedidoDevolucion toEntity(PedidoDevolucionDto dto) {
        PedidoDevolucion entity = new PedidoDevolucion();
        entity.setPedidoDevolucion(dto.getPedidoDevolucion());
        entity.setMotivoDevolucion(dto.getMotivoDevolucion());
        return entity;
    }
}