package com.api.localtravel.service;


import com.api.localtravel.dto.ReservaDto;
import com.api.localtravel.entity.*;
import com.api.localtravel.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReservaService {
    @Autowired
    ReservaRepository reservaRepository;
    @Autowired
    CompradorService compradorService;
    @Autowired
    ExcursionService excursionService;

    public String crearReserva(ReservaDto reservaDto){
        if (compradorService.findByEmail(reservaDto.getEmail()).isPresent()) {
            Long id = compradorService.findByEmail(reservaDto.getEmail()).get().getId();
            if (excursionService.findById_Id(reservaDto.getExcursionId()).isPresent()){
            Long nit= excursionService.findById_Id(reservaDto.getExcursionId()).get().getId().getVendedorNit();
            ReservaId reservaId = new ReservaId(id, nit, reservaDto.getExcursionId());
            Long total= reservaDto.getCantPersonas()* excursionService.findById_Id(reservaDto.getExcursionId()).get().getPrecio();
            Reserva reserva = new Reserva(
                    reservaId,
                    reservaDto.getCantPersonas(),
                    total
             );
            reservaRepository.save(reserva);
            return "La reserva se ha creado exitosamente";
            }else {
                return "no se encontró una excursion con ese id";
            }
        }else{
            return "no se ha encontrado un usuario con ese correo";
            }

    }

    public List<Reserva> listarReservas(String email){
        if(compradorService.findByEmail(email).isPresent()){
        Long compradorDocumento = compradorService.findByEmail(email).get().getId();
        return reservaRepository.findAllById_CompradorId(compradorDocumento);
        }else
            return null;
    }

    public String editarExcursion(ReservaDto reservaDto){
       if(compradorService.findByEmail(reservaDto.getEmail()).isPresent()){
           Long idComprador= compradorService.findByEmail(reservaDto.getEmail()).get().getId();
           Reserva reserva= reservaRepository.findById_CompradorIdAndId_ExcursionId(idComprador, reservaDto.getExcursionId()).get();

            reserva.setTotal((reserva.getTotal()/reserva.getCantPersonas())*reservaDto.getCantPersonas());
            reserva.setCantPersonas(reservaDto.getCantPersonas());

            reservaRepository.save(reserva);
            return "la excursion ha sido editada";

       }else
           return "No se pudo editar la excursion";
    }

    public String borrarReserva(ReservaDto reservaDto) {

        if (compradorService.findByEmail(reservaDto.getEmail()).isPresent()) {
            Long documento = compradorService.findByEmail(reservaDto.getEmail()).get().getId();
            Reserva reserva = reservaRepository.findById_CompradorIdAndId_ExcursionId(documento, reservaDto.getExcursionId()).get();
            reservaRepository.delete(reserva);
            return "La reserva se ha eliminado";
        }else
            return "La reserva no se pudo eliminar";
    }
}
