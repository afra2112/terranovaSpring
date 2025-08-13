package com.proyecto.terranova.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuario_rol", uniqueConstraints = {@UniqueConstraint(columnNames = {"cedulaUsuario","idRol"})})
@Data
public class UsuarioRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRolUsuario;

    @ManyToOne
    @JoinColumn(name = "cedulaUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idRol", nullable = false)
    private Rol rol;
}
