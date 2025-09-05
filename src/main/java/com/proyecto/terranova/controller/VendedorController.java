package com.proyecto.terranova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vendedor")
public class VendedorController {

    @GetMapping("/index")
    public String indexVendedor(){
        return "vendedor";
    }
}
