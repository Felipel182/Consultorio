package com.example.Consultorio.repository;

import com.example.Consultorio.model.Dentista;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface DentistaRepository extends JpaRepository<Dentista, Integer>{

    @Query("SELECT Dentista d FROM Dentista WHERE d.id = ?1")
    Optional<Dentista> findDentistaByNameByName(String name);

}
