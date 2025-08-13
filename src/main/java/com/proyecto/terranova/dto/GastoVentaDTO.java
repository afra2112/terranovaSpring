package com.proyecto.terranova.dto;

import lombok.Data;

@Data
public class GastoVentaDTO {

    private int idGasto;

    private String nombreGasto;

    private Long valorGasto;

    private int idVenta;
}
