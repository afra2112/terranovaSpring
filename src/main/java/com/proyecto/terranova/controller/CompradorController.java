package com.proyecto.terranova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comprador")
public class CompradorController {

    @GetMapping("/index")
    public String indexComprador(){
        return "comprador";
    }
}
