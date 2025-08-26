package com.proyecto.terranova.controller;

import com.proyecto.terranova.dto.UsuarioDTO;
import com.proyecto.terranova.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PaginasController {

    @Autowired
    private UsuarioService serviceUsuario;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/login")
    public String validarLogin(@RequestParam String email, @RequestParam String contrasena, Model model){
        boolean valido = serviceUsuario.validarLogin(email, contrasena);

        if(valido){
            return "redirect:/paginaPrincipalPrueba";
        }else{
            model.addAttribute("fail", true);
            return "index";
        }
    }

    @GetMapping("/registro")
    public String irRegistro(Model model){
        model.addAttribute("usuario", new UsuarioDTO());
        return "registrossss";
    }

    @PostMapping("/registro")
    public String registrarUsuario(UsuarioDTO usuarioDTO, Model model){
        serviceUsuario.save(usuarioDTO);
        return "redirect:/paginaPrincipalPrueba";
    }

    @GetMapping("/paginaPrincipalPrueba")
    public String mostrarPaginaPrincipal(){
        return "paginaPrincipalPrueba";
    }
}
