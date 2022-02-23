package com.api.localtravel.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PermisosVendedorId implements Serializable {
    private static final long serialVersionUID = -2494838609584491371L;
    @Column(name = "Rol_id", nullable = false)
    private Integer rolId;
    @Column(name = "Vendedor_NIT", nullable = false)
    private Long vendedorNit;

    public Long getVendedorNit() {
        return vendedorNit;
    }

    public void setVendedorNit(Long vendedorNit) {
        this.vendedorNit = vendedorNit;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rolId, vendedorNit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PermisosVendedorId entity = (PermisosVendedorId) o;
        return Objects.equals(this.rolId, entity.rolId) &&
                Objects.equals(this.vendedorNit, entity.vendedorNit);
    }
}