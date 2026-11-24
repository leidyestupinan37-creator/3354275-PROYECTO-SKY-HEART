package com.sena.skyheart.services;

import com.sena.skyheart.dtos.DevolucionesDto;
import java.util.List;

public interface DevolucionesService {

    List<DevolucionesDto> listarTodas();

    DevolucionesDto buscarPorId(Integer id);

    DevolucionesDto crear(DevolucionesDto dto);

    DevolucionesDto actualizar(Integer id, DevolucionesDto dto);

    void eliminar(Integer id);

    boolean validarMotivo(Integer devolucionesId);

    DevolucionesDto autorizarReembolso(Integer devolucionesId);
}