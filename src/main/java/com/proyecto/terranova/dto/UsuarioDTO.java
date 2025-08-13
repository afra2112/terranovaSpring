package com.proyecto.terranova.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UsuarioDTO {

    private String cedula;

    private String nombres;

    private String apellidos;

    private String email;

    private String contrasena;

    private String telefono;

    private LocalDate nacimiento;

    private List<String> roles;

    private int idDisponibilidad;
}
