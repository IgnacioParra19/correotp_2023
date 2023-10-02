package com.correotp;

import java.util.ArrayList;
import java.util.List;

public class Email {
    private String asunto;
    private String contenido;
    private Contacto remitente;
    private List<Contacto> para = new ArrayList<>();

    public Email(String asunto, String contenido, Contacto remitente, List<Contacto> para) {
        this.asunto = asunto;
        this.contenido = contenido;
        this.remitente = remitente;
        this.para = para;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Contacto getRemitente() {
        return remitente;
    }

    public void setRemitente(Contacto remitente) {
        this.remitente = remitente;
    }

    public List<Contacto> getPara() {
        return para;
    }

    public void setPara(List<Contacto> para) {
        this.para = para;
    }
}
