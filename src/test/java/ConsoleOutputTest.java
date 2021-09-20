import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

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
        doAssertConsoleOutput(false, objects);
    }

    protected void assertConsoleOutputExactly(Object ... objects) {
        doAssertConsoleOutput(true, objects);
    }

    protected void assertConsoleOutputNothing() {
        final String output = outputStreamCaptor.toString();

        if (!output.isEmpty()) {
            throw new ConsoleOutputException(
                    String.format("\nExpected output to contain nothing but it had elements. \n\nActual output was: \n%s", output));
        }
    }

    private void doAssertConsoleOutput(boolean exactly, Object ... expectedOutputs) {
        final String output = outputStreamCaptor.toString();
        String outputReplaceable = output.replace("\n", "");
        String expectedOutputsJoined = "";


        for (Object expectedOutput : expectedOutputs) {
            final String expectedString = String.valueOf(expectedOutput);

            if (!output.contains(expectedString)) {
                throw new ConsoleOutputException(
                        String.format("\nExpected '%s' to be present in output but it was not! \n\nActual output was: \n%s", expectedOutput, output)
                );
            }

            if (exactly) {
                expectedOutputsJoined += expectedOutput + " ";
                outputReplaceable = outputReplaceable.replaceFirst(expectedString, "");
            }
        }

        if (exactly && !outputReplaceable.isEmpty()) {
            throw new ConsoleOutputException(
                    String.format("\nExpected output to only contain '%s' but it had more elements. \n\nExtra elements: \n%s \n\nComplete output: \n%s",
                            expectedOutputsJoined.trim(), outputReplaceable, output));
        }
    }

    protected void assertConsoleDidNotOutput(Object ... unexpectedOutputs) {
        final String output = outputStreamCaptor.toString();

        for (Object unexpectedOutput : unexpectedOutputs) {
            final String unexpectedString = String.valueOf(unexpectedOutput);

            if (output.contains(unexpectedString)) {
                throw new ConsoleOutputException(
                        String.format("\nExpected '%s' to NOT be present in output but it was! \n\nActual output was: \n%s", unexpectedString, output)
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
