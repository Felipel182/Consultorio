package com.example.Consultorio.controller;

import com.example.Consultorio.exceptions.BadRequestException;
import com.example.Consultorio.exceptions.ResourceNotFoundException;
import com.example.Consultorio.model.Dentista;
import com.example.Consultorio.service.impl.DentistaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentista")
public class DentistaController {

    @Autowired
    DentistaServiceImpl dentistaService;

    public DentistaController(DentistaServiceImpl dentistaService) {
        this.dentistaService = dentistaService;
    }

    @PostMapping("/adicionar")
    public String salvar(@RequestBody Dentista dentista) throws BadRequestException {
        try {
            return dentistaService.salvar(dentista);
        } catch (Exception e) {
            throw new BadRequestException("Sua solicitação não pode ser processada, tente novamente");
        }
    }

    @GetMapping("/dentistas")
    public List<Dentista> buscarTodos() throws BadRequestException {
        try {
            return dentistaService.buscarTodos();
        } catch (Exception e) {
            throw new BadRequestException("Sua solicitação não pode ser processada, tente novamente");
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity excluir(@PathVariable int id) throws ResourceNotFoundException{
        try {
            dentistaService.excluir(id);
            return ResponseEntity.ok("Deletado");
        } catch(Exception e) {
            throw new ResourceNotFoundException("Não foi encontrado o dentista de id: " + id);
        }
    }

    @PutMapping("/alterar")
    public String updateDentista(@RequestBody Dentista dentista) throws BadRequestException {
        try {
            return dentistaService.updateDentista(dentista);
        } catch (Exception e) {
            throw new BadRequestException("Sua solicitação não pode ser processada, tente novamente");
        }
    }


}
