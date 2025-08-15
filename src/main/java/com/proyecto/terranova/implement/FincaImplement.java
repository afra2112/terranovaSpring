package com.proyecto.terranova.implement;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.terranova.service.FincaService;
import com.proyecto.terranova.repository.FincaRepository;
import com.proyecto.terranova.dto.FincaDTO;
import com.proyecto.terranova.entity.Finca;

@Service
public class FincaImplement implements FincaService {

    @Autowired
    private FincaRepository repository;

    @Override
    public FincaDTO save(FincaDTO dto) {
        Finca entity = new Finca();
        // TODO: map DTO to Entity
        entity = repository.save(entity);
        // TODO: map Entity to DTO
        return dto;
    }

    @Override
    public FincaDTO update(Long id, FincaDTO dto) {
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
    public FincaDTO findById(Long id) {
        return repository.findById(id)
            .map(entity -> {
                FincaDTO dto = new FincaDTO();
                // TODO: map Entity to DTO
                return dto;
            })
            .orElse(null);
    }

    @Override
    public List<FincaDTO> findAll() {
        return repository.findAll().stream()
            .map(entity -> {
                FincaDTO dto = new FincaDTO();
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
