import ejercicios.ExampleExerciseBundle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExampleExerciseBundleTest extends ConsoleOutputTest {

    @Test
    @DisplayName("exercise1 | ok")
    void exercise1() {
        final int expectedAge = 15;

        ExampleExerciseBundle.exercise1(expectedAge);

        assertConsoleOutput("Tiene " + expectedAge + " años");
    }

    @Test
    @DisplayName("exercise2 | ok")
    void exercise2() {
        final String expectedName = "Nei";

        ExampleExerciseBundle.exercise2(expectedName);

        assertConsoleOutput("Su nombre es " + expectedName);
    }

}