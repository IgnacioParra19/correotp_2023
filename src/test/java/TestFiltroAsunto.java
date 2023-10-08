import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.correotp.Contacto;
import com.correotp.Email;
import com.correotp.FiltroAsunto;

public class TestFiltroAsunto {
    @Test
    public void testFiltrarPorPalabraClave() {
        // Crear una lista de correos electrónicos
        List<Email> emails = new ArrayList<>();

        // Agregar correos a la lista
        Contacto remitente1 = new Contacto("John Doe", "john@example.com");
        Email email1 = new Email("Correo 1 con palabra clave", "Contenido 1", remitente1, null);
        emails.add(email1);

        Contacto remitente2 = new Contacto("Jane Smith", "jane@example.com");
        Email email2 = new Email("Correo 2", "Contenido 2", remitente2, null);
        emails.add(email2);

        Contacto remitente3 = new Contacto("Alice Smith", "alice@example.com");
        Email email3 = new Email("Correo 3 con palabra clave", "Contenido 3", remitente3, null);
        emails.add(email3);
        
        FiltroAsunto filtro = new FiltroAsunto();

        // Filtrar los correos que contienen la palabra clave "palabra clave"
        String palabraClave = "palabra clave";
        List<Email> correosFiltrados = filtro.filtrarPorAsuntoPalabraClave(emails, palabraClave);

        // Verificar que solo se obtengan los correos con la palabra clave en el asunto
        assertEquals(2, correosFiltrados.size());
        assertEquals("Correo 1 con palabra clave", correosFiltrados.get(0).getAsunto());
        assertEquals("Correo 3 con palabra clave", correosFiltrados.get(1).getAsunto());
    }
}
