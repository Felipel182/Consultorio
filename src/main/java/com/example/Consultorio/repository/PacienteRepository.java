package com.example.Consultorio.repository;

import com.example.Consultorio.model.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<PacienteModel, Integer> {

    @Query(value = "SELECT Paciente p FROM Paciente WHERE p.id = ?1", nativeQuery = true)
    Optional<PacienteModel> findPacienteByName(String name);

}
