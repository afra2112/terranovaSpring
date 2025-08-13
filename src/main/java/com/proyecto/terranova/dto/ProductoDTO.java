package com.proyecto.terranova.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductoDTO {

    private int idProducto;

    private String nombreProducto;

    private String tipoProducto;

    private Long precioProducto;

    private String descripcion;

    private String estado;

    private LocalDate fechaPublicacion;

    private String cedulaVendedor;

    private int idUbicacion;
}
