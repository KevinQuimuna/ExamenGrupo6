package com.grupo6.examengrupo6.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "inscripcion", schema = "materia_espe")
public class Inscripcion {
    @Id
    @Column(name = "INSCRIPCION_ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MATERIA_ID")
    private Materia materia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USUARIO_ID")
    private Usuario usuario;

    @Column(name = "INSCRIPCION_DATE")
    private LocalDate inscripcionDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getInscripcionDate() {
        return inscripcionDate;
    }

    public void setInscripcionDate(LocalDate inscripcionDate) {
        this.inscripcionDate = inscripcionDate;
    }

}