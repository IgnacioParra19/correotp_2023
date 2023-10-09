package com.correotp;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear usuarios
        Contacto alice = new Contacto("Alice Smith", "alice@example.com");
        Contacto bob = new Contacto("Bob Johnson", "bob@example.com");
        Contacto carol = new Contacto("Carol Brown", "carol@example.com");

        // Agregar usuarios al sistema de MailManager
        MailManager mailManager = new MailManager();
        mailManager.agregarUsuario(alice);
        mailManager.agregarUsuario(bob);
        mailManager.agregarUsuario(carol);

        // Enviar un correo de Alice a Bob y Carol
        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(bob);
        destinatarios.add(carol);
        String asunto = "Prueba de correo";
        String contenido = "Este es un correo de prueba.";

        mailManager.enviarCorreo(alice, destinatarios, asunto, contenido);

        // Verificar que el correo esté en la bandeja de entrada de Bob y Carol
        List<Email> bandejaEntradaBob = bob.getBandejaEntrada().getEmailsRecibidos();
        List<Email> bandejaEntradaCarol = carol.getBandejaEntrada().getEmailsRecibidos();

        System.out.println("Bandeja de entrada de Bob:");
        for (Email correo : bandejaEntradaBob) {
            System.out.println("Asunto: " + correo.getAsunto());
            System.out.println("Contenido: " + correo.getContenido());
        }

        System.out.println("Bandeja de entrada de Carol:");
        for (Email correo : bandejaEntradaCarol) {
            System.out.println("Asunto: " + correo.getAsunto());
            System.out.println("Contenido: " + correo.getContenido());
        }

        // Verificar que el correo esté en la bandeja de salida de Alice
        List<Email> bandejaSalidaAlice = alice.getBandejaSalida().getEmailsEnviados();

        System.out.println("Bandeja de salida de Alice:");
        for (Email correo : bandejaSalidaAlice) {
            System.out.println("Asunto: " + correo.getAsunto());
            System.out.println("Contenido: " + correo.getContenido());
        }
    }
}
