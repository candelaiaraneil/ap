package com.ap.ap.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSkill;
    private String nombreSkill;
    private String fotoSkill;
    private int porcentaje;

    public Skills() {
    }

    public Skills(java.lang.Long idSkill, java.lang.String nombreSkill, java.lang.String fotoSkill, int porcentaje) {
        this.idSkill = idSkill;
        this.nombreSkill = nombreSkill;
        this.fotoSkill = fotoSkill;
        this.porcentaje = porcentaje;
    }

    public java.lang.Long getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(java.lang.Long idSkill) {
        this.idSkill = idSkill;
    }

    public java.lang.String getNombreSkill() {
        return nombreSkill;
    }

    public void setNombreSkill(java.lang.String nombreSkill) {
        this.nombreSkill = nombreSkill;
    }

    public java.lang.String getFotoSkill() {
        return fotoSkill;
    }

    public void setFotoSkill(java.lang.String fotoSkill) {
        this.fotoSkill = fotoSkill;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
}
