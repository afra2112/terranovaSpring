package com.proyecto.terranova.dto;

import jakarta.persistence.*;
import lombok.Data;

public class FincaDTO {

    private int idFinca;

    private String espacioTotal;

    private String espacioConstruido;

    private int estratoFinca;

    private int numeroHabitaciones;

    private int numeroBanos;

    private ProductoDTO producto;
}
