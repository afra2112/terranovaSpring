package com.proyecto.terranova.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificacionDTO {

    private int idNotificacion;

    private String mensajeNotificacion;

    private LocalDateTime fechaNotificacion;

    private String tipo;

    private boolean leido;

    private String cedulaUsuario;
}
