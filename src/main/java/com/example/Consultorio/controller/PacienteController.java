package com.example.Consultorio.controller;


import com.example.Consultorio.model.PacienteModel;
import com.example.Consultorio.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @PostMapping("/paciente/adicionar")
    public String salvar(@RequestBody PacienteModel p) throws SQLException {
        return pacienteService.salvar(p);
    }

    @GetMapping("/pacientes")
    public List<PacienteModel> buscarTodos() throws SQLException{
        return pacienteService.buscarTodos();
    }

    @DeleteMapping("/paciente/excluir/{id}")
    public void excluir(@RequestParam("id") int id) throws SQLException{
        pacienteService.excluir(id);
    }

    @PutMapping("/paciente/alterar")
    public String updateDentista(PacienteModel p) throws SQLException {
        return pacienteService.updatePaciente(p);
    }
}
