package com.correotp;

import java.util.ArrayList;
import java.util.List;

public class FiltroRemitente {

    public List<Email> filtrarPorRemitente(List<Email> emails, Contacto remitente) {
        List<Email> correosFiltrados = new ArrayList<>();

        for (Email email : emails) {
            if (email.getRemitente().equals(remitente)) {
                correosFiltrados.add(email);
            }
        }

        return correosFiltrados;
    }
}