package com.example.Consultorio.dao;

import com.example.Consultorio.model.Dentista;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IDao<T> {

    Dentista salvar(Dentista dentista) throws SQLException;
    public List<T> buscarTodos() throws SQLException;
    public void excluir(int id) throws SQLException;
}
