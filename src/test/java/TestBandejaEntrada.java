import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.correotp.BandejaEntrada;
import com.correotp.Contacto;
import com.correotp.Email;

public class TestBandejaEntrada {

    @Test
    public void testAgregarEmailRecibido() {
        // Crear una instancia de BandejaEntrada
        BandejaEntrada bandejaEntrada = new BandejaEntrada();

        // Crear un correo electrónico
        Contacto remitente = new Contacto("John Doe", "john@example.com");
        List<Contacto> para = new ArrayList<>();
        para.add(new Contacto("Alice Smith", "alice@example.com"));
        Email email = new Email("Correo 1", "Contenido 1", remitente, para);

        // Agregar el correo a la bandeja de entrada
        bandejaEntrada.agregarEmailRecibidos(email);

        // Verificar que el correo se haya agregado correctamente
        assertEquals(1, bandejaEntrada.getEmailsRecibidos().size());
        assertEquals("Correo 1", bandejaEntrada.getEmailsRecibidos().get(0).getAsunto());
    }


    @Test
    public void testAgregarEmailRecibidosConVariosCorreos() {
        BandejaEntrada bandeja = new BandejaEntrada();

        // Crear varios correos para agregar a la bandeja
        Contacto remitente1 = new Contacto("John Doe", "john@example.com");
        List<Contacto> para1 = new ArrayList<>();
        para1.add(new Contacto("Alice Smith", "alice@example.com"));
        Email email1 = new Email("Prueba 1", "Contenido 1", remitente1, para1);

        Contacto remitente2 = new Contacto("Jane Smith", "jane@example.com");
        List<Contacto> para2 = new ArrayList<>();
        para2.add(new Contacto("Bob Johnson", "bob@example.com"));
        Email email2 = new Email("Prueba 2", "Contenido 2", remitente2, para2);

        bandeja.agregarEmailRecibidos(email1);
        bandeja.agregarEmailRecibidos(email2);

        assertTrue(bandeja.getEmailsRecibidos().contains(email1));
        assertTrue(bandeja.getEmailsRecibidos().contains(email2));
    }

}
