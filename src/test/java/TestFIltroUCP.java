import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.correotp.Email;
import com.correotp.FiltroUCP;

public class TestFIltroUCP {

    @Test
    public void testFiltrarPorUCP() {
        // Crear una lista de correos electrónicos
        List<Email> emails = new ArrayList<>();

        // Agregar correos a la lista
        Email email1 = new Email("UCP", "Contenido con UCP", null, null);
        Email email2 = new Email("Correo 2", "Contenido sin UCP", null, null);
        Email email3 = new Email("UCP", "Contenido con Universidad de la Cuenca del Plata", null, null);
        emails.add(email1);
        emails.add(email2);
        emails.add(email3);

        // Crear una instancia del filtro
        FiltroUCP filtro = new FiltroUCP();

        // Filtrar los correos relacionados con UCP
        List<Email> correosFiltrados = filtro.filtrarPorUCP(emails);

        // Verificar que solo se obtengan los correos que contienen UCP
        assertEquals(3, correosFiltrados.size());
        assertEquals("UCP", correosFiltrados.get(0).getAsunto());
        assertNotEquals("UCP", correosFiltrados.get(1).getAsunto());
        assertEquals("UCP", correosFiltrados.get(2).getAsunto());

    }
}
