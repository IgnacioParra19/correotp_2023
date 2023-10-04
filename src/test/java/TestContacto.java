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
}
