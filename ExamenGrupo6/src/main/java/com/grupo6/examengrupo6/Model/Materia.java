package com.grupo6.examengrupo6.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "materia", schema = "materia_espe")
public class Materia {

    @Id
    @Column(name = "MATERIA_ID", nullable = false)
    private Integer id;

    @Column(name = "NOMBRE_MATERIA", length = 45)
    private String nombreMateria;

    @Column(name = "CRED_MATERIA")
    private Integer credMateria;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DEPARTAMENTO_ID", nullable = false)
    private Departamento departamento;

    @Column(name = "NIVEL", nullable = false, length = 45)
    private String nivel;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CARRERA_ID", nullable = false)
    private Carrera carrera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCENTE_ID")
    private Docente docente;

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public Integer getCredMateria() {
        return credMateria;
    }

    public void setCredMateria(Integer credMateria) {
        this.credMateria = credMateria;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
}
