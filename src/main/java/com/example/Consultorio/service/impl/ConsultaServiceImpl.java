package com.example.Consultorio.service.impl;

import com.example.Consultorio.model.ConsultaModel;
import com.example.Consultorio.repository.ConsultaRepository;
import com.example.Consultorio.service.ConsultaService;

import java.sql.SQLException;
import java.util.List;

public class ConsultaServiceImpl implements ConsultaService<ConsultaModel> {

    private final ConsultaRepository consultaRepository;

    public ConsultaServiceImpl(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    @Override
    public String salvar(ConsultaModel c) throws SQLException {
        if (c != null) {
            consultaRepository.save(c);
            return "Consulta salva";
        }
        return "Consulta não encontrada";
    }

    @Override
    public List<ConsultaModel> buscarTodos() throws SQLException {
        return consultaRepository.findAll();
    }

    @Override
    public String updateConsulta(ConsultaModel c) throws SQLException {
        if (c != null && consultaRepository.findById(c.getConsultaID()).isPresent()){
            consultaRepository.saveAndFlush(c);
            return "Consulta atualizada";
        }
        return "Consulta não encontrada";
    }

    @Override
    public String excluir(Integer id) throws SQLException {
        if (consultaRepository.findById(id).isPresent()) {
            consultaRepository.deleteById(id);
            return "Consulta excluída";
        }
        return "Consulta não encontrada";
    }
}
