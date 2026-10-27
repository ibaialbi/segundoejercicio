

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class GlobPatternTest {

    @Test
    public void testExactMatch() {
        // Arrange: Preparamos el patrón
        GlobPattern gp = new GlobPattern("cat");

        // Act & Assert: Comprobamos que "cat" coincide y "bat" falla
        assertTrue(gp.match("cat"));
        assertFalse(gp.match("bat"));
    }
}