package com.correotp;

import java.util.ArrayList;
import java.util.List;

public class FiltroDestinatario {

    public List<Email> filtrarPorDestinatario(List<Email> emails, Contacto destinatario) {
        List<Email> correosFiltrados = new ArrayList<>();

        for (Email email : emails) {
            List<Contacto> destinatarios = email.getPara();
            if (destinatarios != null && destinatarios.contains(destinatario)) {
                correosFiltrados.add(email);
            }
        }

        return correosFiltrados;
    }
}
