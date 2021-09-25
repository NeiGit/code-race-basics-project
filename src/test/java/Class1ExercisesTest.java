import ejercicios.Class1Exercises;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Class1ExercisesTest extends ConsoleOutputTest {

    @Test
    @DisplayName("exercise1 | given 5 | should output true")
    void exercise1Case5() {
        Class1Exercises.exercise1(5);

        assertConsoleOutput(true);
    }

    @Test
    @DisplayName("exercise1 | given 10 | should output true")
    void exercise1Case10() {
        Class1Exercises.exercise1(10);

        assertConsoleOutput(true);
    }

    @Test
    @DisplayName("exercise1 | given -5 | should output nothing")
    void exercise1CaseMinus5() {
        Class1Exercises.exercise1(-5);

        assertConsoleOutputNothing();
    }
}