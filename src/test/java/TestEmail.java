import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.correotp.Contacto;
import com.correotp.Email;

public class TestEmail {

    @Test
    public void crearCorreo(){
        Email email1 = new Email(null, null, null, null);
        assertNotNull(email1);
    }

    @Test
    public void testGettersAndSetters() {
        // Crear objetos Contacto para usar en el constructor de Email
        Contacto remitente = new Contacto("Remitente", "remitente@example.com");
        Contacto destinatario1 = new Contacto("Destinatario1", "destinatario1@example.com");
        Contacto destinatario2 = new Contacto("Destinatario2", "destinatario2@example.com");

        // Crear una lista de destinatarios
        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(destinatario1);
        destinatarios.add(destinatario2);

        // Crear un objeto Email
        Email email = new Email("Asunto de prueba", "Contenido de prueba", remitente, destinatarios);

        // Verificar que los getters devuelvan los valores esperados
        assertEquals("Asunto de prueba", email.getAsunto());
        assertEquals("Contenido de prueba", email.getContenido());
        assertEquals(remitente, email.getRemitente());
        assertEquals(destinatarios, email.getPara());

        // Modificar los valores usando setters
        email.setAsunto("Nuevo asunto");
        email.setContenido("Nuevo contenido");
        Contacto nuevoRemitente = new Contacto("Nuevo Remitente", "nuevo_remitente@example.com");
        email.setRemitente(nuevoRemitente);

        // Verificar que los valores se hayan actualizado correctamente
        assertEquals("Nuevo asunto", email.getAsunto());
        assertEquals("Nuevo contenido", email.getContenido());
        assertEquals(nuevoRemitente, email.getRemitente());
    }
}