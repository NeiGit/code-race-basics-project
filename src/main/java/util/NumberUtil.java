package util;

import java.util.ArrayList;
import java.util.List;

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

    public static List<Integer> sortIntegerList(List<Integer> numbers1, SortType sortType) {
        final List<Integer> numbersOrdered = new ArrayList<>();
        numbersOrdered.add(numbers1.get(0));

        for(int i = 1; i < numbers1.size(); i ++) {
            int candidate = numbers1.get(i);

            int index = 0;
            boolean found = false;

            while(!found && index < numbersOrdered.size()) {

                if (sortType == SortType.ASC) {
                    found = candidate <= numbersOrdered.get(index);
                } else if (sortType == SortType.DESC) {
                    found = candidate >= numbersOrdered.get(index);
                }

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
