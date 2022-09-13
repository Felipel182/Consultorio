package com.example.Consultorio.repository;

import com.example.Consultorio.model.ConsultaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface ConsultaRepository extends JpaRepository<ConsultaModel, Integer> {

    @Query(value = "select Consulta from Consulta where id = ?1", nativeQuery = true)
    Optional<ConsultaModel> findConsultaById(Integer id);

}
