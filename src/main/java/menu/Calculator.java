package menu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {
    
    public static double calculate(double num1, double num2, CalculatorOperation operation) {
        final Map<CalculatorOperation, BiFunction<Double, Double, Double>> operations = new HashMap<>();
        operations.put(CalculatorOperation.SUM, (n1, n2) -> n1 + n2);
        operations.put(CalculatorOperation.SUBTRACT, (n1, n2) -> n1 - n2);
        operations.put(CalculatorOperation.MULTIPLY, (n1, n2) -> n1 * n2);
        operations.put(CalculatorOperation.DIVIDE, (n1, n2) -> n1 / n2);
        operations.put(CalculatorOperation.PERCENTAGE, (n1, n2) -> (n1 * 100) / n2);

        return operations.get(operation).apply(num1, num2);
    }

    public enum CalculatorOperation {
        SUM, SUBTRACT, MULTIPLY, DIVIDE, PERCENTAGE;

        public static CalculatorOperation fromString(String value) {
            return Arrays.stream(CalculatorOperation.values())
                    .filter(calculatorOperation -> calculatorOperation.toString().equalsIgnoreCase(value))
                    .findFirst()
                    .orElse(null);
        }
    }
}
