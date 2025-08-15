package com.proyecto.terranova.implement;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.terranova.service.ImagenService;
import com.proyecto.terranova.repository.ImagenRepository;
import com.proyecto.terranova.dto.ImagenDTO;
import com.proyecto.terranova.entity.Imagen;

@Service
public class ImagenImplement implements ImagenService {

    @Autowired
    private ImagenRepository repository;

    @Override
    public ImagenDTO save(ImagenDTO dto) {
        Imagen entity = new Imagen();
        // TODO: map DTO to Entity
        entity = repository.save(entity);
        // TODO: map Entity to DTO
        return dto;
    }

    @Override
    public ImagenDTO update(Long id, ImagenDTO dto) {
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
    public ImagenDTO findById(Long id) {
        return repository.findById(id)
            .map(entity -> {
                ImagenDTO dto = new ImagenDTO();
                // TODO: map Entity to DTO
                return dto;
            })
            .orElse(null);
    }

    @Override
    public List<ImagenDTO> findAll() {
        return repository.findAll().stream()
            .map(entity -> {
                ImagenDTO dto = new ImagenDTO();
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
