
package com.sena.skyheart.servicesImpl;

import com.sena.skyheart.dtos.EstadoPedidoDto;
import com.sena.skyheart.mappers.EstadoPedidoMapper;
import com.sena.skyheart.models.usuario.EstadoPedido;
import com.sena.skyheart.repository.EstadoPedidoRepository;
import com.sena.skyheart.services.EstadoPedidoService;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class EstadoPedidoServiceImpl implements EstadoPedidoService {

    private final EstadoPedidoRepository estadoPedidoRepository;
    private final EstadoPedidoMapper estadoPedidoMapper;

    @Override
    public EstadoPedidoDto guardar(EstadoPedidoDto estadoPedidoDto) {
        EstadoPedido estadoPedido = estadoPedidoMapper.toEntidad(estadoPedidoDto);
        estadoPedido.setId(null);

        EstadoPedido guardado = estadoPedidoRepository.save(estadoPedido);
        return estadoPedidoMapper.toDto(guardado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EstadoPedidoDto> listarTodos() {
        return estadoPedidoRepository.findAll()
                .stream()
                .map(estadoPedidoMapper::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public EstadoPedidoDto buscarPorId(Long id) {
        EstadoPedido estadoPedido = estadoPedidoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Estado de pedido no encontrado con ID: " + id));

        return estadoPedidoMapper.toDto(estadoPedido);
    }

    @Override
    public EstadoPedidoDto actualizar(Long id, EstadoPedidoDto estadoPedidoDto) {
        EstadoPedido estadoPedido = estadoPedidoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Estado de pedido no encontrado con ID: " + id));

        estadoPedido.setNombreEstado(estadoPedidoDto.getNombreEstado());

        EstadoPedido actualizado = estadoPedidoRepository.save(estadoPedido);
        return estadoPedidoMapper.toDto(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        EstadoPedido estadoPedido = estadoPedidoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Estado de pedido no encontrado con ID: " + id));

        estadoPedidoRepository.delete(estadoPedido);
    }
}
