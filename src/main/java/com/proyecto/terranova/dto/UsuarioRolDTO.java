package com.proyecto.terranova.dto;

import jakarta.persistence.*;
import lombok.Data;

public class UsuarioRolDTO {

    private int idRolUsuario;

    private UsuarioDTO usuario;

    private RolDTO rol;
}
