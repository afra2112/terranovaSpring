package com.proyecto.terranova.repository;

import com.proyecto.terranova.dto.UsuarioDTO;
import com.proyecto.terranova.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Usuario buscarPorCedula(String cedula);
}
