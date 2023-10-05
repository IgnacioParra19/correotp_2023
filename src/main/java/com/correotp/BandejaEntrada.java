package com.correotp;

import java.util.ArrayList;
import java.util.List;

public class BandejaEntrada {
    private List<Email> emailsRecibidos = new ArrayList<>();

    public void agregarEmailEnviados(Email email){
        emailsRecibidos.add(email);
    }
    
    public List<Email> getEmailsRecibidos() {
        return emailsRecibidos;
    }

    public void setEmailsRecibidos(List<Email> emailsRecibidos) {
        this.emailsRecibidos = emailsRecibidos;
    }
    
}
