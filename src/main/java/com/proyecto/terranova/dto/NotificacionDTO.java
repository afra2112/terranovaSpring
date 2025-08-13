package com.proyecto.terranova.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

public class NotificacionDTO {

    private int idNotificacion;

    private String mensajeNotificacion;

    private LocalDateTime fechaNotificacion;

    private String tipo;

    private boolean leido;

    private UsuarioDTO usuario;
}
