package com.example.Consultorio.service;

import com.example.Consultorio.dao.IDao;
import com.example.Consultorio.model.Dentista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public interface DentistaService<T> {


    public String salvar(Dentista dentista) throws SQLException;

    public List<Dentista> buscarTodos() throws SQLException;

    public String updateDentista(Dentista dentista) throws SQLException;

   public String excluir(Integer id) throws SQLException;

}
