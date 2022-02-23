package com.api.localtravel.service;

import com.api.localtravel.dto.CompradorDto;
import com.api.localtravel.dto.VendedorDto;
import com.api.localtravel.entity.Comprador;
import com.api.localtravel.entity.Vendedor;
import com.api.localtravel.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class VendedorService {
    @Autowired
    VendedorRepository vendedorRepository;

    public Optional<Vendedor> findByEmail(String email){
        return vendedorRepository.findByEmail(email);
    }

    public boolean existsByEmailAndContraseña(String email, String password){
        return vendedorRepository.existsByEmailAndPassword(email, password);
    }

    public String crearVendedor(VendedorDto vendedorDto){

        if(vendedorRepository.existsByEmail(vendedorDto.getEmail())){
            return "ya existe un usuario con ese correo";
        }else{
            Vendedor vendedor = new Vendedor(vendedorDto.getNit(),vendedorDto.getNombreEmpresa(),vendedorDto.getDireccion(), vendedorDto.getMunicipio(),vendedorDto.getNombreVendedor(),
                    vendedorDto.getEmail(),vendedorDto.getPassword());
            vendedorRepository.save(vendedor);
            return "usuario creado";
        }
    }
}
