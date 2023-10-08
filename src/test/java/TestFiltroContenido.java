import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.correotp.Contacto;
import com.correotp.Email;
import com.correotp.FiltroContenido;

public class TestFiltroContenido {
        @Test
    public void testFiltrarPorPalabraClave() {
        // Crear una lista de correos electrónicos
        List<Email> emails = new ArrayList<>();

        // Agregar correos a la lista
        Contacto remitente1 = new Contacto("John Doe", "john@example.com");
        Email email1 = new Email("Correo 1", "Contenido con evaluacion", remitente1, null);
        emails.add(email1);

        Contacto remitente2 = new Contacto("Jane Smith", "jane@example.com");
        Email email2 = new Email("Correo 2", "Contenido sin palabra clave", remitente2, null);
        emails.add(email2);

        Contacto remitente3 = new Contacto("Alice Smith", "alice@example.com");
        Email email3 = new Email("Correo 3", "Otro contenido con evaluacion", remitente3, null);
        emails.add(email3);

        // Crear una instancia del filtro
        FiltroContenido filtro = new FiltroContenido();

        // Filtrar los correos que contienen la palabra clave "evaluacion"
        String palabraClave = "evaluacion";
        List<Email> correosFiltrados = filtro.filtrarPorContenido(emails, palabraClave);

        // Verificar que solo se obtengan los correos con la palabra clave en el contenido
        assertEquals(2, correosFiltrados.size());
        assertEquals("Correo 1", correosFiltrados.get(0).getAsunto());
        assertEquals("Correo 3", correosFiltrados.get(1).getAsunto());
    }
}
