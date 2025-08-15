package com.proyecto.terranova.service;

import java.util.List;
import com.proyecto.terranova.dto.FavoritoDTO;

public interface FavoritoService {
    FavoritoDTO save(FavoritoDTO dto);
    FavoritoDTO update(Long id, FavoritoDTO dto); // Actualizar
    FavoritoDTO findById(Long id);
    List<FavoritoDTO> findAll();
    boolean delete(Long id);
    boolean existsById(Long id); // ValidaciÃ³n
    long count(); // Contar registros
}
