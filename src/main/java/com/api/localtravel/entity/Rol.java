package com.api.localtravel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "rol")
@Entity
public class Rol {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre_rol", length = 45)
    private String nombreRol;

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}