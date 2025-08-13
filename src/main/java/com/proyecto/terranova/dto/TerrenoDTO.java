package com.proyecto.terranova.dto;

import jakarta.persistence.*;
import lombok.Data;

public class TerrenoDTO {

    private int idTerreno;

    private double tamanoTerreno;

    private String tipoTerreno; //ENUM('Carretera', 'Trocha', 'Camino')

    private String topografiaTerreno;

    private String acceso; //ENUM('Carretera', 'Trocha', 'Camino')

    private String servicios;

    private String usoActual;

    private boolean cercado;

    private ProductoDTO producto;
}
