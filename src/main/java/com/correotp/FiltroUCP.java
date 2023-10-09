package com.correotp;

import java.util.ArrayList;
import java.util.List;

public class FiltroUCP {

    public List<Email> filtrarPorUCP(List<Email> emails) {
        List<Email> correosFiltrados = new ArrayList<>();


    for (Email email : emails) {
    // Verifica si el correo electrónico actual contiene la palabra clave "UCP"
        if (contieneUCP(email)){
        // se agrega este correo a la lista de correos filtrados si posee la palabra clave
            correosFiltrados.add(email);
    }
}


        return correosFiltrados;
    }

    private boolean contieneUCP(Email email) {
        String asunto = email.getAsunto();
        String contenido = email.getContenido();

        // Verificar si el asunto o el contenido contienen "UCP"
        return asunto.contains("UCP") || contenido.contains("UCP");
    }
}
