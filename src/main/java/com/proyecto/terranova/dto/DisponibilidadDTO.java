package com.proyecto.terranova.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class DisponibilidadDTO {

    private int idDisponibilidad;

    private LocalDate fecha;

    private LocalTime hora;

    private boolean disponible;

    private String cedulaUsuario;
}
