import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.correotp.Contacto;
import com.correotp.Email;
import com.correotp.FiltroDestinatario;

public class TestFiltroDestinatario {
    @Test
    public void testFiltrarPorDestinatario() {
        // Crear una lista de correos electrónicos
        List<Email> emails = new ArrayList<>();

        // Agregar correos a la lista
        Contacto remitente1 = new Contacto("John Doe", "john@example.com");
        List<Contacto> para1 = new ArrayList<>();
        para1.add(new Contacto("Alice Smith", "alice@example.com"));
        Email email1 = new Email("Correo 1", "Contenido 1", remitente1, para1);
        emails.add(email1);

        Contacto remitente2 = new Contacto("Jane Smith", "jane@example.com");
        List<Contacto> para2 = new ArrayList<>();
        para2.add(new Contacto("Bob Johnson", "bob@example.com"));
        Email email2 = new Email("Correo 2", "Contenido 2", remitente2, para2);
        emails.add(email2);

        Contacto remitente3 = new Contacto("Alice Smith", "alice@example.com");
        List<Contacto> para3 = new ArrayList<>();
        para3.add(new Contacto("John Doe", "john@example.com"));
        Email email3 = new Email("Correo 3", "Contenido 3", remitente3, para3);
        emails.add(email3);

        // Crear una instancia del filtro
        FiltroDestinatario filtro = new FiltroDestinatario();

        // Definir un destinatario para el filtro
        Contacto destinatario = new Contacto("Alice Smith", "alice@example.com");

        // Filtrar los correos que tienen a Alice Smith como destinatario
        List<Email> correosFiltrados = filtro.filtrarPorDestinatario(emails, destinatario);

        // Verificar que solo se obtengan los correos destinados a Alice Smith
        assertEquals(2, correosFiltrados.size());
        assertEquals("Alice Smith", correosFiltrados.get(0).getAsunto());
        assertEquals("Alice Smith", correosFiltrados.get(1).getAsunto());
    }
    }




