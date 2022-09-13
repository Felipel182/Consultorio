package com.example.Consultorio.service;

import com.example.Consultorio.model.ConsultaModel;
import com.example.Consultorio.model.Dentista;

import java.sql.SQLException;
import java.util.List;

public interface ConsultaService<T> {

    public String salvar(ConsultaModel c) throws SQLException;

    public List<ConsultaModel> buscarTodos() throws SQLException;

    public String updateConsulta(ConsultaModel c) throws SQLException;

    public String excluir(Integer id) throws SQLException;
}
