package com.proyecto.terranova.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ComprobanteDTO {

    private int idComprobante;

    private String nombreComprobante;

    private String rutaArchivo;

    private LocalDateTime fechaSubida;

    private int idVenta;
}
