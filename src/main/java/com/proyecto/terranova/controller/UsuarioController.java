
package com.proyecto.terranova.controller;

import com.proyecto.terranova.dto.UsuarioDTO;
import com.proyecto.terranova.service.RolService;
import com.proyecto.terranova.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService serviceUsuario;

    @Autowired
    private RolService rolService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/index")
    public String index(Model model, Authentication authentication){
        boolean esComprador = authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("COMPRADOR"));
        boolean esVendedor = authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("VENDEDOR"));

        model.addAttribute("esComprador", esComprador);
        model.addAttribute("esVendedor", esVendedor);

        return "index";
    }

    @GetMapping("/registro")
    public String registroForm(Model model){
        model.addAttribute("usuarioDTO", new UsuarioDTO());
        model.addAttribute("opcionesRol", rolService.findAll());
        return "registro";
    }

    @PostMapping("/registro")
    public String registrarUsuario(@Valid @ModelAttribute UsuarioDTO usuarioDTO, Model model, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "redirect:/usuarios/registro";
        }
        if(!serviceUsuario.save(usuarioDTO)){
            System.out.println("YAEXISTE");
            redirectAttributes.addAttribute("yaExiste", true);
            return "redirect:/usuarios/registro";
        }
        redirectAttributes.addAttribute("creado", true);
        return "redirect:/usuarios/login";
    }


    @GetMapping("/403")
    public String error403(){
        return "403";
    }
}