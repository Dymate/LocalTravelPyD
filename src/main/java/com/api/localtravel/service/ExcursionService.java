package com.api.localtravel.service;

import com.api.localtravel.dto.ExcursionDto;
import com.api.localtravel.entity.Excursion;
import com.api.localtravel.entity.ExcursionId;
import com.api.localtravel.entity.ReservaId;
import com.api.localtravel.repository.ExcursionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExcursionService {
    @Autowired
    ExcursionRepository excursionRepository;
    @Autowired
    VendedorService vendedorService;

    public Optional<Excursion>findByNombre(String nombre){
        return excursionRepository.findByNombre(nombre);
    }

    public Optional<Excursion> findById_Id(Long id){
        return excursionRepository.findById_Id(id);
    }


    public String crearExcursion(ExcursionDto excursionDto){
        if (vendedorService.findByEmail(excursionDto.getEmail()).isPresent()) {
            Long id = vendedorService.findByEmail(excursionDto.getEmail()).get().getNit();
            ExcursionId excursionId = new ExcursionId(id);
            Excursion excursion = new Excursion(
                    excursionId,
                    excursionDto.getPrecio(),
                    excursionDto.getNombre(),
                    excursionDto.getDestino(),
                    excursionDto.getDuracion(),
                    excursionDto.getDescripcion());
            excursionRepository.save(excursion);
            return "La excursión se ha creado exitosamente";
        }else
            return "no se ha encontrado un usuario con ese correo";
    }

    public List<Excursion> listarExcursiones(){
        return excursionRepository.findAll();
    }

    public String editarExcursion(Long id, ExcursionDto excursionDto){

        if ( excursionRepository.findById_Id(id).isPresent()){
            Excursion excursion = excursionRepository.findById_Id(id).get();
            excursion.setPrecio(excursionDto.getPrecio());
            excursion.setNombre(excursionDto.getNombre());
            excursion.setDestino(excursionDto.getDestino());
            excursion.setDescripcion(excursionDto.getDescripcion());

            excursionRepository.save(excursion);
            return "la excursion ha sido editada";
        }else
            return "no se encontró la excursión";

    }

    public String borrarExcursion(Long id){

        if ( excursionRepository.findById_Id(id).isPresent()) {
            Excursion excursion = excursionRepository.findById_Id(id).get();
            excursionRepository.delete(excursion);
            return "La excursión ha sido borrada";
        }else
            return "No se encontró una excursion con ese id";
    }
}
