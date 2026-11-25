
package com.sena.skyheart.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sena.skyheart.dtos.CiudadDto;
import com.sena.skyheart.mappers.CiudadMapper;
import com.sena.skyheart.models.usuario.Ciudad;
import com.sena.skyheart.models.usuario.Departamento;
import com.sena.skyheart.repository.CiudadRepository;
import com.sena.skyheart.repository.DepartamentoRepository;
import com.sena.skyheart.services.CiudadService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CiudadServiceImpl implements CiudadService {

    private final CiudadRepository ciudadRepository;
    private final DepartamentoRepository departamentoRepository;
    private final CiudadMapper ciudadMapper;

    // Registrar una ciudad
    @Override
    public CiudadDto guardar(CiudadDto ciudadDto) {

        Departamento departamento = departamentoRepository.findById(
                ciudadDto.getDepartamentoCodigo())
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado"));

        Ciudad ciudad = ciudadMapper.toEntidad(ciudadDto);

        ciudad.setDepartamento(departamento);

        ciudad = ciudadRepository.save(ciudad);

        return ciudadMapper.toDto(ciudad);
    }

    // Listar todas las ciudades
    @Override
    public List<CiudadDto> listarTodos() {

        return ciudadRepository.findAll()
                .stream()
                .map(ciudadMapper::toDto)
                .toList();
    }

    // Buscar ciudad por código
    @Override
    public CiudadDto buscarPorId(String codigo) {

        Ciudad ciudad = ciudadRepository.findById(codigo)
                .orElseThrow(() -> new RuntimeException("Ciudad no encontrada"));

        return ciudadMapper.toDto(ciudad);
    }

    // Actualizar ciudad
    @Override
    public CiudadDto actualizar(String codigo, CiudadDto ciudadDto) {

        Ciudad ciudad = ciudadRepository.findById(codigo)
                .orElseThrow(() -> new RuntimeException("Ciudad no encontrada"));

        Departamento departamento = departamentoRepository.findById(
                ciudadDto.getDepartamentoCodigo())
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado"));

        ciudad.setNomb(ciudadDto.getNomb());
        ciudad.setDepartamento(departamento);

        ciudad = ciudadRepository.save(ciudad);

        return ciudadMapper.toDto(ciudad);
    }

    // Eliminar ciudad
    @Override
    public void eliminar(String codigo) {

        Ciudad ciudad = ciudadRepository.findById(codigo)
                .orElseThrow(() -> new RuntimeException("Ciudad no encontrada"));

        ciudadRepository.delete(ciudad);
    }
}
