
package com.sena.skyheart.servicesImpl;

import com.sena.skyheart.dtos.MetodoPagoDto;
import com.sena.skyheart.mappers.MetodoPagoMapper;
import com.sena.skyheart.models.usuario.MetodoPago;
import com.sena.skyheart.repository.MetodoPagoRepository;
import com.sena.skyheart.services.MetodoPagoService;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MetodoPagoServiceImpl implements MetodoPagoService {

    private final MetodoPagoRepository metodoPagoRepository;
    private final MetodoPagoMapper metodoPagoMapper;

    @Override
    public MetodoPagoDto guardar(MetodoPagoDto metodoPagoDto) {
        MetodoPago metodoPago = metodoPagoMapper.toEntidad(metodoPagoDto);
        metodoPago.setId(null);

        MetodoPago guardado = metodoPagoRepository.save(metodoPago);
        return metodoPagoMapper.toDto(guardado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MetodoPagoDto> listarTodos() {
        return metodoPagoRepository.findAll()
                .stream()
                .map(metodoPagoMapper::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public MetodoPagoDto buscarPorId(Long id) {
        MetodoPago metodoPago = metodoPagoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Método de pago no encontrado con ID: " + id));

        return metodoPagoMapper.toDto(metodoPago);
    }

    @Override
    public MetodoPagoDto actualizar(Long id, MetodoPagoDto metodoPagoDto) {
        MetodoPago metodoPago = metodoPagoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Método de pago no encontrado con ID: " + id));

        metodoPago.setNombreMetodoPago(metodoPagoDto.getNombreMetodoPago());

        MetodoPago actualizado = metodoPagoRepository.save(metodoPago);
        return metodoPagoMapper.toDto(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        MetodoPago metodoPago = metodoPagoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Método de pago no encontrado con ID: " + id));

        metodoPagoRepository.delete(metodoPago);
    }
}
