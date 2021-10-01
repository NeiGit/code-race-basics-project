package ejercicios.clase3;

import java.math.BigDecimal;

public class ScientificCalculator extends Calculator {
    private final int roundingMode;

    public ScientificCalculator(double num1, double num2) {
        super(num1, num2);

        this.roundingMode = 1;
    }

    @Override
    public double sum() {
        return round(super.sum());
    }

    @Override
    public double subtract() {
        return round(super.subtract());
    }

    @Override
    public double multiply() {
        return round(super.multiply());
    }

    @Override
    public double divide() {
        return round(super.divide());
    }

    public ScientificCalculator(double num1, double num2, int roundingMode) {
        super(num1, num2);

        this.roundingMode = roundingMode;
    }

    public double power() {
        return round(Math.pow(num1, num2));
    }

    public double root() {
        if (num1 < 0) {
            return 0;
        } else {
            return round(Math.pow(num1, 1.0 / num2));
        }
    }

    private double round(double result) {
        final BigDecimal bigDecimal = BigDecimal.valueOf(result);

        switch (roundingMode) {
            default:
            case 1:
                return bigDecimal.setScale(2, BigDecimal.ROUND_UP).doubleValue();
            case 2:
                return bigDecimal.setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
            case 3:
                return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
    }
}
