package com.sena.skyheart.servicesImpl;

import com.sena.skyheart.dtos.DetallePedidoDto;
import com.sena.skyheart.models.usuario.DetallePedido;
import com.sena.skyheart.repository.DetallePedidoRepository;
import com.sena.skyheart.services.DetallePedidoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {

    private final DetallePedidoRepository detallePedidoRepository;

    public DetallePedidoServiceImpl(DetallePedidoRepository detallePedidoRepository) {
        this.detallePedidoRepository = detallePedidoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DetallePedidoDto> listarTodos() {
        return detallePedidoRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public DetallePedidoDto buscarPorId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID del detalle de pedido no puede ser nulo");
        }
        DetallePedido entity = detallePedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle de pedido no encontrado: " + id));
        return toDto(entity);
    }

    @Override
    @Transactional
    public DetallePedidoDto crear(DetallePedidoDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Los datos del detalle de pedido no pueden ser nulos");
        }
        DetallePedido entity = toEntity(dto);
        entity.setDetallePedido(null);
        DetallePedido guardada = detallePedidoRepository.save(entity);
        return toDto(guardada);
    }

    @Override
    @Transactional
    public DetallePedidoDto actualizar(Integer id, DetallePedidoDto dto) {
        if (id == null) {
            throw new IllegalArgumentException("El ID del detalle de pedido no puede ser nulo");
        }
        DetallePedido existente = detallePedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle de pedido no encontrado: " + id));

        existente.setCantidad(dto.getCantidad());
        existente.setPrecioVenta(dto.getPrecioVenta());

        DetallePedido actualizada = detallePedidoRepository.save(existente);
        return toDto(actualizada);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID del detalle de pedido no puede ser nulo");
        }
        if (!detallePedidoRepository.existsById(id)) {
            throw new RuntimeException("Detalle de pedido no encontrado: " + id);
        }
        detallePedidoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public BigDecimal calcularSubtotal(Integer id) {
        DetallePedido entity = detallePedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle de pedido no encontrado: " + id));
        return calcularSubtotalEntity(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public BigDecimal calcularTotalDetalles() {
        return detallePedidoRepository.findAll().stream()
                .map(this::calcularSubtotalEntity)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // --- Métodos auxiliares ---

    private BigDecimal calcularSubtotalEntity(DetallePedido entity) {
        if (entity.getPrecioVenta() == null || entity.getCantidad() == null) {
            return BigDecimal.ZERO;
        }
        BigDecimal precio = BigDecimal.valueOf(entity.getPrecioVenta().doubleValue());
        BigDecimal cantidad = BigDecimal.valueOf(entity.getCantidad());
        return precio.multiply(cantidad);
    }

    private DetallePedidoDto toDto(DetallePedido entity) {
        DetallePedidoDto dto = new DetallePedidoDto();
        dto.setDetallePedido(entity.getDetallePedido());
        dto.setCantidad(entity.getCantidad());
        dto.setPrecioVenta(entity.getPrecioVenta());
        dto.setSubtotal(calcularSubtotalEntity(entity));
        return dto;
    }

    private DetallePedido toEntity(DetallePedidoDto dto) {
        DetallePedido entity = new DetallePedido();
        entity.setDetallePedido(dto.getDetallePedido());
        entity.setCantidad(dto.getCantidad());
        entity.setPrecioVenta(dto.getPrecioVenta());
        return entity;
    }
}