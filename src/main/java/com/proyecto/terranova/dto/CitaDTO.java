package com.proyecto.terranova.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CitaDTO {

    private int idCita;

    private LocalDate fechaCita;

    private String estadoCita;

    private LocalTime horaCita;

    private int idProducto;

    private String cedulaComprador;

    private String cedulaVendedor;

    private int idUbicacion;
}
