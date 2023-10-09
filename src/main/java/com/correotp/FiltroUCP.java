package com.correotp;

import java.util.ArrayList;
import java.util.List;

public class FiltroUCP {

    public List<Email> filtrarPorUCP(List<Email> emails) {
        List<Email> correosFiltrados = new ArrayList<>();

        for (Email email : emails) {
            if (contieneUCP(email)) {
                correosFiltrados.add(email);
            }
        }

        return correosFiltrados;
    }

    private boolean contieneUCP(Email email) {
        String asunto = email.getAsunto();
        String contenido = email.getContenido();

        // Verificar si el asunto o el contenido contienen "Universidad de la Cuenca del Plata" o "UCP"
        return asunto.contains("Universidad de la Cuenca del Plata") || asunto.contains("UCP")
                || contenido.contains("Universidad de la Cuenca del Plata") || contenido.contains("UCP");
    }
}
