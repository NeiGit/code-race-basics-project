import ejercicios.Class2ExercisesLoopsAndText;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Class2ExercisesLoopsAndTextTest extends ConsoleOutputTest {

    @Test
    @DisplayName("showNextNOccurrencesOfNum | given 123 and 3 occurrences | should output 132 - 213 - 231")
    void showNextNOccurrencesOfNum2Case123() {
        Class2ExercisesLoopsAndText.showNextNOccurrencesOfNum(3, 123);

        assertConsoleOutput("132", "213", "231");
    }

    @Test
    @DisplayName("showNextNOccurrencesOfNum | given 5006 and 2 occurrences | should output 5060 - 5600")
    void showNextNOccurrencesOfNum2Case5006() {
        Class2ExercisesLoopsAndText.showNextNOccurrencesOfNum(2, 5006);

        assertConsoleOutput("5060", "5600");
    }

    @Test
    @DisplayName("showNextNOccurrencesOfNum | given 24 and 5 occurrences | should output 42 - 24 - 42 - 24 - 42")
    void showNextNOccurrencesOfNum2() {
        Class2ExercisesLoopsAndText.showNextNOccurrencesOfNum(5, 24);

        assertConsoleOutput("42", "24", "42", "24", "42");
    }

    @Test
    @DisplayName("exercise6 | given Que no se trabe please | should return QNSTRBPLS")
    void exercise6Ok() {
        // given
        final String text = "Que no se trabe please";

        // when
        final String result = Class2ExercisesLoopsAndText.exercise6(text);

        // then
        assertEquals("QNSTRBPLS", result);
    }
}