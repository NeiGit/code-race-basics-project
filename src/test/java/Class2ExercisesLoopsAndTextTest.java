import ejercicios.Class2ExercisesLoopsAndText;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Class2ExercisesLoopsAndTextTest extends ConsoleOutputTest {

    @Test
    @DisplayName("showNextNOccurrencesOfNum | given 123 and 3 occurrences | should output 132 - 213 - 231")
    void showNextNOccurrencesOfNum2Case123() {
        Class2ExercisesLoopsAndText.showNextNOccurrencesOfNum(3, 123);

        assertConsoleOutput("132", "213", "231");
    }

    @Test
    @Disabled
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
    @DisplayName("exercise4 | true cases")
    void exercise4TrueCases() {
        assertTrue(Class2ExercisesLoopsAndText.exercise4(2, 4));
        assertTrue(Class2ExercisesLoopsAndText.exercise4(10, -8));
        assertTrue(Class2ExercisesLoopsAndText.exercise4(6, 6));
        assertTrue(Class2ExercisesLoopsAndText.exercise4(-56, -4860));
    }

    @Test
    @DisplayName("exercise4 | false cases")
    void exercise4FalseCases() {
        assertFalse(Class2ExercisesLoopsAndText.exercise4(1, 3));
        assertFalse(Class2ExercisesLoopsAndText.exercise4(4, 5));
        assertFalse(Class2ExercisesLoopsAndText.exercise4(3, 2));
        assertFalse(Class2ExercisesLoopsAndText.exercise4(-55, -4861));
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

    @Test
    @DisplayName("sortLongDigitsAscending | given 874396 | should return 346789")
    void sortLongDigitsAscending_given874396ShouldReturn346789() {
        assertEquals("346789", Class2ExercisesLoopsAndText.sortLongDigitsAscending(874396));
    }

    @Test
    @DisplayName("sortLongDigitsAscending | given 90847578 | should return 04577889")
    void sortLongDigitsAscending_given90847578ShouldReturn04577889() {
        assertEquals("04577889", Class2ExercisesLoopsAndText.sortLongDigitsAscending(90847578));
    }

    @Test
    @DisplayName("buildPicture | ok")
    void buildPictureOk() {
        // given
        final List<String> expectedResult = new ArrayList<>();
        expectedResult.add("1-4-a");
        expectedResult.add("2-3-a");
        expectedResult.add("3-2-a");
        expectedResult.add("4-1-a");
        expectedResult.add("5-0-a");

        final List<String> actualResult = new ArrayList<>();

        final Class2ExercisesLoopsAndText.TriConsumer consumer = (characters, dashes, character) -> {
            String line = characters + "-" + dashes + "-" + character;
            actualResult.add(line);
        };

        // when
        Class2ExercisesLoopsAndText.buildPicture(consumer, 5, "a");

        // then
        assertEquals(expectedResult, actualResult);
    }
}