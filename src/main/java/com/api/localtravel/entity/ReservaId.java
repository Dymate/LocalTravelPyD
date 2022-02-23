package com.api.localtravel.entity;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ReservaId implements Serializable {
    private static final long serialVersionUID = -8392438186157443967L;



    @Column(name = "Comprador_id", nullable = false)
    private Long compradorId;
    @Column(name = "Excursion_id", nullable = false)
    private Long excursionId;
    @Column(name = "Excursion_Vendedor_NIT", nullable = false)
    private Long excursionVendedorNit;

    public ReservaId() {

    }

    public Long getExcursionVendedorNit() {
        return excursionVendedorNit;
    }

    public void setExcursionVendedorNit(Long excursionVendedorNit) {
        this.excursionVendedorNit = excursionVendedorNit;
    }

    public Long getExcursionId() {
        return excursionId;
    }

    public void setExcursionId(Long excursionId) {
        this.excursionId = excursionId;
    }

    public Long getCompradorDocumento() {
        return compradorId;
    }

    public void setCompradorDocumento(Long compradorId) {
        this.compradorId = compradorId;
    }

    public ReservaId(Long compradorDocumento, Long excursionId, Long excursionVendedorNit) {
        this.compradorId = compradorDocumento;
        this.excursionId = excursionId;
        this.excursionVendedorNit = excursionVendedorNit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(excursionId, excursionVendedorNit, compradorId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ReservaId entity = (ReservaId) o;
        return Objects.equals(this.excursionId, entity.excursionId) &&
                Objects.equals(this.excursionVendedorNit, entity.excursionVendedorNit) &&
                Objects.equals(this.compradorId, entity.compradorId);
    }
}