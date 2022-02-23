package com.api.localtravel.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Table(name = "permisos_comprador", indexes = {
        @Index(name = "fk_Comprador_has_Rol_Rol1_idx", columnList = "Rol_id"),
        @Index(name = "fk_Comprador_has_Rol_Comprador1_idx", columnList = "Comprador_documento")
})
@Entity
public class PermisosComprador {
    @EmbeddedId
    private PermisosCompradorId id;

    public PermisosCompradorId getId() {
        return id;
    }

    public void setId(PermisosCompradorId id) {
        this.id = id;
    }
}