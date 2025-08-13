package com.proyecto.terranova.dto;

import jakarta.persistence.*;
import lombok.Data;

public class ImagenDTO {

    private int idImagen;

    private String nombreArchivo;

    private ProductoDTO producto;
}
