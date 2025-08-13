package com.proyecto.terranova.service;

import java.util.List;
import com.proyecto.terranova.dto.UsuarioRolDTO;

public interface UsuarioRolService {
    UsuarioRolDTO save(UsuarioRolDTO dto);
    UsuarioRolDTO update(Long id, UsuarioRolDTO dto); // Actualizar
    UsuarioRolDTO findById(Long id);
    List<UsuarioRolDTO> findAll();
    void delete(Long id);
    boolean existsById(Long id); // ValidaciÃ³n
    long count(); // Contar registros
}
