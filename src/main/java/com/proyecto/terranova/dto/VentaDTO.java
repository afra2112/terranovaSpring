package com.proyecto.terranova.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VentaDTO {

    private int idVenta;

    private LocalDateTime fechaVenta;

    private String estado; //ENUM ('En Proceso', 'Finalizada', 'Cancelada', 'Pendiente Confirmacion')

    private String nota;

    private String metodoPago;

    private Long gananciaNeta;

    private int idProducto;

    private String cedulaComprador;

    private String cedulaVendedor;
}
