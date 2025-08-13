package com.proyecto.terranova.dto;

import jakarta.persistence.*;
import lombok.Data;

public class GastoVentaDTO {

    private int idGasto;

    private String nombreGasto;

    private Long valorGasto;

    private VentaDTO venta;
}
