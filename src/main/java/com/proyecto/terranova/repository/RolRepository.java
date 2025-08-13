package com.proyecto.terranova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.terranova.entity.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
}
