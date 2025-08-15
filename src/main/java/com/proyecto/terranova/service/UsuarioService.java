package com.proyecto.terranova.service;

import java.util.List;
import com.proyecto.terranova.dto.UsuarioDTO;

public interface UsuarioService {
    UsuarioDTO save(UsuarioDTO dto);
    UsuarioDTO update(String id, UsuarioDTO dto); // Actualizar
    UsuarioDTO findById(String id);
    List<UsuarioDTO> findAll();
    boolean delete(String id);
    boolean existsById(String id); // ValidaciÃ³n
    long count(); // Contar registros
}
