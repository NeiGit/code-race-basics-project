package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

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

    public static List<Integer> sortIntegerListAscending(List<Integer> numbers) {
        return sortIntegerList(numbers, SortType.ASC);
    }

    public static List<Integer> sortIntegerListDescending(List<Integer> numbers) {
        return sortIntegerList(numbers, SortType.DESC);
    }

    private static List<Integer> sortIntegerList(List<Integer> numbers, SortType sortType) {
        final Map<SortType, BiFunction<Integer, Integer, Boolean>> sortMap = new HashMap<>();
        sortMap.put(SortType.ASC, (i1, i2) -> i1 <= i2);
        sortMap.put(SortType.DESC, (i1, i2) -> i1 >= i2);

        final List<Integer> numbersOrdered = new ArrayList<>();
        numbersOrdered.add(numbers.get(0));

        for(int i = 1; i < numbers.size(); i ++) {
            int candidate = numbers.get(i);

            int index = 0;
            boolean found = false;

            while(!found && index < numbersOrdered.size()) {
                found = sortMap.get(sortType)
                        .apply(candidate, numbersOrdered.get(index));

                if (!found) {
                    index ++;
                }
            }

            numbersOrdered.add(index, candidate);
        }

        return numbersOrdered;
    }

    private enum SortType {
        ASC, DESC
    }
}
