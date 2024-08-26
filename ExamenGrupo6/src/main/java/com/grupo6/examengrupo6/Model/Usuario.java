package com.grupo6.examengrupo6.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario", schema = "materia_espe")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USUARIO_ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TIPO_ID", nullable = false)
    private Tipousuario tipo;

    @Column(name = "USER", length = 45)
    private String user;

    @Column(name = "PASS", length = 45)
    private String pass;

    @Column(name = "foto", length = 20)
    private String foto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tipousuario getTipo() {
        return tipo;
    }

    public void setTipo(Tipousuario tipo) {
        this.tipo = tipo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
