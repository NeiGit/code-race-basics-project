import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConsoleOutputTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    protected void assertConsoleOutput(String ... expectedOutputs) {
        final String output = outputStreamCaptor.toString();

        for (String expectedOutput : expectedOutputs) {
            assertTrue(output.contains(expectedOutput));
        }
    }

    protected void assertConsoleDidNotOutput(String ... expectedOutputs) {
        final String output = outputStreamCaptor.toString();

        for (String expectedOutput : expectedOutputs) {
            assertFalse(output.contains(expectedOutput));
        }
    }

    protected void clearConsole() {
        outputStreamCaptor.reset();
    }
}
