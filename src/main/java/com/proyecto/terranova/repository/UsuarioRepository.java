package com.proyecto.terranova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.terranova.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}
