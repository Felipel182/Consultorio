package com.example.Consultorio.repository;

import com.example.Consultorio.model.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface DentistaRepository extends JpaRepository<Dentista, Integer>{

    @Query(value = "SELECT Dentista FROM Dentista WHERE id = ?1", nativeQuery = true)
    Optional<Dentista> findById(Integer id);
//    Optional<Dentista> findDentistaByName(String name);

}
