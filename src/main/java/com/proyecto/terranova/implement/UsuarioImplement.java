package com.proyecto.terranova.implement;

import com.proyecto.terranova.config.enums.RolEnum;
import com.proyecto.terranova.entity.Rol;
import com.proyecto.terranova.repository.RolRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean save(UsuarioDTO dto) {
        if(repository.existsByemail(dto.getEmail()) || repository.existsBycedula(dto.getCedula())){
            return false;
        }

        List<Rol> roles = new ArrayList<Rol>();
        for (RolEnum rol : dto.getRoles()){
            roles.add(rolRepository.findBynombreRol(rol));
        }

        Usuario entidadUsuario = modelMapper.map(dto, Usuario.class);

        entidadUsuario.setContrasena(passwordEncoder.encode(dto.getContrasena()));
        entidadUsuario.setRoles(roles);
        repository.save(entidadUsuario);
        return true;
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
    public UsuarioDTO findByEmail(String email) {
        Usuario entidadUsuario = repository.findById(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
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
