package com.correotp;

import java.util.ArrayList;
import java.util.List;

public class FiltroContenido {
    public List<Email> filtrarPorContenido(List<Email> emails, String palabraClave) {
         // Lista para almacenar los correos electrónicos que cumplen con el criterio
        List<Email> correosFiltrados = new ArrayList<>();

        for (Email email : emails) {
            if (email.getContenido().contains(palabraClave)) { // Verifica si el contenido del correo electrónico actual contiene la palabra clave especificada.
                correosFiltrados.add(email); // Si la palabra clave está presente en el contenido, agrega este correo a la lista de correos filtrados.
            }
        }
        return correosFiltrados;
    }
}
