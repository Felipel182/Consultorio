package com.example.Consultorio.service;

import com.example.Consultorio.model.PacienteModel;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public interface PacienteService<T> {
    public String salvar(PacienteModel p) throws SQLException;

    public List<PacienteModel> buscarTodos() throws SQLException;

    public String updatePaciente(PacienteModel p) throws SQLException;

    public String excluir(Integer id) throws SQLException;
}
