import ejercicios.Class2ExercisesCollections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static ejercicios.Class2ExercisesCollections.Color;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class Class2ExercisesCollectionsTest extends ConsoleOutputTest {

    @Test
    @DisplayName("Color fromString | cases")
    void colorFromStringCases() {
        assertEquals(Color.BLUE, Color.fromString("blue"));
        assertEquals(Color.RED, Color.fromString("ReD"));
        assertEquals(Color.GREEN, Color.fromString("greeN"));
        assertEquals(Color.ORANGE, Color.fromString("ORANGE"));
        assertEquals(Color.BROWN, Color.fromString("Brown"));
        assertEquals(Color.YELLOW, Color.fromString("yellow"));
        assertEquals(Color.PURPLE, Color.fromString("purple"));

        assertNull(Color.fromString("not-a-color"));
    }

    @Test
    @DisplayName("exercise2 | case without negatives")
    void exercise2WithoutNegatives() {
        // given
        final List<Integer> numbers1 = new ArrayList<>();
        numbers1.add(5);
        numbers1.add(34);
        numbers1.add(1);
        numbers1.add(309);
        numbers1.add(20);

        final List<Integer> numbers2 = new ArrayList<>();
        numbers2.add(18);
        numbers2.add(100);
        numbers2.add(92);
        numbers2.add(7);
        numbers2.add(56);

        // when
        Class2ExercisesCollections.exercise2(numbers1, numbers2);

        // then
        assertConsoleOutput("1-100", "5-92", "20-56", "34-18", "309-7");
    }

    @Test
    @DisplayName("exercise2 | case with negatives | should filter negatives before sorting")
    void exercise2WithNegatives() {
        // given
        final List<Integer> numbers1 = new ArrayList<>();
        numbers1.add(5);
        numbers1.add(34);
        numbers1.add(1);
        numbers1.add(-309);
        numbers1.add(20);

        final List<Integer> numbers2 = new ArrayList<>();
        numbers2.add(18);
        numbers2.add(100);
        numbers2.add(92);
        numbers2.add(-7);
        numbers2.add(56);

        // when
        Class2ExercisesCollections.exercise2(numbers1, numbers2);

        // then
        assertConsoleOutput("1-100", "5-92", "20-56", "34-18");
    }

}