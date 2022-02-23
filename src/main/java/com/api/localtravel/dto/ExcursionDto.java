package com.api.localtravel.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
public class ExcursionDto {
    private Long precio;

    private String nombre;

    private String destino;

    private String duracion;

    private String descripcion;

    private String email;


}
