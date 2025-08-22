
package com.proyecto.terranova.controller;

import com.proyecto.terranova.dto.UsuarioDTO;
import com.proyecto.terranova.repository.UsuarioRepository;
import com.proyecto.terranova.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/Usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService serviceUsuario;

    @GetMapping("/listarTodo")
    public ResponseEntity<List<UsuarioDTO>> obtenerTodosLosUsuarios(){
        List<UsuarioDTO> entidadesUsuario = serviceUsuario.findAll();
        return ResponseEntity.ok(entidadesUsuario);
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<UsuarioDTO> obtenerUsuarioPorId(@PathVariable String cedula){
        UsuarioDTO dtoUsuario = serviceUsuario.findById(cedula);
        return ResponseEntity.ok(dtoUsuario);
    }

    @PostMapping("/crearUsuario")
    public ResponseEntity<UsuarioDTO> crearUsuario(@RequestBody UsuarioDTO dtoUsuario){
        serviceUsuario.save(dtoUsuario);
        return ResponseEntity.ok(dtoUsuario);
    }

    @DeleteMapping("/eliminarUsuario/{cedula}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable String cedula){
        serviceUsuario.delete(cedula);
        return ResponseEntity.ok("Usuario eliminado");
    }

    @PutMapping("/editarUsuario/{id}")
    public  ResponseEntity<UsuarioDTO> editarUsuarioPorId(@PathVariable String id, @RequestBody UsuarioDTO usuarioDTO){
        UsuarioDTO usuarioActualizado = serviceUsuario.update(id, usuarioDTO);
        return ResponseEntity.ok(usuarioActualizado);
    }
}
