package com.proyecto.terranova.dto;

import jakarta.persistence.*;
import lombok.Data;

public class FavoritoDTO {

    private int idFavorito;

    private UsuarioDTO comprador;

    private ProductoDTO producto;
}
