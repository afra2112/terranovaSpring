package com.proyecto.terranova.implement;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.terranova.service.ComprobanteService;
import com.proyecto.terranova.repository.ComprobanteRepository;
import com.proyecto.terranova.dto.ComprobanteDTO;
import com.proyecto.terranova.entity.Comprobante;

@Service
public class ComprobanteImplement implements ComprobanteService {

    @Autowired
    private ComprobanteRepository repository;

    @Override
    public ComprobanteDTO save(ComprobanteDTO dto) {
        Comprobante entity = new Comprobante();
        // TODO: map DTO to Entity
        entity = repository.save(entity);
        // TODO: map Entity to DTO
        return dto;
    }

    @Override
    public ComprobanteDTO update(Long id, ComprobanteDTO dto) {
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
    public ComprobanteDTO findById(Long id) {
        return repository.findById(id)
            .map(entity -> {
                ComprobanteDTO dto = new ComprobanteDTO();
                // TODO: map Entity to DTO
                return dto;
            })
            .orElse(null);
    }

    @Override
    public List<ComprobanteDTO> findAll() {
        return repository.findAll().stream()
            .map(entity -> {
                ComprobanteDTO dto = new ComprobanteDTO();
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
