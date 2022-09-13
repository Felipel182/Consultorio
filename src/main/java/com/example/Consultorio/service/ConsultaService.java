package com.example.Consultorio.service;

import com.example.Consultorio.model.ConsultaModel;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public interface ConsultaService<T> {

    String salvar(ConsultaModel c) throws SQLException;

    List<ConsultaModel> buscarTodos() throws SQLException;

    String updateConsulta(ConsultaModel c) throws SQLException;

    String excluir(Integer id) throws SQLException;
}
