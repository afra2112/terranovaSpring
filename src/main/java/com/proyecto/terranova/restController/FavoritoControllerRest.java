package com.proyecto.terranova.restController;

import com.proyecto.terranova.dto.FavoritoDTO;
import com.proyecto.terranova.service.FavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Favoritos")
public class FavoritoControllerRest {

    @Autowired
    private FavoritoService serviceFavorito;


    @GetMapping("/listarTodo")
    public ResponseEntity<List<FavoritoDTO>> obtenerTodosLosFavoritos(){
        List<FavoritoDTO> entidadesFavorito = serviceFavorito.findAll();
        return ResponseEntity.ok(entidadesFavorito);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FavoritoDTO> obtenerFavoritoPorId(@PathVariable Long id){
        FavoritoDTO dtoFavorito = serviceFavorito.findById(id);
        return ResponseEntity.ok(dtoFavorito);
    }

    @PostMapping("/crearFavorito")
    public ResponseEntity<FavoritoDTO> crearFavorito(@RequestBody FavoritoDTO dtoFavorito){
        serviceFavorito.save(dtoFavorito);
        return ResponseEntity.ok(dtoFavorito);
    }

    @DeleteMapping("/eliminarFavorito/{id}")
    public ResponseEntity<Long> eliminarFavorito(@PathVariable Long id){
        serviceFavorito.delete(id);
        return ResponseEntity.ok(id);
    }
}
