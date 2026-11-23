package com.sena.skyheart.servicesImpl;

import com.sena.skyheart.dtos.LoginRequestDto;
import com.sena.skyheart.dtos.UsuarioAuthCreateDTO;
import com.sena.skyheart.dtos.UsuarioAuthResponseDto;
import com.sena.skyheart.mappers.UsuarioAuthMapper;
import com.sena.skyheart.models.usuario.Usuario;
import com.sena.skyheart.models.usuario.auth.Rol;
import com.sena.skyheart.models.usuario.auth.UsuarioAuth;
import com.sena.skyheart.models.usuario.auth.UsuarioAuthRol;
import com.sena.skyheart.repository.RolRepository;
import com.sena.skyheart.repository.UsuarioAuthRepository;
import com.sena.skyheart.repository.UsuarioRepository;
import com.sena.skyheart.services.UsuarioAuthService;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioAuthServiceImpl implements UsuarioAuthService {

    private final UsuarioAuthRepository usuarioAuthRepository;
    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final UsuarioAuthMapper usuarioAuthMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UsuarioAuthResponseDto crear(UsuarioAuthCreateDTO dto) {
        String normalizedUser = dto.getUser() != null ? dto.getUser().trim() : "";
        if (normalizedUser.isEmpty()) {
            throw new IllegalArgumentException("El nombre de usuario es obligatorio");
        }

        if (usuarioAuthRepository.existsByUser(normalizedUser)) {
            throw new IllegalArgumentException("El nombre de usuario ya existe: " + normalizedUser);
        }

        if (usuarioAuthRepository.existsByUsuarioId(dto.getUsuarioId())) {
            throw new IllegalArgumentException("El usuario ya tiene credenciales registradas con id: " + dto.getUsuarioId());
        }

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con id: " + dto.getUsuarioId()));

        UsuarioAuth auth = UsuarioAuth.builder()
                .usuario(usuario)
                .user(normalizedUser)
                .pass(passwordEncoder.encode(dto.getPass()))
                .habilitado(dto.getHabilitado() != null ? dto.getHabilitado() : true)
                .intentosFallidos(0)
                .build();

        Set<UsuarioAuthRol> asignaciones = new HashSet<>();
        if (dto.getRoles() != null) {
            LocalDateTime ahora = LocalDateTime.now();
            for (String nombreRol : dto.getRoles()) {
                Rol rol = rolRepository.findByNombre(nombreRol)
                        .orElseThrow(() -> new IllegalArgumentException("Rol no encontrado: " + nombreRol));

                UsuarioAuthRol asignacion = UsuarioAuthRol.builder()
                        .usuarioAuth(auth)
                        .rol(rol)
                        .activo(true)
                        .fechaAsignacion(ahora)
                        .observacion("Asignación inicial al crear cuenta")
                        .build();

                asignaciones.add(asignacion);
            }
        }
        auth.setRoles(asignaciones);

        UsuarioAuth guardado = usuarioAuthRepository.save(auth);
        return usuarioAuthMapper.toResponseDto(guardado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioAuthResponseDto> listarTodos() {
        return usuarioAuthRepository.findAll().stream()
                .map(usuarioAuthMapper::toResponseDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioAuthResponseDto buscarPorId(Long id) {
        UsuarioAuth auth = usuarioAuthRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("UsuarioAuth no encontrado con id: " + id));
        return usuarioAuthMapper.toResponseDto(auth);
    }

    @Override
    @Transactional
    public UsuarioAuthResponseDto login(LoginRequestDto request) {
        String normalizedUser = request.getUser() != null ? request.getUser().trim() : "";
        UsuarioAuth auth = usuarioAuthRepository.findByUser(normalizedUser)
                .orElseThrow(() -> new IllegalArgumentException("Credenciales inválidas"));

        if (!auth.isHabilitado()) {
            throw new IllegalStateException("La cuenta está deshabilitada");
        }

        if (auth.getBloqueadoHasta() != null && auth.getBloqueadoHasta().isAfter(LocalDateTime.now())) {
            throw new IllegalStateException("La cuenta está bloqueada temporalmente hasta: " + auth.getBloqueadoHasta());
        }

        if (!passwordEncoder.matches(request.getPass(), auth.getPass())) {
            int intentos = (auth.getIntentosFallidos() != null ? auth.getIntentosFallidos() : 0) + 1;
            auth.setIntentosFallidos(intentos);
            if (intentos >= 5) {
                auth.setBloqueadoHasta(LocalDateTime.now().plusMinutes(15));
            }
            usuarioAuthRepository.save(auth);
            throw new IllegalArgumentException("Credenciales inválidas");
        }

        auth.setIntentosFallidos(0);
        auth.setBloqueadoHasta(null);
        usuarioAuthRepository.save(auth);

        return usuarioAuthMapper.toResponseDto(auth);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        if (!usuarioAuthRepository.existsById(id)) {
            throw new IllegalArgumentException("UsuarioAuth no encontrado con id: " + id);
        }
        usuarioAuthRepository.deleteById(id);
    }
}