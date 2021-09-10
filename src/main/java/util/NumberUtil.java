package util;

public class NumberUtil {
    public static boolean isPositive(int num) {
        return num > 0;
    }

    public static boolean isNegative(int num) {
        return num < 0;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
