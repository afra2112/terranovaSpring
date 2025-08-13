package com.proyecto.terranova.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResenaDTO {

    private int idResena;

    private String comentario;

    private LocalDateTime fecha;

    private String cedulaComprador;

    private int idProducto;
}
