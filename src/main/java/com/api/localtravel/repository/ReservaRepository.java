package com.api.localtravel.repository;


import com.api.localtravel.entity.Comprador;
import com.api.localtravel.entity.Reserva;
import com.api.localtravel.entity.ReservaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, ReservaId> {


    List<Reserva> findAllById_CompradorId(Long compradorId);
    Optional<Reserva> findById_CompradorIdAndId_ExcursionId(Long compradorId, Long excursionId);
}
