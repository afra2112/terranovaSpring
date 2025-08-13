package com.proyecto.terranova.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

public class VentaDTO {

    private int idVenta;

    private LocalDateTime fechaVenta;

    private String estado; //ENUM ('En Proceso', 'Finalizada', 'Cancelada', 'Pendiente Confirmacion')

    private String nota;

    private String metodoPago;

    private Long gananciaNeta;

    private ProductoDTO producto;

    private UsuarioDTO comprador;

    private UsuarioDTO vendedor;
}
