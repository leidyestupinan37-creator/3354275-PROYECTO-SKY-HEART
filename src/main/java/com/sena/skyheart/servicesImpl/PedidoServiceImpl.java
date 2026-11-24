
package com.sena.skyheart.servicesImpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sena.skyheart.dtos.PedidoDto;
import com.sena.skyheart.models.usuario.Pedido;
import com.sena.skyheart.repository.PedidoRepository;
import com.sena.skyheart.services.PedidoService;

@Service
@Transactional
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PedidoDto> listarTodos() {
        return pedidoRepository.findAll()
                .stream()
                .map(this::convertirDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public PedidoDto buscarPorId(Integer id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Pedido no encontrado: " + id));

        return convertirDto(pedido);
    }

    @Override
    public PedidoDto crear(PedidoDto dto) {
        Pedido pedido = new Pedido();

        pedido.setNumeroPedido(dto.getNumeroPedido());
        pedido.setFechaPedido(dto.getFechaPedido());
        pedido.setEstado(dto.getEstado());
        pedido.setTotal(dto.getTotal());

        Pedido guardado = pedidoRepository.save(pedido);

        return convertirDto(guardado);
    }

    @Override
    public PedidoDto actualizar(Integer id, PedidoDto dto) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Pedido no encontrado: " + id));

        pedido.setNumeroPedido(dto.getNumeroPedido());
        pedido.setFechaPedido(dto.getFechaPedido());
        pedido.setEstado(dto.getEstado());
        pedido.setTotal(dto.getTotal());

        Pedido actualizado = pedidoRepository.save(pedido);

        return convertirDto(actualizado);
    }

    @Override
    public void eliminar(Integer id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Pedido no encontrado: " + id));

        pedidoRepository.delete(pedido);
    }

    @Override
    public BigDecimal calcularTotal(Integer id, BigDecimal montoCalculado) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Pedido no encontrado: " + id));

        pedido.setTotal(montoCalculado);

        Pedido actualizado = pedidoRepository.save(pedido);

        return actualizado.getTotal();
    }

    @Override
    public PedidoDto cambiarEstado(Integer id, String nuevoEstado) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Pedido no encontrado: " + id));

        pedido.setEstado(nuevoEstado);

        Pedido actualizado = pedidoRepository.save(pedido);

        return convertirDto(actualizado);
    }

    private PedidoDto convertirDto(Pedido pedido) {
        PedidoDto dto = new PedidoDto();

        dto.setPedido(pedido.getPedido());
        dto.setNumeroPedido(pedido.getNumeroPedido());
        dto.setFechaPedido(pedido.getFechaPedido());
        dto.setEstado(pedido.getEstado());
        dto.setTotal(pedido.getTotal());

        return dto;
    }
}
