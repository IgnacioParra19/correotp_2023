import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.correotp.BandejaSalida;
import com.correotp.Contacto;
import com.correotp.Email;

public class TestBandejaSalida {

    @Test
    public void testAgregarEmailEnviados() {
        BandejaSalida bandeja = new BandejaSalida();
        
        // Crear un correo para agregar a la bandeja
        Contacto remitente = new Contacto("John Doe", "john@example.com");
        List<Contacto> para = new ArrayList<>();
        para.add(new Contacto("Alice Smith", "alice@example.com"));
        Email email = new Email("Prueba", "Este es el contenido de prueba", remitente, para);

        bandeja.agregarEmailEnviados(email);

        assertTrue(bandeja.getEmailsEnviados().contains(email));
    }

    @Test
    public void testSetEmailsEnviados() {
        BandejaSalida bandeja = new BandejaSalida();

        // Crear una lista de correos para establecer en la bandeja
        List<Email> listaCorreos = new ArrayList<>();
        Contacto remitente1 = new Contacto("John Doe", "john@example.com");
        List<Contacto> para1 = new ArrayList<>();
        para1.add(new Contacto("Alice Smith", "alice@example.com"));
        Email email1 = new Email("Prueba 1", "Contenido 1", remitente1, para1);
        listaCorreos.add(email1);

        Contacto remitente2 = new Contacto("Jane Smith", "jane@example.com");
        List<Contacto> para2 = new ArrayList<>();
        para2.add(new Contacto("Bob Johnson", "bob@example.com"));
        Email email2 = new Email("Prueba 2", "Contenido 2", remitente2, para2);
        listaCorreos.add(email2);

        bandeja.setEmailsEnviados(listaCorreos);

        assertTrue(bandeja.getEmailsEnviados().contains(email1));
        assertTrue(bandeja.getEmailsEnviados().contains(email2));
    }
}
