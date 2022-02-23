package com.api.localtravel.repository;

import com.api.localtravel.entity.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompradorRepository extends JpaRepository<Comprador,Long> {

    Optional<Comprador> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsById(String document);
    boolean existsByEmailAndAndContraseña(String email, String contraseña);

}
