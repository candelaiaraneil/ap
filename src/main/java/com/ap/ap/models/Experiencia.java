package com.ap.ap.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long idExp;
    private String tituloExp;
    private int fechaExp;
    private String descExp;
    private String imagenExp;

    public Experiencia() {

    }

    public Experiencia(java.lang.Long idExp, java.lang.String tituloExp, int fechaExp, java.lang.String descExp, java.lang.String imagenExp) {
        this.idExp = idExp;
        this.tituloExp = tituloExp;
        this.fechaExp = fechaExp;
        this.descExp = descExp;
        this.imagenExp = imagenExp;
    }

    public java.lang.Long getIdExp() {
        return idExp;
    }

    public void setIdExp(java.lang.Long idExp) {
        this.idExp = idExp;
    }

    public java.lang.String getTituloExp() {
        return tituloExp;
    }

    public void setTituloExp(java.lang.String tituloExp) {
        this.tituloExp = tituloExp;
    }

    public int getFechaExp() {
        return fechaExp;
    }

    public void setFechaExp(int fechaExp) {
        this.fechaExp = fechaExp;
    }

    public java.lang.String getDescExp() {
        return descExp;
    }

    public void setDescExp(java.lang.String descExp) {
        this.descExp = descExp;
    }

    public java.lang.String getImagenExp() {
        return imagenExp;
    }

    public void setImagenExp(java.lang.String imagenExp) {
        this.imagenExp = imagenExp;
    }
}