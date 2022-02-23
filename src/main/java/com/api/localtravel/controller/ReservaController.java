package com.api.localtravel.controller;

import com.api.localtravel.dto.ExcursionDto;
import com.api.localtravel.dto.ReservaDto;
import com.api.localtravel.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    ReservaService reservaService;

    @PostMapping
    public ResponseEntity<String> crearReserva(@RequestBody ReservaDto reservaDto){

            return new ResponseEntity(reservaService.crearReserva(reservaDto), HttpStatus.CREATED);
    }

}
