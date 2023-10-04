import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.correotp.Contacto;
import com.correotp.Email;

public class TestEmail {
        @Test
    public void testConstructorAndGetters() {
        Contacto remitente = new Contacto("John Doe", "john@example.com");
        List<Contacto> para = new ArrayList<>();
        para.add(new Contacto("Alice Smith", "alice@example.com"));
        para.add(new Contacto("Bob Johnson", "bob@example.com"));
        
        Email email = new Email("Prueba", "Este es el contenido de prueba", remitente, para);

        assertNotNull(email);
        assertEquals("Prueba", email.getAsunto());
        assertEquals("Este es el contenido de prueba", email.getContenido());
        assertEquals(remitente, email.getRemitente());
        assertEquals(para, email.getPara());
    }
@Test
    public void testSetters() {
        Email email = new Email("Prueba", "Este es el contenido de prueba", null, null);

        email.setAsunto("Nuevo asunto");
        email.setContenido("Nuevo contenido");
        Contacto remitente = new Contacto("John Doe", "john@example.com");
        email.setRemitente(remitente);
        List<Contacto> para = new ArrayList<>();
        para.add(new Contacto("Alice Smith", "alice@example.com"));
        para.add(new Contacto("Bob Johnson", "bob@example.com"));
        email.setPara(para);

        assertEquals("Nuevo asunto", email.getAsunto());
        assertEquals("Nuevo contenido", email.getContenido());
        assertEquals(remitente, email.getRemitente());
        assertEquals(para, email.getPara());
    }
}
