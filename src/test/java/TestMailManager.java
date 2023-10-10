import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.correotp.Contacto;
import com.correotp.Email;
import com.correotp.MailManager;

public class TestMailManager {
    
    @Test
    public void testEnviarCorreo() {
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

        assertEquals(1, bandejaEntradaBob.size());
        assertEquals(1, bandejaEntradaCarol.size());

        Email correoRecibidoBob = bandejaEntradaBob.get(0);
        Email correoRecibidoCarol = bandejaEntradaCarol.get(0);

        assertEquals(asunto, correoRecibidoBob.getAsunto());
        assertEquals(asunto, correoRecibidoCarol.getAsunto());
        assertEquals(contenido, correoRecibidoBob.getContenido());
        assertEquals(contenido, correoRecibidoCarol.getContenido());

        // Verificar que el correo esté en la bandeja de salida de Alice
        List<Email> bandejaSalidaAlice = alice.getBandejaSalida().getEmailsEnviados();
        assertEquals(1, bandejaSalidaAlice.size());

        Email correoEnviadoAlice = bandejaSalidaAlice.get(0);

        assertEquals(asunto, correoEnviadoAlice.getAsunto());
        assertEquals(contenido, correoEnviadoAlice.getContenido());
        assertEquals(bob, correoEnviadoAlice.getPara().get(0));
        assertEquals(carol, correoEnviadoAlice.getPara().get(1));
    }
    @Test
    public void testEnvioDe100CorreosYRecepcion() {
        // Crear usuarios
        Contacto remitente = new Contacto("Alice Smith", "alice@example.com");
        Contacto destinatario = new Contacto("Bob Johnson", "bob@example.com");
        
        // Agregar usuarios al sistema de MailManager
        MailManager mailManager = new MailManager();
        mailManager.agregarUsuario(remitente);
        mailManager.agregarUsuario(destinatario);
        
        // Crear lista de destinatarios
        List<Contacto> para = new ArrayList<>();
        para.add(destinatario);
        
        // Enviar 100 correos de Alice a Bob
        for (int i = 0; i < 100; i++) {
            String asunto = "Correo #" + i;
            String contenido = "Contenido del correo #" + i;
            
            // Enviar el correo
            mailManager.enviarCorreo(remitente, para, asunto, contenido);
        }
        
        // Verificar que Bob haya recibido los 100 correos
        List<Email> bandejaEntradaBob = destinatario.getBandejaEntrada().getEmailsRecibidos();
        assertEquals(100, bandejaEntradaBob.size()); // Bob debería tener 100 correos en su bandeja de entrada
    }
}
