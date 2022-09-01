package com.example.Consultorio.controller;

import com.example.Consultorio.model.Dentista;
import com.example.Consultorio.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/dentista")
public class DentistaController {

    @Autowired
    DentistaService service;

    @PostMapping
    public Dentista salvaDentista(@RequestBody Dentista dentista) throws SQLException{
        return service.salvar(dentista);
    }

    @GetMapping
    public List<Dentista> buscarTodos() throws SQLException{
        return service.buscarTodos();
    }

        @DeleteMapping
    public void excluir(@RequestParam("id") int id) throws SQLException{
        service.excluir(id);
    }
}
