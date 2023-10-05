package com.correotp;

import java.util.ArrayList;
import java.util.List;

public class BandejaSalida {
    private List<Email> emailsEnviados = new ArrayList<>();

    public void agregarEmailEnviados(Email email){
        emailsEnviados.add(email);
    }
    public List<Email> getEmailsEnviados() {
        return emailsEnviados;
    }

    public void setEmailsEnviados(List<Email> emailsEnviados) {
        this.emailsEnviados = emailsEnviados;
    }
}
