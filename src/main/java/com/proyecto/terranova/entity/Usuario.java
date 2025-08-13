package com.proyecto.terranova.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Usuarios")
@Data
public class Usuario {

    @Id
    @Column(length = 10, nullable = false)
    private String cedula;

    @Column(length = 45, nullable = false)
    private String nombres;

    @Column(length = 45, nullable = false)
    private String apellidos;

    @Column(length = 45, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String contrasena;

    @Column(length = 10, nullable = false)
    private String telefono;

    @Column(nullable = false)
    private LocalDate nacimiento;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioRol> usuarioRoles = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "idDisponibilidad", nullable = false)
    private Disponibilidad disponibilidad;
}
