
package com.sena.skyheart.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sena.skyheart.dtos.DepartamentoDto;
import com.sena.skyheart.mappers.DepartamentoMapper;
import com.sena.skyheart.models.usuario.Departamento;
import com.sena.skyheart.repository.DepartamentoRepository;
import com.sena.skyheart.services.DepartamentoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartamentoServiceImpl implements DepartamentoService {

    private final DepartamentoRepository departamentoRepository;
    private final DepartamentoMapper departamentoMapper;

    // Registrar un nuevo departamento
    @Override
    public DepartamentoDto guardar(DepartamentoDto departamentoDto) {

        Departamento departamento = departamentoMapper.toEntidad(departamentoDto);

        departamento = departamentoRepository.save(departamento);

        return departamentoMapper.toDto(departamento);
    }

    // Listar todos los departamentos
    @Override
    public List<DepartamentoDto> listarTodos() {

        return departamentoRepository.findAll()
                .stream()
                .map(departamentoMapper::toDto)
                .toList();
    }

    // Consultar departamento por código
    @Override
    public DepartamentoDto buscarPorId(String codigo) {

        Departamento departamento = departamentoRepository.findById(codigo)
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado"));

        return departamentoMapper.toDto(departamento);
    }

    // Actualizar departamento
    @Override
    public DepartamentoDto actualizar(String codigo, DepartamentoDto departamentoDto) {

        Departamento departamento = departamentoRepository.findById(codigo)
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado"));

        departamento.setNombre(departamentoDto.getNombre());

        departamento = departamentoRepository.save(departamento);

        return departamentoMapper.toDto(departamento);
    }

    // Eliminar departamento
    @Override
    public void eliminar(String codigo) {

        Departamento departamento = departamentoRepository.findById(codigo)
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado"));

        departamentoRepository.delete(departamento);
    }
}
