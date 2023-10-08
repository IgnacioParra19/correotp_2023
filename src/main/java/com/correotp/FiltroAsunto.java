package com.correotp;

import java.util.ArrayList;
import java.util.List;

public class FiltroAsunto {
    
    public List<Email> filtrarPorAsuntoPalabraClave(List<Email> emails, String palabraClave) {
        List<Email> correosFiltrados = new ArrayList<>();

        for (Email email : emails) {
            if (email.getAsunto().contains(palabraClave)) {
                correosFiltrados.add(email);
            }
        }

        return correosFiltrados;
    }
}
