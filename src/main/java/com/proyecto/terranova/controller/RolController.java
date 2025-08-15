
package com.proyecto.terranova.controller;

import com.proyecto.terranova.dto.RolDTO;
import com.proyecto.terranova.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/Rols")
public class RolController {

    @Autowired
    private RolService serviceRol;


    @GetMapping("/listarTodo")
    public ResponseEntity<List<RolDTO>> obtenerTodosLosRols(){
        List<RolDTO> entidadesRol = serviceRol.findAll();
        return ResponseEntity.ok(entidadesRol);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> obtenerRolPorId(@PathVariable Long id){
        RolDTO dtoRol = serviceRol.findById(id);
        return ResponseEntity.ok(dtoRol);
    }

    @PostMapping("/crearRol")
    public ResponseEntity<RolDTO> crearRol(@RequestBody RolDTO dtoRol){
        serviceRol.save(dtoRol);
        return ResponseEntity.ok(dtoRol);
    }

    @DeleteMapping("/eliminarRol/{id}")
    public ResponseEntity<Long> eliminarRol(@PathVariable Long id){
        serviceRol.delete(id);
        return ResponseEntity.ok(id);
    }
}
