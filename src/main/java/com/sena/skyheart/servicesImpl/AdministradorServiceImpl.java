
package com.sena.skyheart.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sena.skyheart.dtos.AdministradorDto;
import com.sena.skyheart.mappers.AdministradorMapper;
import com.sena.skyheart.models.usuario.Administrador;
import com.sena.skyheart.repository.AdministradorRepository;
import com.sena.skyheart.services.AdministradorService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdministradorServiceImpl implements AdministradorService {

    private final AdministradorRepository administradorRepository;
    private final AdministradorMapper administradorMapper;

    // 1. Guardar administrador
    @Override
    public AdministradorDto guardar(AdministradorDto administradorDto) {
        // Convertir DTO a entidad
        Administrador administrador = administradorMapper.toEntidad(administradorDto);

        // El ID debe ir en null para que la BD lo genere/gestione según corresponda
        administrador.setId(null);

        // Guardar en la base de datos
        Administrador administradorGuardado = administradorRepository.save(administrador);

        return administradorMapper.toDto(administradorGuardado);
    }

    // 2. Listar todos los administradores
    @Override
    public List<AdministradorDto> listarTodos() {
        return administradorRepository.findAll()
                .stream()
                .map(administradorMapper::toDto)
                .toList();
    }

    // 3. Consultar administrador por ID
    @Override
    public AdministradorDto buscarPorId(long id) {
        Administrador administrador = administradorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Administrador no encontrado: " + id));

        return administradorMapper.toDto(administrador);
    }

    // 4. Actualizar administrador
    @Override
    public AdministradorDto actualizar(Long id, AdministradorDto administradorDto) {
        Administrador administradorExistente = administradorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encuentra administrador con ID: " + id));

        administradorExistente.setNumIde(administradorDto.getNumIden());
        administradorExistente.setNom(administradorDto.getNomb());
        administradorExistente.setApe(administradorDto.getApell());
        administradorExistente.setCorr(administradorDto.getCorre());
        administradorExistente.setDir(administradorDto.getDirec());
        administradorExistente.setContra(administradorDto.getContras());
        administradorExistente.setFechaNac(administradorDto.getFechaNaci());
        administradorExistente.setTel(administradorDto.getTele());

        Administrador administradorActualizado = administradorRepository.save(administradorExistente);

        return administradorMapper.toDto(administradorActualizado);
    }

    // 5. Eliminar administrador
    @Override
    public void eliminar(Long id) {
        Administrador administradorExistente = administradorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encuentra administrador con ID: " + id));

        administradorRepository.delete(administradorExistente);
    }

    // 6. Guardar administradores por lote
    @Override
    public List<AdministradorDto> guardarTodos(List<AdministradorDto> administradorDtos) {
        List<Administrador> administradores = administradorDtos.stream()
                .map(administradorMapper::toEntidad)
                .peek(admin -> admin.setId(null))
                .toList();

        List<Administrador> administradoresGuardados = administradorRepository.saveAll(administradores);

        return administradoresGuardados.stream()
                .map(administradorMapper::toDto)
                .toList();
    }
}

