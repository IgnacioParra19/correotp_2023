package com.correotp;

import java.util.ArrayList;
import java.util.List;

public class MailManager {
    private List<Contacto> usuarios;

    public MailManager() {
        this.usuarios = new ArrayList<>();
    }

    
    public void agregarUsuario(Contacto usuario) {
        usuarios.add(usuario);
    }

    // Enviar un correo electrónico desde un usuario remitente a uno o varios destinatarios
    public void enviarCorreo(Contacto remitente, List<Contacto> destinatarios, String asunto, String contenido) {
        Email correo = new Email(asunto, contenido, remitente, destinatarios);

        // Guardar el correo en la bandeja de salida del remitente
        remitente.getBandejaSalida().agregarEmailEnviados(correo);

        // Agregar el correo a la bandeja de entrada de cada destinatario
        for (Contacto destinatario : destinatarios) {
            destinatario.getBandejaEntrada().agregarEmailRecibidos(correo);
        }
    }
}
