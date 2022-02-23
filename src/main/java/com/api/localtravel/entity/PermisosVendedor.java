package com.api.localtravel.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Table(name = "permisos_vendedor", indexes = {
        @Index(name = "fk_Rol_has_Vendedor_Vendedor1_idx", columnList = "Vendedor_NIT"),
        @Index(name = "fk_Rol_has_Vendedor_Rol1_idx", columnList = "Rol_id")
})
@Entity
public class PermisosVendedor {
    @EmbeddedId
    private PermisosVendedorId id;

    public PermisosVendedorId getId() {
        return id;
    }

    public void setId(PermisosVendedorId id) {
        this.id = id;
    }
}