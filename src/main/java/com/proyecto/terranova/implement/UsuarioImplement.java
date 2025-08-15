package com.proyecto.terranova.implement;

import com.proyecto.terranova.entity.Rol;
import com.proyecto.terranova.repository.RolRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.terranova.service.UsuarioService;
import com.proyecto.terranova.repository.UsuarioRepository;
import com.proyecto.terranova.dto.UsuarioDTO;
import com.proyecto.terranova.entity.Usuario;

@Service
public class UsuarioImplement implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UsuarioDTO save(UsuarioDTO dto) {
        Usuario entidadUsuario = modelMapper.map(dto, Usuario.class);

        if (dto.getIdRoles() != null && !dto.getIdRoles().isEmpty()) {
            List<Rol> roles = rolRepository.findAllById(dto.getIdRoles());
            entidadUsuario.setRoles(roles);
        }

        Usuario entidadGuardada = repository.save(entidadUsuario);
        return modelMapper.map(entidadGuardada, UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO update(String cedula, UsuarioDTO dto) {
        Usuario entidadUsuario = repository.findById(cedula)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    	modelMapper.map(dto, entidadUsuario);

    	Usuario entidadActualizada = repository.save(entidadUsuario);
    	return modelMapper.map(entidadActualizada, UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO findById(String cedula) {
        Usuario entidadUsuario = repository.findById(cedula).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return modelMapper.map(entidadUsuario, UsuarioDTO.class);
    }

    @Override
    public List<UsuarioDTO> findAll() {
        return repository.findAll().stream()
            .map(entity -> modelMapper.map(entity, UsuarioDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public boolean delete(String cedula) {
        if(!repository.existsById(cedula)){
               return false;
        }
        repository.deleteById(cedula);
        return true;
    }

    @Override
    public boolean existsById(String cedula) {
        return repository.existsById(cedula);
    }

    @Override
    public long count() {
        return repository.count();
    }
}
