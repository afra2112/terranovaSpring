package com.proyecto.terranova.dto;

import jakarta.persistence.*;

import java.time.LocalDateTime;

public class ResenaDTO {

    private int idResena;

    private String comentario;

    private LocalDateTime fecha;

    private UsuarioDTO comprador;

    private UsuarioDTO vendedor;

    private ProductoDTO producto;
}
