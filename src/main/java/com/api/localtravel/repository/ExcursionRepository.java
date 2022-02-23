package com.api.localtravel.repository;

import com.api.localtravel.entity.Excursion;
import com.api.localtravel.entity.ExcursionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExcursionRepository extends JpaRepository<Excursion, ExcursionId> {

    @Override
    Optional<Excursion> findById(ExcursionId id);

    Optional<Excursion> findById_Id(Long id);
    Optional<Excursion> findById_VendedorNitAndNombre(Long vendedorNit, String nombre);
    Optional<Excursion> findByNombre(String nombre);
}
