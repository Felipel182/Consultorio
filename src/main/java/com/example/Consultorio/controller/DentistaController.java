package com.example.Consultorio.controller;

import com.example.Consultorio.model.Dentista;
import com.example.Consultorio.service.DentistaService;
import com.example.Consultorio.service.impl.DentistaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
//@RequestMapping("/dentista")
public class DentistaController {

    @Autowired
    DentistaServiceImpl dentistaService;

    public DentistaController(DentistaServiceImpl dentistaService) {
        this.dentistaService = dentistaService;
    }

    @PostMapping("/dentista/adicionar")
    public String salvar(@RequestBody Dentista dentista) throws SQLException{
        return dentistaService.salvar(dentista);
    }

    @GetMapping("/dentistas")
    public List<Dentista> buscarTodos() throws SQLException{
        return dentistaService.buscarTodos();
    }

    @DeleteMapping("/dentista/excluir/{id}")
    public void excluir(@RequestParam("id") int id) throws SQLException{
        dentistaService.excluir(id);
    }

    @PutMapping("/dentista/alterar")
    public String updateDentista(Dentista dentista) throws SQLException {
        return dentistaService.updateDentista(dentista);
    }


}
