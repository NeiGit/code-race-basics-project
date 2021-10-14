package ejercicios.clase4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.IOUtil;

import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.objects.Global.Infinity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    @DisplayName("divide by zero | should return Infinity")
    void divideByZeroInfinity() {
        final ScientificCalculator calculator1 = new ScientificCalculator(2, 0, 2);

        assertEquals(Infinity, calculator1.divide());
    }

    @Test
    @DisplayName("round half up | ok")
    void divideRoundHalfUp() {
        final ScientificCalculator calculator1 = new ScientificCalculator(1.633, 2, 3);
        final ScientificCalculator calculator2 = new ScientificCalculator(6.194, 2, 3);

        assertEquals(3.27, calculator1.multiply());
        assertEquals(8.19, calculator2.sum());
    }


    @Test
    @DisplayName("round half up | ok")
    void divideRoundHalfUp2() {
        final Rounder rounder = HalfUpRounder.getInstance();

        final ScientificCalculator calculator1 = new ScientificCalculator(1.633, 2, rounder);
        final ScientificCalculator calculator2 = new ScientificCalculator(6.194, 2, rounder);

        assertEquals(3.27, calculator1.multiply());
        assertEquals(8.19, calculator2.sum());
    }

    @Test
    @DisplayName("round down | ok")
    void divideRoundDown2() {
        final Rounder rounder = DownRounder.getInstance();

        final ScientificCalculator calculator1 = new ScientificCalculator(10.198, 2, rounder);

        assertEquals(5.09, calculator1.divide());
    }

    @Test
    @DisplayName("round down | ok")
    void divideRoundDown3() {
        final Rounder rounder = DownRounder.getInstance();

        final ScientificCalculator calculator1 = new ScientificCalculator(10.198, 2, rounder);

        assertEquals(5.09, calculator1.divide());
    }

    @Test
    @DisplayName("fromRoundingMode | ok")
    void fromRoundingMode() {
        assertEquals(UpRounder.getInstance(), ScientificCalculator.fromRoundingMode(1));
        assertEquals(DownRounder.getInstance(), ScientificCalculator.fromRoundingMode(2));
        assertEquals(HalfUpRounder.getInstance(), ScientificCalculator.fromRoundingMode(3));

        assertThrows(RuntimeException.class, () -> ScientificCalculator.fromRoundingMode(-1));
    }

    @Test
    @DisplayName("test rounding modes for dividing 10 and 3")
    void divide10And3() {
        final List<ScientificCalculator> calculatorList = new ArrayList<>();

        final ScientificCalculator calc1 = new ScientificCalculator(10, 3, UpRounder.getInstance());
        final ScientificCalculator calc2 = new ScientificCalculator(10, 3, DownRounder.getInstance());
        final ScientificCalculator calc3 = new ScientificCalculator(10, 3, HalfUpRounder.getInstance());

        calculatorList.add(calc1);
        calculatorList.add(calc2);
        calculatorList.add(calc3);

        calculatorList.forEach(calc -> IOUtil.print(calc.divide()));
    }

    @Test
    @DisplayName("test rounding modes for dividing 10 and 3 with Builder")
    void divide10And3_v2() {
        final List<ScientificCalculator> calculatorList = new ArrayList<>();

        ScientificCalculator.Builder builder = new ScientificCalculator.Builder();
        builder.withNum1(10).withNum2(3);

        builder.withRounder(UpRounder.getInstance());
        final ScientificCalculator calc1 = builder.build();

        builder.withRounder(DownRounder.getInstance());
        final ScientificCalculator calc2 = builder.build();

        builder.withRounder(HalfUpRounder.getInstance());
        final ScientificCalculator calc3 = builder.build();

        calculatorList.add(calc1);
        calculatorList.add(calc2);
        calculatorList.add(calc3);

        calculatorList.forEach(calc -> IOUtil.print(calc.divide()));
    }
}
