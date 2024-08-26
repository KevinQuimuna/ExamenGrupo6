package com.grupo6.examengrupo6.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "carrera", schema = "materia_espe")
public class Carrera {

    @Id
    @Column(name = "CARRERA_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carreraId;

    @Column(name = "NOMBRE_CARRERA", length = 45)
    private String nombreCarrera;

    @Column(name = "NUM_NIVEL")
    private Integer numNivel;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DEPARTAMENTO_ID", nullable = false, referencedColumnName = "DEPARTAMENTO_ID")
    private Departamento departamento;

    // Getters y Setters
    public Integer getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(Integer carreraId) {
        this.carreraId = carreraId;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public Integer getNumNivel() {
        return numNivel;
    }

    public void setNumNivel(Integer numNivel) {
        this.numNivel = numNivel;
    }

    public Departamento getDepartamento() {  // Getter corregido
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {  // Setter corregido
        this.departamento = departamento;
    }
}
