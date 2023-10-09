package com.correotp;

import java.util.ArrayList;
import java.util.List;

public class FiltroRemitente {

    public List<Email> filtrarPorRemitente(List<Email> emails, Contacto remitenteBuscado) {
        List<Email> correosFiltrados = new ArrayList<>();

        for (Email email : emails) {
            Contacto remitente = email.getRemitente(); // se obtiene la lista de los remitente
            if (remitente != null && remitente.equalsPorNombre(remitenteBuscado)) { //Veririca si la lista no es nula y contiene el remitente buscado
                correosFiltrados.add(email); // Si el remitente se encuentra en la lista de remitentess, agrega este correo a la lista de correos filtrados.
            }
        }
        return correosFiltrados;
    }
}

