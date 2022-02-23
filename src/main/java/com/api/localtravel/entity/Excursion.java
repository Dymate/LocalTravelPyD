package com.api.localtravel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "excursion", indexes = {
        @Index(name = "fk_Excursion_Vendedor1_idx", columnList = "Vendedor_NIT")
})
@Entity
@Getter
@Setter
public class Excursion {
    @EmbeddedId
    private ExcursionId id;

    @Column(name = "precio", nullable = false)
    private Long precio;

    @Column(name = "nombre", nullable = false, length = 65)
    private String nombre;

    @Column(name = "destino", nullable = false, length = 45)
    private String destino;

    @Column(name = "duracion", nullable = false, length = 45)
    private String duracion;

    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;



    public Excursion() {

    }

    public Excursion(ExcursionId id, Long precio, String nombre, String destino, String duracion, String descripcion) {
        this.id = id;
        this.precio = precio;
        this.nombre = nombre;
        this.destino = destino;
        this.duracion = duracion;
        this.descripcion = descripcion;
    }
}