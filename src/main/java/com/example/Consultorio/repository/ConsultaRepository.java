package com.example.Consultorio.repository;

import com.example.Consultorio.model.ConsultaModel;
import com.example.Consultorio.model.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ConsultaRepository extends JpaRepository<ConsultaModel, Integer> {

    @Query("SELECT Consulta c FROM Consulta WHERE c.id = ?1")
    Optional<Dentista> findDentistaByNameByName(String name);

}
