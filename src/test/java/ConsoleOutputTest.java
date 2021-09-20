import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import util.IOUtil;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

    protected void assertConsoleOutput(Object ... objects) {
        for (Object object : objects) {
            assertConsoleOutput(String.valueOf(object));
        }
    }

    protected void assertConsoleOutput(String ... expectedOutputs) {
        final String output = outputStreamCaptor.toString();

        IOUtil.print(output);
        for (String expectedOutput : expectedOutputs) {
            if (!output.contains(expectedOutput)) {
                throw new ConsoleOutputException(
                        String.format("Expected '%s' to be present in output but it was not! \nActual output was: \n%s", expectedOutput, output)
                );
            }
        }
    }

    protected void assertConsoleDidNotOutput(Object ... objects) {
        for (Object object : objects) {
            assertConsoleDidNotOutput(String.valueOf(object));
        }
    }

    protected void assertConsoleDidNotOutput(String ... unexpectedOutputs) {
        final String output = outputStreamCaptor.toString();

        for (String unexpectedOutput : unexpectedOutputs) {
            if (output.contains(unexpectedOutput)) {
                throw new ConsoleOutputException(
                        String.format("Expected '%s' to NOT be present in output but it was! \nActual output was: \n%s", unexpectedOutput, output)
                );
            }
        }
    }

    protected void clearConsole() {
        outputStreamCaptor.reset();
    }

    private static final class ConsoleOutputException extends RuntimeException {
        private ConsoleOutputException(String message) {
            super(message);
        }
    }
}
