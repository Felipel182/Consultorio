package com.example.Consultorio.repository;
import com.example.Consultorio.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional // trabalhar dentro do escopo de uma transação no BD.
public interface UserRepository extends JpaRepository<AppUser, Integer> {

    @Query(value = "SELECT User u FROM User WHERE u.id = ?1", nativeQuery = true)
//    Optional<AppUser> findById(Integer id);
    Optional<AppUser> findByEmail(String email);

}