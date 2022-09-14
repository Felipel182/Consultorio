package com.example.Consultorio.controller;

import com.example.Consultorio.model.ConsultaModel;
import com.example.Consultorio.service.impl.ConsultaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
    @Autowired
    private final ConsultaServiceImpl consultaService;

    public ConsultaController(ConsultaServiceImpl consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping("/adicionar")
    public String salvar(@RequestBody ConsultaModel c) throws SQLException {
        return consultaService.salvar(c);
    }

    @GetMapping("/dentistas")
    public List<ConsultaModel> buscarTodos() throws SQLException{
        return consultaService.buscarTodos();
    }

    @DeleteMapping("/excluir/{id}")
    public void excluir(@RequestParam("id") int id) throws SQLException{
        consultaService.excluir(id);
    }

    @PutMapping("/alterar")
    public String updateDentista(ConsultaModel c) throws SQLException {
        return consultaService.updateConsulta(c);
    }
}
