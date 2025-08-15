
package com.proyecto.terranova.controller;

import com.proyecto.terranova.dto.UbicacionDTO;
import com.proyecto.terranova.service.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/Ubicacions")
public class UbicacionController {

    @Autowired
    private UbicacionService serviceUbicacion;


    @GetMapping("/listarTodo")
    public ResponseEntity<List<UbicacionDTO>> obtenerTodosLosUbicacions(){
        List<UbicacionDTO> entidadesUbicacion = serviceUbicacion.findAll();
        return ResponseEntity.ok(entidadesUbicacion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UbicacionDTO> obtenerUbicacionPorId(@PathVariable Long id){
        UbicacionDTO dtoUbicacion = serviceUbicacion.findById(id);
        return ResponseEntity.ok(dtoUbicacion);
    }

    @PostMapping("/crearUbicacion")
    public ResponseEntity<UbicacionDTO> crearUbicacion(@RequestBody UbicacionDTO dtoUbicacion){
        serviceUbicacion.save(dtoUbicacion);
        return ResponseEntity.ok(dtoUbicacion);
    }

    @DeleteMapping("/eliminarUbicacion/{id}")
    public ResponseEntity<Long> eliminarUbicacion(@PathVariable Long id){
        serviceUbicacion.delete(id);
        return ResponseEntity.ok(id);
    }
}
