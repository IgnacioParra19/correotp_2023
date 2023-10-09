import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.correotp.Contacto;
import com.correotp.Email;
import com.correotp.FiltroDestinatario;

public class TestFiltroDestinatario {

    @Test
    public void testFiltrarCorreosPorDestinatario() {
        // Crear varios contactos para pruebas
        Contacto alice = new Contacto("Alice Smith", "alice@example.com");
        Contacto bob = new Contacto("Bob Johnson", "bob@example.com");
        Contacto carol = new Contacto("Carol Brown", "carol@example.com");
        Contacto david = new Contacto("David Lee", "david@example.com");

        // Crear correos con diferentes remitentes y destinatarios
        List<Contacto> destinatarios1 = new ArrayList<>();
        destinatarios1.add(bob);
        List<Contacto> destinatarios2 = new ArrayList<>();
        destinatarios2.add(alice);
        List<Contacto> destinatarios3 = new ArrayList<>();
        destinatarios3.add(alice);
        destinatarios3.add(bob);
        List<Contacto> destinatarios4 = new ArrayList<>();
        destinatarios4.add(carol);
        destinatarios4.add(bob);
        List<Contacto> destinatarios5 = new ArrayList<>();
        destinatarios5.add(carol);

        Email correo1 = new Email("Asunto 1", "Contenido 1", alice, destinatarios1);
        Email correo2 = new Email("Asunto 2", "Contenido 2", bob, destinatarios2);
        Email correo3 = new Email("Asunto 3", "Contenido 3", carol, destinatarios3);
        Email correo4 = new Email("Asunto 4", "Contenido 4", david, destinatarios4);
        Email correo5 = new Email("Asunto 5", "Contenido 5", bob, destinatarios5);

        // Crear un filtro de destinatario
        FiltroDestinatario filtro = new FiltroDestinatario();

        // Filtrar correos por destinatario "Alice"
        List<Email> correosFiltradosAlice = filtro.filtrarPorDestinatario(
            crearListaCorreos(correo1, correo2, correo3, correo4, correo5), alice);

        // Filtrar correos por destinatario "Bob"
        List<Email> correosFiltradosBob = filtro.filtrarPorDestinatario(
            crearListaCorreos(correo1, correo2, correo3, correo4, correo5), bob);

        // Verificar que los correos filtrados contengan al destinatario correspondiente
        for (Email correo : correosFiltradosAlice) {
            assertTrue(correo.getPara().contains(alice));
        }

        for (Email correo : correosFiltradosBob) {
            assertTrue(correo.getPara().contains(bob));
        }

        // Verificar que la cantidad de correos filtrados sea la esperada
        assertEquals(2, correosFiltradosAlice.size());
        assertEquals(3, correosFiltradosBob.size());
    }

    // Método auxiliar para crear una lista de correos
    private List<Email> crearListaCorreos(Email... correos) {
        List<Email> lista = new ArrayList<>();
        for (Email correo : correos) {
            lista.add(correo);
        }
        return lista;
    }
    }





