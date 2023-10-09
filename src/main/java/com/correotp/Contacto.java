package com.correotp;

public class Contacto {
    private String nombre;
    private String email;
    private BandejaEntrada bandejaEntrada;
    private BandejaSalida bandejaSalida;

    public Contacto(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.bandejaEntrada = new BandejaEntrada();
        this.bandejaSalida = new BandejaSalida();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BandejaEntrada getBandejaEntrada() {
        return bandejaEntrada;
    }

    public BandejaSalida getBandejaSalida() {
        return bandejaSalida;
    }

    public void setBandejaEntrada(BandejaEntrada bandejaEntrada) {
        this.bandejaEntrada = bandejaEntrada;
    }

    public void setBandejaSalida(BandejaSalida bandejaSalida) {
        this.bandejaSalida = bandejaSalida;
    }
    public boolean equalsPorNombre(Contacto otro) {
        return this.nombre.equals(otro.nombre);
    }
}
