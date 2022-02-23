package com.api.localtravel.controller;


import com.api.localtravel.dto.CompradorDto;
import com.api.localtravel.dto.LoginDto;
import com.api.localtravel.service.CompradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comprar")
public class CompradorController {

    @Autowired
    CompradorService compradorService;


    @PostMapping("/login")
    public ResponseEntity<Boolean>login (@RequestBody LoginDto loginDto){
        if (compradorService.existsByEmailAndContraseña(loginDto.getEmail(),loginDto.getPassword())){
      return new ResponseEntity<>(compradorService.existsByEmailAndContraseña(loginDto.getEmail(),loginDto.getPassword()), HttpStatus.ACCEPTED);
        }else
            return new ResponseEntity<>(false, HttpStatus.NOT_ACCEPTABLE);
    }
    @PostMapping("/registration")
    public ResponseEntity<String>registration (@RequestBody CompradorDto compradorDto){
        return new ResponseEntity(compradorService.crearComprador(compradorDto),HttpStatus.CREATED);
    }
}
