package com.example.Consultorio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dentista")
public class PedidoController {

    @RequestMapping (value = "/findDentista",method = RequestMethod.GET)
    public String getDentistaAll(){
        return "Você buscou todos os dentistas";
    }
}