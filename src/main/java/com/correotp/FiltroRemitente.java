package com.correotp;

import java.util.ArrayList;
import java.util.List;

public class FiltroRemitente {

    public List<Email> filtrarPorRemitente(List<Email> emails, Contacto remitenteBuscado) {
        List<Email> correosFiltrados = new ArrayList<>();

        for (Email email : emails) {
            Contacto remitente = email.getRemitente();
            if (remitente != null && remitente.equalsPorNombre(remitenteBuscado)) {
                correosFiltrados.add(email);
            }
        }
        return correosFiltrados;
    }
}

