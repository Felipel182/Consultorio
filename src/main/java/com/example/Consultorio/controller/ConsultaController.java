package com.example.Consultorio.controller;

import com.example.Consultorio.exceptions.BadRequestException;
import com.example.Consultorio.exceptions.ResourceNotFoundException;
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
    public String salvar(@RequestBody ConsultaModel c) throws BadRequestException {
        try {
            return consultaService.salvar(c);
        } catch (Exception e) {
            throw new BadRequestException("Sua solicitação não pode ser processada, tente novamente");
        }
    }

    @GetMapping("/dentistas")
    public List<ConsultaModel> buscarTodos() throws BadRequestException {
        try {
            return consultaService.buscarTodos();
        } catch (Exception e) {
            throw new BadRequestException("Sua solicitação não pode ser processada, tente novamente");
        }
    }

    @DeleteMapping("/excluir/{id}")
    public void excluir(@RequestParam("id") int id) throws ResourceNotFoundException{
        try {
            consultaService.excluir(id);
        } catch(Exception e) {
            throw new ResourceNotFoundException("Não foi encontrada a consulta de id: " + id);
        }
    }

    @PutMapping("/alterar")
    public String updateDentista(ConsultaModel c) throws BadRequestException {
        try {
            return consultaService.updateConsulta(c);
        } catch (Exception e) {
            throw new BadRequestException("Sua solicitação não pode ser processada, tente novamente");
        }
    }
}
