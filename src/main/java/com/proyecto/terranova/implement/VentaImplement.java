package com.proyecto.terranova.implement;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.terranova.service.VentaService;
import com.proyecto.terranova.repository.VentaRepository;
import com.proyecto.terranova.dto.VentaDTO;
import com.proyecto.terranova.entity.Venta;

@Service
public class VentaImplement implements VentaService {

    @Autowired
    private VentaRepository repository;

    @Override
    public VentaDTO save(VentaDTO dto) {
        Venta entity = new Venta();
        // TODO: map DTO to Entity
        entity = repository.save(entity);
        // TODO: map Entity to DTO
        return dto;
    }

    @Override
    public VentaDTO update(Long id, VentaDTO dto) {
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
    public VentaDTO findById(Long id) {
        return repository.findById(id)
            .map(entity -> {
                VentaDTO dto = new VentaDTO();
                // TODO: map Entity to DTO
                return dto;
            })
            .orElse(null);
    }

    @Override
    public List<VentaDTO> findAll() {
        return repository.findAll().stream()
            .map(entity -> {
                VentaDTO dto = new VentaDTO();
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
