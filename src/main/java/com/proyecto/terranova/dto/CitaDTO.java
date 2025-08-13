package com.proyecto.terranova.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class CitaDTO {

    private int idCita;

    private LocalDate fechaCita;

    private String estadoCita;

    private LocalTime horaCita;

    private ProductoDTO producto;

    private UsuarioDTO comprador;

    private UsuarioDTO vendedor;

    private UbicacionDTO ubicacion;
}
