
package com.sena.skyheart.servicesImpl;

import com.sena.skyheart.dtos.DetalleIngresoDto;
import com.sena.skyheart.mappers.DetalleIngresoMapper;
import com.sena.skyheart.models.usuario.DetalleIngreso;
import com.sena.skyheart.repository.DetalleIngresoRepository;
import com.sena.skyheart.services.DetalleIngresoService;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DetalleIngresoServiceImpl implements DetalleIngresoService {

    private final DetalleIngresoRepository detalleIngresoRepository;
    private final DetalleIngresoMapper detalleIngresoMapper;

    @Override
    public DetalleIngresoDto guardar(DetalleIngresoDto detalleIngresoDto) {
        DetalleIngreso detalleIngreso = detalleIngresoMapper.toEntidad(detalleIngresoDto);
        detalleIngreso.setId(null);

        DetalleIngreso guardado = detalleIngresoRepository.save(detalleIngreso);
        return detalleIngresoMapper.toDto(guardado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DetalleIngresoDto> listarTodos() {
        return detalleIngresoRepository.findAll()
                .stream()
                .map(detalleIngresoMapper::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public DetalleIngresoDto buscarPorId(Long id) {
        DetalleIngreso detalleIngreso = detalleIngresoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Detalle de ingreso no encontrado con ID: " + id));

        return detalleIngresoMapper.toDto(detalleIngreso);
    }

    @Override
    public DetalleIngresoDto actualizar(Long id, DetalleIngresoDto detalleIngresoDto) {
        DetalleIngreso detalleIngreso = detalleIngresoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Detalle de ingreso no encontrado con ID: " + id));

        detalleIngreso.setCantidad(detalleIngresoDto.getCantidad());
        detalleIngreso.setPrecioCompra(detalleIngresoDto.getPrecioCompra());

        DetalleIngreso actualizado = detalleIngresoRepository.save(detalleIngreso);
        return detalleIngresoMapper.toDto(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        DetalleIngreso detalleIngreso = detalleIngresoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Detalle de ingreso no encontrado con ID: " + id));

        detalleIngresoRepository.delete(detalleIngreso);
    }
}
