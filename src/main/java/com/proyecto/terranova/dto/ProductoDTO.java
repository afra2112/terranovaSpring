package com.proyecto.terranova.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

public class ProductoDTO {

    private int idProducto;

    private String nombreProducto;

    private String tipoProducto;

    private Long precioProducto;

    private String descripcion;

    private String estado;

    private LocalDate fechaPublicacion;

    private UsuarioDTO usuario;

    private UbicacionDTO ubicacion;
}
