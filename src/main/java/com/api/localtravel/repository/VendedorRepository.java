package com.api.localtravel.repository;

import com.api.localtravel.entity.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor,Long> {


    Optional<Vendedor> findByEmail(String email);

    boolean existsByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email);
}
