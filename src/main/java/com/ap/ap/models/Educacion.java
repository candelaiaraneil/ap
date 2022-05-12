package com.ap.ap.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity

public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long idEdu;
    private String tituloEdu;
    private int fechaEdu;
    private String descEdu;
    private String imagenEdu;

    public Educacion() {
    }

    public Educacion(java.lang.Long idEdu, java.lang.String tituloEdu, int fechaEdu, java.lang.String descEdu, java.lang.String imagenEdu) {
        this.idEdu = idEdu;
        this.tituloEdu = tituloEdu;
        this.fechaEdu = fechaEdu;
        this.descEdu = descEdu;
        this.imagenEdu = imagenEdu;
    }

    public java.lang.Long getIdEdu() {
        return idEdu;
    }

    public void setIdEdu(java.lang.Long idEdu) {
        this.idEdu = idEdu;
    }

    public java.lang.String getTituloEdu() {
        return tituloEdu;
    }

    public void setTituloEdu(java.lang.String tituloEdu) {
        this.tituloEdu = tituloEdu;
    }

    public int getFechaEdu() {
        return fechaEdu;
    }

    public void setFechaEdu(int fechaEdu) {
        this.fechaEdu = fechaEdu;
    }

    public java.lang.String getDescEdu() {
        return descEdu;
    }

    public void setDescEdu(java.lang.String descEdu) {
        this.descEdu = descEdu;
    }

    public java.lang.String getImagenEdu() {
        return imagenEdu;
    }

    public void setImagenEdu(java.lang.String imagenEdu) {
        this.imagenEdu = imagenEdu;
    }
}
