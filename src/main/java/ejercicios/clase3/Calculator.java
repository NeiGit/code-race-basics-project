package ejercicios.clase3;

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

    public double divide() {
        if (num2 == 0) {
            return 0;
        } else {
            return num1 / num2;
        }
    }
}
