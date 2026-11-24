
package com.sena.skyheart.servicesImpl;

import com.sena.skyheart.dtos.IngresoDto;
import com.sena.skyheart.mappers.IngresoMapper;
import com.sena.skyheart.models.usuario.Ingreso;
import com.sena.skyheart.repository.IngresoRepository;
import com.sena.skyheart.services.IngresoService;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class IngresoServiceImpl implements IngresoService {

    private final IngresoRepository ingresoRepository;
    private final IngresoMapper ingresoMapper;

    @Override
    public IngresoDto guardar(IngresoDto ingresoDto) {
        Ingreso ingreso = ingresoMapper.toEntidad(ingresoDto);
        ingreso.setNumero(null);

        Ingreso guardado = ingresoRepository.save(ingreso);
        return ingresoMapper.toDto(guardado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<IngresoDto> listarTodos() {
        return ingresoRepository.findAll()
                .stream()
                .map(ingresoMapper::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public IngresoDto buscarPorId(Long id) {
        Ingreso ingreso = ingresoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Ingreso no encontrado con número: " + id));

        return ingresoMapper.toDto(ingreso);
    }

    @Override
    public IngresoDto actualizar(Long id, IngresoDto ingresoDto) {
        Ingreso ingreso = ingresoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Ingreso no encontrado con número: " + id));

        ingreso.setFecha(ingresoDto.getFecha());
        ingreso.setUsuario(ingresoDto.getUsuario());
        ingreso.setNombreProducto(ingresoDto.getNombreProducto());
        ingreso.setFactura(ingresoDto.getFactura());

        Ingreso actualizado = ingresoRepository.save(ingreso);
        return ingresoMapper.toDto(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        Ingreso ingreso = ingresoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Ingreso no encontrado con número: " + id));

        ingresoRepository.delete(ingreso);
    }
}
