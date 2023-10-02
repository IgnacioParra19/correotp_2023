package com.correotp;

public class Contacto {
    private String nombre;
    private String email;

    public Contacto(String nombre, String email){
        this.nombre = nombre;
        this.email = email;
    }
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
