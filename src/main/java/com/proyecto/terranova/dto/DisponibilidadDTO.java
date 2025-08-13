package com.proyecto.terranova.dto;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class DisponibilidadDTO {

    private int idDisponibilidad;

    private LocalDate fecha;

    private LocalTime hora;

    private boolean disponible;

    private UsuarioDTO usuario;
}
