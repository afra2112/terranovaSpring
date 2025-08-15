package com.proyecto.terranova.implement;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.terranova.service.DisponibilidadService;
import com.proyecto.terranova.repository.DisponibilidadRepository;
import com.proyecto.terranova.dto.DisponibilidadDTO;
import com.proyecto.terranova.entity.Disponibilidad;

@Service
public class DisponibilidadImplement implements DisponibilidadService {

    @Autowired
    private DisponibilidadRepository repository;

    @Override
    public DisponibilidadDTO save(DisponibilidadDTO dto) {
        Disponibilidad entity = new Disponibilidad();
        // TODO: map DTO to Entity
        entity = repository.save(entity);
        // TODO: map Entity to DTO
        return dto;
    }

    @Override
    public DisponibilidadDTO update(Long id, DisponibilidadDTO dto) {
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
    public DisponibilidadDTO findById(Long id) {
        return repository.findById(id)
            .map(entity -> {
                DisponibilidadDTO dto = new DisponibilidadDTO();
                // TODO: map Entity to DTO
                return dto;
            })
            .orElse(null);
    }

    @Override
    public List<DisponibilidadDTO> findAll() {
        return repository.findAll().stream()
            .map(entity -> {
                DisponibilidadDTO dto = new DisponibilidadDTO();
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
