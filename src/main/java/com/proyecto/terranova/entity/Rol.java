package com.proyecto.terranova.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;

    @Column(length = 10, nullable = false)
    private String nombreRol;

    @OneToMany(mappedBy = "rol")
    private List<UsuarioRol> usuarioRoles = new ArrayList<>();
}
