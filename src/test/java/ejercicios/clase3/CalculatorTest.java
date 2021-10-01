package ejercicios.clase3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    @DisplayName("sum | ok")
    void sum() {
        final Calculator calculator1 = new Calculator(2, 7);
        final Calculator calculator2 = new Calculator(-10, 4);

        assertEquals(9, calculator1.sum());
        assertEquals(-6, calculator2.sum());
    }

    @Test
    @DisplayName("subtract | ok")
    void subtract() {
        final Calculator calculator1 = new Calculator(2, 7);
        final Calculator calculator2 = new Calculator(-10, 4);

        assertEquals(-5, calculator1.subtract());
        assertEquals(-14, calculator2.subtract());
    }

    @Test
    @DisplayName("multiply | ok")
    void multiply() {
        final Calculator calculator1 = new Calculator(2, 7);
        final Calculator calculator2 = new Calculator(-10, -4);

        assertEquals(14, calculator1.multiply());
        assertEquals(40, calculator2.multiply());
    }

    @Test
    @DisplayName("divide | ok")
    void divide() {
        final Calculator calculator1 = new Calculator(2, 7);
        final Calculator calculator2 = new Calculator(-10, 4);

        final double divide1 = calculator1.divide();

        final double divide1RoundTwoDecimals = Double.parseDouble(String.valueOf(divide1).substring(0, 4));

        assertEquals(0.28, divide1RoundTwoDecimals);
        assertEquals(-2.5, calculator2.divide());
    }

    @Test
    @DisplayName("divide by zero | ok")
    void divideByZeroOk() {
        final Calculator calculator1 = new Calculator(2, 0);

        assertEquals(0, calculator1.divide());
    }
}