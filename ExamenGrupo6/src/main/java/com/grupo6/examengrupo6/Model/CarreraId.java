package com.grupo6.examengrupo6.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CarreraId implements Serializable {
    private static final long serialVersionUID = -8356076173638095220L;
    @Column(name = "CARRERA_ID", nullable = false)
    private Integer carreraId;

    @Column(name = "DEPARTAMENTO_ID", nullable = false)
    private Integer departamentoId;

    public Integer getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(Integer carreraId) {
        this.carreraId = carreraId;
    }

    public Integer getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Integer departamentoId) {
        this.departamentoId = departamentoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CarreraId entity = ( CarreraId ) o;
        return Objects.equals(this.carreraId, entity.carreraId) &&
                Objects.equals(this.departamentoId, entity.departamentoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carreraId, departamentoId);
    }

}