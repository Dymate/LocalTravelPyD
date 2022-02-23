package com.api.localtravel.entity;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ExcursionId implements Serializable {
    private static final long serialVersionUID = 2216134371111104695L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "Vendedor_NIT", nullable = false)
    private Long vendedorNit;

    public ExcursionId(Long vendedorNit) {
        this.vendedorNit=vendedorNit;
    }

    public ExcursionId() {

    }

    public Long getVendedorNit() {
        return vendedorNit;
    }

    public void setVendedorNit(Long vendedorNit) {
        this.vendedorNit = vendedorNit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vendedorNit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ExcursionId entity = (ExcursionId) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.vendedorNit, entity.vendedorNit);
    }
}