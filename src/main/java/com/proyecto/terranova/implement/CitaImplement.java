package com.proyecto.terranova.implement;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.terranova.service.CitaService;
import com.proyecto.terranova.repository.CitaRepository;
import com.proyecto.terranova.dto.CitaDTO;
import com.proyecto.terranova.entity.Cita;

@Service
public class CitaImplement implements CitaService {

    @Autowired
    private CitaRepository repository;

    @Override
    public CitaDTO save(CitaDTO dto) {
        Cita entity = new Cita();
        // TODO: map DTO to Entity
        entity = repository.save(entity);
        // TODO: map Entity to DTO
        return dto;
    }

    @Override
    public CitaDTO update(Long id, CitaDTO dto) {
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
    public CitaDTO findById(Long id) {
        return repository.findById(id)
            .map(entity -> {
                CitaDTO dto = new CitaDTO();
                // TODO: map Entity to DTO
                return dto;
            })
            .orElse(null);
    }

    @Override
    public List<CitaDTO> findAll() {
        return repository.findAll().stream()
            .map(entity -> {
                CitaDTO dto = new CitaDTO();
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
