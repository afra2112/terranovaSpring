package com.proyecto.terranova.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "roles")
@Data
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    @Column(length = 10, nullable = false)
    private String nombreRol;

    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarioSet;
}
