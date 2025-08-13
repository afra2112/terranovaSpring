package com.proyecto.terranova.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "favoritos")
@Data
public class Favorito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFavorito;

    @ManyToOne
    @JoinColumn(name = "cedula")
    private Usuario comprador;

    @OneToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;
}
