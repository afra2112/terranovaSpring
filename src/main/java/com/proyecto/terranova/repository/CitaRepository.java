package com.proyecto.terranova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.terranova.entity.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
}
