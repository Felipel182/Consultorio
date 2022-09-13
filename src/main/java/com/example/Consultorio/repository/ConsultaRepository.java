package com.example.Consultorio.repository;

import com.example.Consultorio.model.ConsultaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ConsultaRepository extends JpaRepository<ConsultaModel, Integer> {

    @Query("SELECT Consulta FROM Consulta WHERE id = %d")
    ConsultaModel findConsultaByid(Integer id);

}
