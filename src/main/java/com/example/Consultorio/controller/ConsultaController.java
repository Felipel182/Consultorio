package com.example.Consultorio.controller;

import com.example.Consultorio.model.ConsultaModel;
import com.example.Consultorio.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

public class ConsultaController {

    @Autowired
    ConsultaService consultaService;

    @PostMapping("/consulta/adicionar")
    public String salvar(@RequestBody ConsultaModel c) throws SQLException {
        return consultaService.salvar(c);
    }

    @GetMapping("/dentistas")
    public List<ConsultaModel> buscarTodos() throws SQLException{
        return consultaService.buscarTodos();
    }

    @DeleteMapping("/consulta/excluir/{id}")
    public void excluir(@RequestParam("id") int id) throws SQLException{
        consultaService.excluir(id);
    }

    @PutMapping("/consulta/alterar")
    public String updateDentista(ConsultaModel c) throws SQLException {
        return consultaService.updateConsulta(c);
    }
}
