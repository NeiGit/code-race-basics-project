package ejercicios.clase3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScientificCalculatorTest {

    @Test
    @DisplayName("power | ok")
    void powerOk() {
        final ScientificCalculator calculator1 = new ScientificCalculator(3, 4);
        final ScientificCalculator calculator2 = new ScientificCalculator(2, 3);

        assertEquals(81, calculator1.power());
        assertEquals(8, calculator2.power());
    }

    @Test
    @DisplayName("root | ok")
    void rootOk() {
        final ScientificCalculator calculator1 = new ScientificCalculator(4, 2);
        final ScientificCalculator calculator2 = new ScientificCalculator(27, 3);
        final ScientificCalculator calculator3 = new ScientificCalculator(2, 2);

        final double root3RoundTwoDecimals = Double.parseDouble(String.valueOf(calculator3.root()).substring(0, 4));

        assertEquals(2, calculator1.root());
        assertEquals(3, calculator2.root());
        assertEquals(1.42, root3RoundTwoDecimals);
    }

    @Test
    @DisplayName("root of negative number | ok")
    void rootNegativeOk() {
        final ScientificCalculator calculator1 = new ScientificCalculator(-4, 2);

        assertEquals(0, calculator1.root());
    }

    @Test
    @DisplayName("round up | ok")
    void divideRoundUp() {
        final ScientificCalculator calculator1 = new ScientificCalculator(5, 3, 1);

        assertEquals(1.67, calculator1.divide());
    }

    @Test
    @DisplayName("round down | ok")
    void divideRoundDown() {
        final ScientificCalculator calculator1 = new ScientificCalculator(10.198, 2, 2);

        assertEquals(5.09, calculator1.divide());
    }

    @Test
    @DisplayName("round half up | ok")
    void divideRoundHalfUp() {
        final ScientificCalculator calculator1 = new ScientificCalculator(1.633, 2, 3);
        final ScientificCalculator calculator2 = new ScientificCalculator(6.194, 2, 3);

        assertEquals(3.27, calculator1.multiply());
        assertEquals(8.19, calculator2.sum());
    }
}
