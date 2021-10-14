package ejercicios.clase4;

public class Calculator {
    protected final double num1;
    protected final double num2;

    public Calculator(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double sum() {
        return num1 + num2;
    }

    public double subtract() {
        return num1 - num2;
    }

    public double multiply() {
        return num1 * num2;
    }

    public double divide() throws CalculatorException {
        if (num2 == 0) {
            throw new CalculatorException("Cannot divide by zero");
        } else {
            return num1 / num2;
        }
    }

    public static class CalculatorException extends Exception {
        private CalculatorException(String message) {
            super(message);
        }
    }
}
