package com.example.Consultorio.service.impl;

import com.example.Consultorio.model.Dentista;
import com.example.Consultorio.repository.DentistaRepository;
import com.example.Consultorio.service.DentistaService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class DentistaServiceImpl implements DentistaService<Dentista> {

    private final DentistaRepository dentistaRepository;

    public DentistaServiceImpl(DentistaRepository dentistaRepository) {
        this.dentistaRepository = dentistaRepository;
    }

    @Override
    public String salvar(Dentista dentista) throws SQLException {
       dentistaRepository.save(dentista);
       return "Dentista salvo";

    }

    @Override
    public List<Dentista> buscarTodos() throws SQLException{
        return dentistaRepository.findAll();
    }

    @Override
    public String excluir(Integer id) throws SQLException{
        dentistaRepository.deleteById(id);
        return "Dentista excluído";
    }

    @Override
    public String updateDentista(Dentista dentista) throws SQLException {
       dentistaRepository.saveAndFlush(dentista);
       return "Dentista atualizado";
    };
}
