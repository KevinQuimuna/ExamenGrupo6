package com.grupo6.examengrupo6.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "departamento", schema = "materia_espe")
public class Departamento {
    @Id
    @Column(name = "DEPARTAMENTO_ID", nullable = false)
    private Integer id;

    @Column(name = "NOMBRE_DEPARTAMENTO", nullable = false, length = 45)
    private String nombreDepartamento;

    @Column(name = "ACRO_DEPARTAMENTO", nullable = false, length = 4)
    private String acroDepartamento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getAcroDepartamento() {
        return acroDepartamento;
    }

    public void setAcroDepartamento(String acroDepartamento) {
        this.acroDepartamento = acroDepartamento;
    }

}