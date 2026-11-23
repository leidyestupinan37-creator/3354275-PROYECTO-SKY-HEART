package com.sena.skyheart.servicesImpl;

import com.sena.skyheart.dtos.UsuarioDto;
import com.sena.skyheart.mappers.UsuarioMapper;
import com.sena.skyheart.models.usuario.Usuario;
import com.sena.skyheart.repository.UsuarioRepository;
import com.sena.skyheart.services.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    @Transactional
    public UsuarioDto guardar(UsuarioDto usuarioDto) {
        Usuario usuario = usuarioMapper.ConvierteaEntidad(usuarioDto);
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return usuarioMapper.ConvierteaDto(usuarioGuardado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDto> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::ConvierteaDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioDto buscarPorId(long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado: " + id));
        return usuarioMapper.ConvierteaDto(usuario);
    }

    @Override
    @Transactional
    public UsuarioDto actualizar(Long id, UsuarioDto usuarioDto) {
        Usuario usuarioEncontrado = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encuentra usuario con ID: " + id));

        usuarioEncontrado.setNumIde(usuarioDto.getNumIde());
        usuarioEncontrado.setNom(usuarioDto.getNom());
        usuarioEncontrado.setApe(usuarioDto.getApe());
        usuarioEncontrado.setCorr(usuarioDto.getCorr());
        usuarioEncontrado.setDir(usuarioDto.getDir());
        usuarioEncontrado.setFechaNac(usuarioDto.getFechaNac());
        usuarioEncontrado.setTel(usuarioDto.getTel());

        Usuario usuarioActualizado = usuarioRepository.save(usuarioEncontrado);
        return usuarioMapper.ConvierteaDto(usuarioActualizado);
    }

    @Override
    @Transactional
    public UsuarioDto eliminar(Long id) {
        Usuario usuarioEncontrado = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encuentra usuario con ID: " + id));

        UsuarioDto respuesta = usuarioMapper.ConvierteaDto(usuarioEncontrado);
        usuarioRepository.delete(usuarioEncontrado);
        return respuesta;
    }

    @Override
    @Transactional
    public List<UsuarioDto> guardarTodos(List<UsuarioDto> usuarioDtos) {
        List<Usuario> usuarios = usuarioDtos.stream()
                .map(usuarioMapper::ConvierteaEntidad)
                .toList();

        List<Usuario> usuariosGuardados = usuarioRepository.saveAll(usuarios);

        return usuariosGuardados.stream()
                .map(usuarioMapper::ConvierteaDto)
                .toList();
    }
}