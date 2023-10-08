package com.correotp;

import java.util.ArrayList;
import java.util.List;

public class FiltroContenido {
    public List<Email> filtrarPorContenido(List<Email> emails, String palabraClave) {
        List<Email> correosFiltrados = new ArrayList<>();

        for (Email email : emails) {
            if (email.getContenido().contains(palabraClave)) {
                correosFiltrados.add(email);
            }
        }
        return correosFiltrados;
    }
}
