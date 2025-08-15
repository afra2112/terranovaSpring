package com.proyecto.terranova.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuario_rol", uniqueConstraints = {@UniqueConstraint(columnNames = {"cedulaUsuario","idRol"})})
@Data
public class UsuarioRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRolUsuario;
}
