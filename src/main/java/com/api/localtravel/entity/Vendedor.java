package com.api.localtravel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "vendedor")
@Entity
@Getter
@Setter
public class Vendedor {
    @Id
    @Column(name = "NIT", nullable = false)
    private Long nit;

    @Column(name = "nombre_empresa", nullable = false, length = 85)
    private String nombreEmpresa;

    @Column(name = "direccion", nullable = false, length = 45)
    private String direccion;

    @Column(name = "municipio", nullable = false, length = 55)
    private String municipio;

    @Column(name = "nombre_vendedor", nullable = false, length = 45)
    private String nombreVendedor;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    public Vendedor(Long nit,String nombreEmpresa, String direccion, String municipio, String nombreVendedor, String email, String password) {
       this.nit=nit;
       this.nombreEmpresa = nombreEmpresa;
        this.direccion = direccion;
        this.municipio = municipio;
        this.nombreVendedor = nombreVendedor;
        this.email = email;
        this.password = password;
    }

    public Vendedor() {

    }
}