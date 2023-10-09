import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.correotp.Contacto;
import com.correotp.Email;
import com.correotp.FiltroRemitente;

public class TestFiltroRemitente {
    
    @Test
    public void testCorreosEnviadosPorMismoRemitente() {
        // Crear un contacto
        Contacto remitente1 = new Contacto("John Doe", "john@example.com");

        // Crear correos enviados por el remitente1
        List<Email> correosEnviados1 = new ArrayList<>();
        correosEnviados1.add(new Email("Asunto 1", "Contenido 1", remitente1, new ArrayList<>()));
        correosEnviados1.add(new Email("Asunto 2", "Contenido 2", remitente1, new ArrayList<>()));
        correosEnviados1.add(new Email("Asunto 3", "Contenido 3", remitente1, new ArrayList<>()));

        // Configurar la bandeja de salida del contacto con los correos enviados por remitente1
        remitente1.getBandejaSalida().setEmailsEnviados(correosEnviados1);

        // Crear otro contacto
        Contacto remitente2 = new Contacto("Jane Smith", "jane@example.com");

        // Crear correos enviados por remitente2
        List<Email> correosEnviados2 = new ArrayList<>();
        correosEnviados2.add(new Email("Asunto 4", "Contenido 4", remitente2, new ArrayList<>()));
        correosEnviados2.add(new Email("Asunto 5", "Contenido 5", remitente2, new ArrayList<>()));
        correosEnviados2.add(new Email("Asunto 6", "Contenido 6", remitente2, new ArrayList<>()));

        // Configurar la bandeja de salida del contacto con los correos enviados por remitente2
        remitente2.getBandejaSalida().setEmailsEnviados(correosEnviados2);

        // Crear una lista de todos los correos enviados
        List<Email> todosLosCorreosEnviados = new ArrayList<>();
        todosLosCorreosEnviados.addAll(correosEnviados1);
        todosLosCorreosEnviados.addAll(correosEnviados2);

        // Crear un filtro para remitente1
        FiltroRemitente filtroRemitente1 = new FiltroRemitente();
        List<Email> correosFiltradosRemitente1 = filtroRemitente1.filtrarPorRemitente(todosLosCorreosEnviados, remitente1);

        // Crear un filtro para remitente2
        FiltroRemitente filtroRemitente2 = new FiltroRemitente();
        List<Email> correosFiltradosRemitente2 = filtroRemitente2.filtrarPorRemitente(todosLosCorreosEnviados, remitente2);

        // Verificar que los correos enviados sean del mismo remitente correspondiente
        for (Email correo : correosFiltradosRemitente1) {
            assertTrue(correo.getRemitente().equalsPorNombre(remitente1));
        }

        for (Email correo : correosFiltradosRemitente2) {
            assertTrue(correo.getRemitente().equalsPorNombre(remitente2));
        }
    }
}
