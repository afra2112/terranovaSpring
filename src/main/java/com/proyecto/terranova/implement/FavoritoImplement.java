package com.proyecto.terranova.implement;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.terranova.service.FavoritoService;
import com.proyecto.terranova.repository.FavoritoRepository;
import com.proyecto.terranova.dto.FavoritoDTO;
import com.proyecto.terranova.entity.Favorito;

@Service
public class FavoritoImplement implements FavoritoService {

    @Autowired
    private FavoritoRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FavoritoDTO save(FavoritoDTO dto) {
        Favorito entidadFavorito = modelMapper.map(dto, Favorito.class);
        Favorito entidadGuardada = repository.save(entidadFavorito);
        return modelMapper.map(entidadGuardada, FavoritoDTO.class);
    }

    @Override
    public FavoritoDTO update(Long id, FavoritoDTO dto) {
        Favorito entidadFavorito = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Favorito no encontrado"));

    	modelMapper.map(dto, entidadFavorito);

    	Favorito entidadActualizada = repository.save(entidadFavorito);
    	return modelMapper.map(entidadActualizada, FavoritoDTO.class);
    }

    @Override
    public FavoritoDTO findById(Long id) {
        Favorito entidadFavorito = repository.findById(id).orElseThrow(() -> new RuntimeException("Favorito no encontrado"));
        return modelMapper.map(entidadFavorito, FavoritoDTO.class);
    }

    @Override
    public List<FavoritoDTO> findAll() {
        return repository.findAll().stream()
            .map(entity -> modelMapper.map(entity, FavoritoDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {
        if(!repository.existsById(id)){
               return false;
        }
        repository.deleteById(id);
        return true;
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
