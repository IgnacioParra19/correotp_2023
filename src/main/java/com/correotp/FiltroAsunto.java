package com.correotp;

import java.util.ArrayList;
import java.util.List;

public class FiltroAsunto {
    
    public List<Email> filtrarPorAsuntoPalabraClave(List<Email> emails, String palabraClave) {
        List<Email> correosFiltrados = new ArrayList<>(); // Lista para almacenar los correos electrónicos que cumplen con el criterio

        for (Email email : emails) {
            if (email.getAsunto().contains(palabraClave)) { //Verifica si esta la palabra clave dentro del asunto de los correos
                correosFiltrados.add(email); // Agrega a la lista de correos filtrados si aparece la palabra clave dentro del asunto
            }
        }

        return correosFiltrados;
    }
}
