import static org.junit.Assert.*;

import org.junit.Test;

import com.correotp.Contacto;

public class TestContacto {
    @Test
    public void testConstructorAndGetters() {
        Contacto contacto = new Contacto("John Doe", "john@example.com");

        assertNotNull(contacto);
        assertEquals("John Doe", contacto.getNombre());
        assertEquals("john@example.com", contacto.getEmail());
    }

    @Test
    public void testSetters() {
        Contacto contacto = new Contacto("John Doe", "john@example.com");

        contacto.setNombre("Jane Smith");
        contacto.setEmail("jane@example.com");

        assertEquals("Jane Smith", contacto.getNombre());
        assertEquals("jane@example.com", contacto.getEmail());
    }
    @Test
    public void testEqualsPorNombre() {
        // Crear dos contactos con el mismo nombre
        Contacto contacto1 = new Contacto("John Doe", "john@example.com");
        Contacto contacto2 = new Contacto("John Doe", "johndoe@example.com");

        // Comparar los contactos por nombre
        assertTrue(contacto1.equalsPorNombre(contacto2));

        // Crear dos contactos con nombres diferentes
        Contacto contacto3 = new Contacto("Alice Smith", "alice@example.com");
        Contacto contacto4 = new Contacto("Bob Johnson", "bob@example.com");

        // Comparar los contactos por nombre
        assertTrue(!contacto3.equalsPorNombre(contacto4));
    }
}
