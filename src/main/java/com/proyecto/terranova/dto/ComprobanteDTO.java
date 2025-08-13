package com.proyecto.terranova.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


public class ComprobanteDTO {

    private int idComprobante;

    private String nombreComprobante;

    private String rutaArchivo;

    private LocalDateTime fechaSubida;

    private VentaDTO venta;
}
