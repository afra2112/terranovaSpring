package com.proyecto.terranova.implement;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.terranova.service.ProductoService;
import com.proyecto.terranova.repository.ProductoRepository;
import com.proyecto.terranova.dto.ProductoDTO;
import com.proyecto.terranova.entity.Producto;

@Service
public class ProductoImplement implements ProductoService {

    @Autowired
    private ProductoRepository repository;

    @Override
    public ProductoDTO save(ProductoDTO dto) {
        Producto entity = new Producto();
        // TODO: map DTO to Entity
        entity = repository.save(entity);
        // TODO: map Entity to DTO
        return dto;
    }

    @Override
    public ProductoDTO update(Long id, ProductoDTO dto) {
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
    public ProductoDTO findById(Long id) {
        return repository.findById(id)
            .map(entity -> {
                ProductoDTO dto = new ProductoDTO();
                // TODO: map Entity to DTO
                return dto;
            })
            .orElse(null);
    }

    @Override
    public List<ProductoDTO> findAll() {
        return repository.findAll().stream()
            .map(entity -> {
                ProductoDTO dto = new ProductoDTO();
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
