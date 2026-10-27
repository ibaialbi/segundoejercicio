import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void testMainInvalidArgs() {
        // Ahora probamos el método runLogic que devuelve el -1 en vez de cerrar Java
        int status = Main.runLogic(new String[]{});
        
        assertEquals(-1, status);
        assertEquals("Usage: $(COMMAND) [PATTERN]\n", outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    public void testMainValidInput() {
        String input = "cat\nbat\npattern\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        int status = Main.runLogic(new String[]{"?at"});
        
        assertEquals(0, status);
        assertEquals("1\n1\n0\n", outContent.toString().replace("\r\n", "\n"));
    }
}