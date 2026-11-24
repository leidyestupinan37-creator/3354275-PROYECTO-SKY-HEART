package com.sena.skyheart.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sena.skyheart.dtos.GeneroDto;
import com.sena.skyheart.mappers.GeneroMapper;
import com.sena.skyheart.models.usuario.Genero;
import com.sena.skyheart.repository.GeneroRepository;
import com.sena.skyheart.services.GeneroService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GeneroServiceImpl implements GeneroService {

    private final GeneroRepository generoRepository;
    private final GeneroMapper generoMapper;

    @Override
    public List<GeneroDto> listarGeneros() {
        return generoRepository.findAll()
                .stream()
                .map(generoMapper::ToDto)
                .toList();
    }

    @Override
    public GeneroDto buscarPorId(Integer id) {
        Genero genero = generoRepository.findById(id)
                .orElseThrow(() ->
                    new EntityNotFoundException(
                        "Género no encontrado con ID: " + id));

        return generoMapper.ToDto(genero);
    }

    @Override
    public GeneroDto crearGenero(GeneroDto generoDto) {
        Genero genero = generoMapper.ToEntidad(generoDto);
        Genero generoGuardado = generoRepository.save(genero);

        return generoMapper.ToDto(generoGuardado);
    }

    @Override
    public GeneroDto actualizarGenero(Integer id, GeneroDto generoDto) {
        Genero generoEncontrado = generoRepository.findById(id)
                .orElseThrow(() ->
                    new EntityNotFoundException(
                        "No se encuentra género con ID: " + id));

        generoEncontrado.setNombre(generoDto.getNombre());
        generoEncontrado.setDescripcion(generoDto.getDescripcion());

        Genero generoActualizado = generoRepository.save(generoEncontrado);

        return generoMapper.ToDto(generoActualizado);
    }

    @Override
    public void eliminarGenero(Integer id) {
        Genero generoEncontrado = generoRepository.findById(id)
                .orElseThrow(() ->
                    new EntityNotFoundException(
                        "No se encuentra género con ID: " + id));

        generoRepository.delete(generoEncontrado);
    }
}