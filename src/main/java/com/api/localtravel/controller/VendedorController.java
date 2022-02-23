package com.api.localtravel.controller;

import com.api.localtravel.dto.CompradorDto;
import com.api.localtravel.dto.LoginDto;
import com.api.localtravel.dto.VendedorDto;
import com.api.localtravel.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {
    @Autowired
    VendedorService vendedorService;

    @PostMapping("/login")
    public ResponseEntity<Boolean> login (@RequestBody LoginDto loginDto){
        if (vendedorService.existsByEmailAndContraseña(loginDto.getEmail(),loginDto.getPassword())){
            return new ResponseEntity<>(vendedorService.existsByEmailAndContraseña(loginDto.getEmail(),loginDto.getPassword()), HttpStatus.ACCEPTED);
        }else
            return new ResponseEntity<>(false, HttpStatus.NOT_ACCEPTABLE);
    }
    @PostMapping("/registration")
    public ResponseEntity<String>registration (@RequestBody VendedorDto vendedorDto){
        return new ResponseEntity(vendedorService.crearVendedor(vendedorDto),HttpStatus.CREATED);
    }
}
