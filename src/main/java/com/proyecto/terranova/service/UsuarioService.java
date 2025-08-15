package com.proyecto.terranova.service;

import java.util.List;
import com.proyecto.terranova.dto.UsuarioDTO;

public interface UsuarioService {
    UsuarioDTO save(UsuarioDTO dto);
    UsuarioDTO update(Long id, UsuarioDTO dto); // Actualizar
    UsuarioDTO findById(Long id);
    List<UsuarioDTO> findAll();
    boolean delete(Long id);
    boolean existsById(Long id); // ValidaciÃ³n
    long count(); // Contar registros
}
