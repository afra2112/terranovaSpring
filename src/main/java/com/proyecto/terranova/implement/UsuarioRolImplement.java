package com.proyecto.terranova.implement;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.terranova.service.UsuarioRolService;
import com.proyecto.terranova.repository.UsuarioRolRepository;
import com.proyecto.terranova.dto.UsuarioRolDTO;
import com.proyecto.terranova.entity.UsuarioRol;

@Service
public class UsuarioRolImplement implements UsuarioRolService {

    @Autowired
    private UsuarioRolRepository repository;

    @Override
    public UsuarioRolDTO save(UsuarioRolDTO dto) {
        UsuarioRol entity = new UsuarioRol();
        // TODO: map DTO to Entity
        entity = repository.save(entity);
        // TODO: map Entity to DTO
        return dto;
    }

    @Override
    public UsuarioRolDTO update(Long id, UsuarioRolDTO dto) {
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
    public UsuarioRolDTO findById(Long id) {
        return repository.findById(id)
            .map(entity -> {
                UsuarioRolDTO dto = new UsuarioRolDTO();
                // TODO: map Entity to DTO
                return dto;
            })
            .orElse(null);
    }

    @Override
    public List<UsuarioRolDTO> findAll() {
        return repository.findAll().stream()
            .map(entity -> {
                UsuarioRolDTO dto = new UsuarioRolDTO();
                // TODO: map Entity to DTO
                return dto;
            })
            .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
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
