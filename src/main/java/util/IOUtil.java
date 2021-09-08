package util;

import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class IOUtil {
    private static final Scanner input = new Scanner(System.in);

    public static void print(final Object o) {
        System.out.println(o);
    }

    public static int intInput(@NotNull String promptMessage) {
        return intInput(promptMessage, i -> true);
    }

    public static int intInput(@NotNull String promptMessage, @NotNull Predicate<Integer> condition) {
        return new SafeInput<Integer>(promptMessage, condition, () -> Integer.parseInt(input.nextLine())).ensureInput();
    }

    public static String stringInput(@NotNull String promptMessage) {
        return stringInput(promptMessage, s -> !s.trim().isEmpty());
    }

    public static String stringInput(String promptMessage, Predicate<String> condition) {
        return new SafeInput<String>(promptMessage, condition, input::nextLine).ensureInput();
    }

    public static double doubleInput(@NotNull String promptMessage) {
        return doubleInput(promptMessage, d -> true);
    }

    public static double doubleInput(@NotNull String promptMessage, @NotNull Predicate<Double> condition) {
        return new SafeInput<Double>(promptMessage, condition, () -> Double.parseDouble(input.nextLine())).ensureInput();
    }


    private static class SafeInput<T> {
        @NotNull Predicate<T> condition;
        @NotNull Supplier<T> supplier;
        @NotNull String promptMessage;

        private static final String INVALID_INPUT = "Ingreso inválido. Reinténtelo";

        public SafeInput(@NotNull String promptMessage, @NotNull Predicate<T> condition, @NotNull Supplier<T> supplier) {
            this.condition = condition;
            this.supplier = supplier;
            this.promptMessage = promptMessage;
        }

        private T ensureInput() {
            Optional<T> input = Optional.empty();

            while(!input.isPresent()) {
                print(promptMessage);

                try {
                    input = Optional.of(supplier.get());

                    if (!condition.test(input.get())) {
                        invalidateInput();
                        input = Optional.empty();
                    }

                } catch (final Exception e) {
                    invalidateInput();
                }

            }

            return input.get();
        }

        private void invalidateInput() {
            print(INVALID_INPUT);
        }

    }
}
