package com.example.Consultorio.service.impl;

import com.example.Consultorio.model.ConsultaModel;
import com.example.Consultorio.repository.ConsultaRepository;
import com.example.Consultorio.service.ConsultaService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class ConsultaServiceImpl implements ConsultaService<ConsultaModel> {

    private final ConsultaRepository consultaRepository;

    public ConsultaServiceImpl(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    @Override
    public String salvar(ConsultaModel c) throws SQLException {
        consultaRepository.save(c);
        return "Consulta salva";
    }

    @Override
    public List<ConsultaModel> buscarTodos() throws SQLException {
        return consultaRepository.findAll();
    }

    @Override
    public String updateConsulta(ConsultaModel c) throws SQLException {

        consultaRepository.saveAndFlush(c);
        return "Consulta atualizada";
    }

    @Override
    public String excluir(Integer id) throws SQLException {

        consultaRepository.deleteById(id);
        return "Consulta excluída";
    }
}
