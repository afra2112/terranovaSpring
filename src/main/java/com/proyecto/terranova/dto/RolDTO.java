package com.proyecto.terranova.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class RolDTO {

    private int idRol;

    private String nombreRol;

    private List<UsuarioRolDTO> usuarioRoles = new ArrayList<>();
}
