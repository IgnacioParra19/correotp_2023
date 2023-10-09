package com.correotp;

import java.util.ArrayList;
import java.util.List;

public class FiltroDestinatario {

    public List<Email> filtrarPorDestinatario(List<Email> emails, Contacto destinatario) {
        List<Email> correosFiltrados = new ArrayList<>();

        for (Email email : emails) {
            // Obtiene la lista de destinatarios del correo electrónico actual.
            List<Contacto> destinatarios = email.getPara();
            // Verifica si la lista de destinatarios no es nula y contiene el contacto 'destinatario' especificado.
            if (destinatarios != null && destinatarios.contains(destinatario)) {
                correosFiltrados.add(email); // Si el destinatario se encuentra en la lista de destinatarios, agrega este correo a la lista de correos filtrados.
            }
        }

        return correosFiltrados;
    }
}
