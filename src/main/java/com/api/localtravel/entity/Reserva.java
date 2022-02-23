package com.api.localtravel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "reserva", indexes = {
        @Index(name = "fk_Reserva_Comprador_idx", columnList = "Comprador_id"),
        @Index(name = "fk_Reserva_Excursion1_idx", columnList = "Excursion_id, Excursion_Vendedor_NIT")
})
@Entity
@Getter
@Setter
public class Reserva {
    @EmbeddedId
    private ReservaId id;

    @Column(name = "cant_personas", nullable = false)
    private Integer cantPersonas;

    @Column(name = "total", nullable = false)
    private Long total;


    public Reserva(ReservaId id, Integer cantPersonas, Long total) {
        this.id = id;
        this.cantPersonas = cantPersonas;
        this.total = total;
    }

    public Reserva() {

    }
}