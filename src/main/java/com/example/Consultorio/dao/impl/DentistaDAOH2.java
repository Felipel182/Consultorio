package com.example.Consultorio.dao.impl;

import com.example.Consultorio.model.Dentista;
import com.example.Consultorio.dao.ConfiguracaoJDBC;
import com.example.Consultorio.dao.IDao;
import com.example.Consultorio.model.Dentista;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.apache.logging.log4j.LogManager.getLogger;


@Configuration
public class DentistaDAOH2 implements IDao<Dentista> {

    private ConfiguracaoJDBC configuracaoJDBC;

    final static Logger log = getLogger(com.example.Consultorio.dao.impl.DentistaDAOH2.class);

    @Override
    public Dentista salvar(Dentista dentista) throws SQLException {
        log.info("Abrindo conexão");
        String SQLInsert = String.format("INSERT INTO dentista (nome,email,numMatricula,atendeConvenio)"+
                "VALUES ('%s','%s',%d,'%s')",dentista.getNome(),dentista.getEmail(),dentista.getNumMatricula(),dentista.getAtendeConvenio());
        Connection connection = null;
        try{
            log.info("Sanvando o dentista: "+dentista.getNome());
            configuracaoJDBC = new ConfiguracaoJDBC("org.h2.Driver","jdbc:h2:~/dentista" +
                    "INIT=RUNSCRIPT FROM 'create.sql'","sa","");
            connection = configuracaoJDBC.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQLInsert,Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();

            if(resultSet.next()){
                dentista.setId(resultSet.getInt(1));
            }
        }
        catch(Exception e){
            e.printStackTrace();
            log.error("Erro ao inserir o dentista: "+e.getMessage());
        }finally{
            log.info("Fechando a conexão");
            connection.close();
        }
        return dentista;
    }

    @Override
    public List<Dentista> buscarTodos() throws SQLException{
        log.debug("Abrindo uma conexão no banco");
        Connection connection = null;
        Statement stmt = null;
        String query = "SELECT * FROM dentista";
        List<Dentista> dentistas = new ArrayList<>();
        try{

            configuracaoJDBC = new ConfiguracaoJDBC("org.h2.Driver","jdbc:h2:~/dentista" +
                    "INIT=RUNSCRIPT FROM 'create.sql'","sa","");
            connection = configuracaoJDBC.getConnection();
            stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery(query);
            log.debug("Buscando todos os dentistas do banco");

            while(resultado.next()){
                dentistas.add(criarObjetoProduto(resultado));
            }
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }finally {
            log.debug("Fechando a conexão no banco");
            stmt.close();
        }

        return dentistas;
    }


    @Override
    public void excluir(int id) throws SQLException{
        log.info("Abrindo conexão");
        Connection connection = null;
        Statement stmt = null;
        String SQLDelete = String.format("DELETE FROM dentista where id = %s",id);
        try{

            configuracaoJDBC = new ConfiguracaoJDBC("org.h2.Driver","jdbc:h2:~/dentista INIT=RUNSCRIPT FROM 'create.sql'","sa","");
            connection = configuracaoJDBC.getConnection();
            log.debug("Excluindo dentista por id: "+id);
            stmt = connection.createStatement();
            stmt.execute(SQLDelete);
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }finally {
            log.debug("Fechando conexão");
            connection.close();
        }

    }

    private Dentista criarObjetoProduto(ResultSet resultSet) throws SQLException{
        Integer id = resultSet.getInt("id");
        String nome = resultSet.getString("nome");
        String email = resultSet.getString("email");
        Integer numMatricula = resultSet.getInt("numMatricula");
        String atendeConvenio = resultSet.getString("atendeConvenio");
        return new Dentista(id,nome,email,numMatricula,atendeConvenio);
    }

}