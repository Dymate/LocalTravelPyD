package com.api.localtravel.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PermisosCompradorId implements Serializable {
    private static final long serialVersionUID = -7519713742895521764L;
    @Column(name = "Comprador_documento", nullable = false)
    private Long compradorDocumento;
    @Column(name = "Rol_id", nullable = false)
    private Integer rolId;

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public Long getCompradorDocumento() {
        return compradorDocumento;
    }

    public void setCompradorDocumento(Long compradorDocumento) {
        this.compradorDocumento = compradorDocumento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rolId, compradorDocumento);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PermisosCompradorId entity = (PermisosCompradorId) o;
        return Objects.equals(this.rolId, entity.rolId) &&
                Objects.equals(this.compradorDocumento, entity.compradorDocumento);
    }
}