package com.grupo6.examengrupo6.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipousuario", schema = "materia_espe")
public class Tipousuario {
    @Id
    @Column(name = "TIPO_ID", nullable = false)
    private Integer id;

    @Column(name = "NOMBRE_TIPO", length = 45)
    private String nombreTipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }
}
