package com.api.localtravel.service;

import com.api.localtravel.dto.CompradorDto;
import com.api.localtravel.entity.Comprador;
import com.api.localtravel.repository.CompradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CompradorService {

    @Autowired
    CompradorRepository compradorRepository;

    Optional<Comprador> findByEmail(String email){
        return compradorRepository.findByEmail(email);
    }
    public boolean existsByEmail(String email){
        return compradorRepository.existsByEmail(email);
    }
    public boolean existsByDocument(String document){
        return compradorRepository.existsById(document);
    }

    public boolean existsByEmailAndContraseña(String email, String password){
        return compradorRepository.existsByEmailAndAndContraseña(email, password);
    }

    public String crearComprador(CompradorDto compradorDto){

        if(compradorRepository.existsByEmail(compradorDto.getEmail())){
            return "ya existe un usuario con ese correo";
        }else{
            Comprador comprador = new Comprador(compradorDto.getDocumento(), compradorDto.getNombre(), compradorDto.getEmail(),
                    compradorDto.getContraseña(), compradorDto.getTelefono(), compradorDto.getDireccion());
            compradorRepository.save(comprador);
            return "usuario creado";
        }
    }

}
