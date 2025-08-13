package com.proyecto.terranova.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDTO {

    private String cedula;

    private String nombres;

    private String apellidos;

    private String email;

    private String contrasena;

    private String telefono;

    private LocalDate nacimiento;

    private List<UsuarioRolDTO> usuarioRoles = new ArrayList<>();

    private DisponibilidadDTO disponibilidad;
}
