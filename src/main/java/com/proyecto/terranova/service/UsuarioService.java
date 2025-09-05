package com.proyecto.terranova.service;

import java.util.List;
import com.proyecto.terranova.dto.UsuarioDTO;

public interface UsuarioService {
    void save(UsuarioDTO dto);
    UsuarioDTO update(String id, UsuarioDTO dto);
    UsuarioDTO findById(String id);
    UsuarioDTO findByEmail(String email);
    List<UsuarioDTO> findAll();
    boolean delete(String id);
    boolean existsById(String id);
    long count();
}
