package com.sena.skyheart.servicesImpl;

import com.sena.skyheart.dtos.ClienteDto;
import com.sena.skyheart.dtos.ClienteDtoResponse;
import com.sena.skyheart.mappers.ClienteMapper;
import com.sena.skyheart.models.usuario.Cliente;
import com.sena.skyheart.models.usuario.TiposCliente;
import com.sena.skyheart.repository.ClienteRepository;
import com.sena.skyheart.repository.TipoClienteRepository;
import com.sena.skyheart.services.ClienteService;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;
    private final TipoClienteRepository tipoClienteRepository;

    // Registrar cliente
    @Override
    public ClienteDtoResponse guardar(ClienteDto clienteDto) {

        TiposCliente tipo = tipoClienteRepository.findById(clienteDto.getTipoClienteId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Tipo de cliente no encontrado"));

        Cliente cliente = clienteMapper.toEntidad(clienteDto);
        cliente.setId(null);
        cliente.setTipoCliente(tipo);

        Cliente clienteGuardado = clienteRepository.save(cliente);

        return clienteMapper.toDto(clienteGuardado);
    }

    // Listar todos los clientes
    @Override
    @Transactional(readOnly = true)
    public List<ClienteDtoResponse> listarTodos() {

        return clienteRepository.findAll()
                .stream()
                .map(clienteMapper::toDto)
                .toList();
    }

    // Buscar por ID
    @Override
    @Transactional(readOnly = true)
    public ClienteDtoResponse buscarPorId(Long id) {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Cliente no encontrado con ID: " + id));

        return clienteMapper.toDto(cliente);
    }

    // Actualizar cliente
    @Override
    public ClienteDtoResponse actualizar(Long id, ClienteDto clienteDto) {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Cliente no encontrado con ID: " + id));

        TiposCliente tipo = tipoClienteRepository.findById(clienteDto.getTipoClienteId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Tipo de cliente no encontrado"));

        cliente.setTipoCliente(tipo);

        Cliente actualizado = clienteRepository.save(cliente);

        return clienteMapper.toDto(actualizado);
    }

    // Eliminar cliente
    @Override
    public void eliminar(Long id) {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Cliente no encontrado con ID: " + id));

        clienteRepository.delete(cliente);
    }
}