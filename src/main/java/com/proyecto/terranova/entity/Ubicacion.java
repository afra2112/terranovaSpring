package com.proyecto.terranova.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ubicaciones")
@Data
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUbicacion;

    @Column(length = 50, nullable = false)
    private String departamento;

    @Column(length = 50, nullable = false)
    private String ciudad;
}
