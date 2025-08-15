package com.proyecto.terranova.implement;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.terranova.service.NotificacionService;
import com.proyecto.terranova.repository.NotificacionRepository;
import com.proyecto.terranova.dto.NotificacionDTO;
import com.proyecto.terranova.entity.Notificacion;

@Service
public class NotificacionImplement implements NotificacionService {

    @Autowired
    private NotificacionRepository repository;

    @Override
    public NotificacionDTO save(NotificacionDTO dto) {
        Notificacion entity = new Notificacion();
        // TODO: map DTO to Entity
        entity = repository.save(entity);
        // TODO: map Entity to DTO
        return dto;
    }

    @Override
    public NotificacionDTO update(Long id, NotificacionDTO dto) {
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
    public NotificacionDTO findById(Long id) {
        return repository.findById(id)
            .map(entity -> {
                NotificacionDTO dto = new NotificacionDTO();
                // TODO: map Entity to DTO
                return dto;
            })
            .orElse(null);
    }

    @Override
    public List<NotificacionDTO> findAll() {
        return repository.findAll().stream()
            .map(entity -> {
                NotificacionDTO dto = new NotificacionDTO();
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
