package com.proyecto.terranova.implement;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.terranova.service.UsuarioService;
import com.proyecto.terranova.repository.UsuarioRepository;
import com.proyecto.terranova.dto.UsuarioDTO;
import com.proyecto.terranova.entity.Usuario;

@Service
public class UsuarioImplement implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UsuarioDTO save(UsuarioDTO dto) {
        Usuario entity = new Usuario();
        // TODO: map DTO to Entity
        entity = repository.save(entity);
        // TODO: map Entity to DTO
        return dto;
    }

    @Override
    public UsuarioDTO update(Long id, UsuarioDTO dto) {
        return repository.findById(id)
            .map(entity -> {
                // TODO: actualizar campos desde DTO a entity
                entity = repository.save(entity);
                // TODO: map Entity to DTO
                return dto;
            })
            .orElse(null);
    }

    @Override
    public UsuarioDTO findById(Long id) {
        return repository.findById(id)
            .map(entity -> {
                UsuarioDTO dto = new UsuarioDTO();
                // TODO: map Entity to DTO
                return dto;
            })
            .orElse(null);
    }

    @Override
    public List<UsuarioDTO> findAll() {
        return repository.findAll().stream()
            .map(entity -> {
                UsuarioDTO dto = new UsuarioDTO();
                // TODO: map Entity to DTO
                return dto;
            })
            .collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {
        if(!repository.existsById(id)){
               return false;
        }
        repository.deleteById(id);
        return true;
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public long count() {
        return repository.count();
    }
}
