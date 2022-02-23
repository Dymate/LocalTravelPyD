package com.api.localtravel.controller;

import com.api.localtravel.dto.ExcursionDto;
import com.api.localtravel.entity.Excursion;
import com.api.localtravel.service.ExcursionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/excursion")
public class ExcursionController {
    @Autowired
    ExcursionService excursionService;

    @GetMapping
    public ResponseEntity<List<Excursion>> listarExcursiones(){
        return new ResponseEntity(excursionService.listarExcursiones(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> crearExcursion(@RequestBody ExcursionDto excursionDto){

        if (excursionService.findByNombre(excursionDto.getNombre()).isPresent()){
            return new ResponseEntity("Ya existe una excursion con ese nombre", HttpStatus.OK);
        }else
            return new ResponseEntity(excursionService.crearExcursion(excursionDto), HttpStatus.CREATED);


    }

    @PutMapping("/{id}")
    public ResponseEntity<String>editarExcursion(@PathVariable("id") Long id, @RequestBody ExcursionDto excursionDto){
        return new ResponseEntity<>(excursionService.editarExcursion(id, excursionDto),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>borrarExcursion(@PathVariable("id")Long id){
        return new ResponseEntity<>(excursionService.borrarExcursion(id),HttpStatus.OK);
    }
}
