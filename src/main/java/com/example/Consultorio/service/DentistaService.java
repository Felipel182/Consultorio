package com.example.Consultorio.service;

import com.example.Consultorio.dao.IDao;
import com.example.Consultorio.model.Dentista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class DentistaService {

    @Autowired
    IDao<Dentista> dentistaDaoH2;

    public Dentista salvar(Dentista dentista) throws SQLException{
        return dentistaDaoH2.salvar(dentista);
    }

    public List<Dentista> buscarTodos() throws SQLException{
        return dentistaDaoH2.buscarTodos();
    }

   public void excluir(int id) throws SQLException{
        dentistaDaoH2.excluir(id);
    }

}
