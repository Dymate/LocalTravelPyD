package com.api.localtravel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "comprador")
@Entity
public class Comprador {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "documento", nullable = false, unique = true)
    private Long documento;

    @Column(name = "nombre", nullable = false, length = 120)
    private String nombre;

    @Column(name = "email", nullable = false, length = 60)
    private String email;

    @Column(name = "`contraseña`", nullable = false, length = 120)
    private String contraseña;

    @Column(name = "telefono", nullable = false)
    private Long telefono;

    @Column(name = "direccion", length = 70)
    private String direccion;

    public Comprador(Long documento, String nombre, String email, String contraseña, Long telefono, String direccion) {
        this.documento = documento;
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Comprador() {

    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}