package com.proyecto.terranova.implement;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.terranova.service.RolService;
import com.proyecto.terranova.repository.RolRepository;
import com.proyecto.terranova.dto.RolDTO;
import com.proyecto.terranova.entity.Rol;

@Service
public class RolImplement implements RolService {

    @Autowired
    private RolRepository repository;

    @Override
    public RolDTO save(RolDTO dto) {
        Rol entity = new Rol();
        // TODO: map DTO to Entity
        entity = repository.save(entity);
        // TODO: map Entity to DTO
        return dto;
    }

    @Override
    public RolDTO update(Long id, RolDTO dto) {
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
    public RolDTO findById(Long id) {
        return repository.findById(id)
            .map(entity -> {
                RolDTO dto = new RolDTO();
                // TODO: map Entity to DTO
                return dto;
            })
            .orElse(null);
    }

    @Override
    public List<RolDTO> findAll() {
        return repository.findAll().stream()
            .map(entity -> {
                RolDTO dto = new RolDTO();
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
