package com.example.Consultorio.controller;


import com.example.Consultorio.exceptions.BadRequestException;
import com.example.Consultorio.exceptions.ResourceNotFoundException;
import com.example.Consultorio.model.PacienteModel;
import com.example.Consultorio.service.PacienteService;
import com.example.Consultorio.service.impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteServiceImpl pacienteService;

    public PacienteController(PacienteServiceImpl pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("/adicionar")
    public String salvar(@RequestBody PacienteModel p) throws BadRequestException {
        try {
            return pacienteService.salvar(p);
        } catch (Exception e) {
            throw new BadRequestException("Sua solicitação não pode ser processada, tente novamente");
        }
    }

    @GetMapping("/pacientes")
    public List<PacienteModel> buscarTodos() throws BadRequestException {
        try {
            return pacienteService.buscarTodos();
        } catch (Exception e) {
            throw new BadRequestException("Sua solicitação não pode ser processada, tente novamente");
        }
    }

    @DeleteMapping("/excluir/{id}")
    public void excluir(@RequestParam("id") int id) throws ResourceNotFoundException {
        try {
            pacienteService.excluir(id);
        } catch(Exception e) {
            throw new ResourceNotFoundException("Não foi encontrado o paciente de id: " + id);
        }
    }

    @PutMapping("/alterar")
    public String updateDentista(PacienteModel p) throws BadRequestException {
        try {
            return pacienteService.updatePaciente(p);
        } catch (Exception e) {
            throw new BadRequestException("Sua solicitação não pode ser processada, tente novamente");
        }
    }
}
