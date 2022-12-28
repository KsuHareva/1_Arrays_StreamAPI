package by.intervaleCourse.entities;

import java.util.Arrays;
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

public class ArrayManager {
    private static long cycleTime;
    private static long streamTime;

    public static int[] getArrayResult(int[] array) {
        long start1 = System.currentTimeMillis();
        int countPositive = 0;
        int sumNegative = 0;
        int[] arrayResult = null;
        if (array != null && array.length > 0) {
            for (int elem : array) {
                if (elem > 0) {
                    countPositive++;
                } else if (elem < 0) {
                    sumNegative = sumNegative + elem;
                }
            }
            arrayResult = new int[2];
            arrayResult[0] = countPositive;
            arrayResult[1] = sumNegative;

        } else {
            arrayResult = new int[0];
        }
        long end1 = System.currentTimeMillis();
        cycleTime = end1 - start1;
        System.out.println(cycleTime);
        return arrayResult;
    }

    public static int[] getArrayResultStreamCollection(int[] array) {
        long start1 = System.currentTimeMillis();
        int[] arrayResult = null;

        if (array != null && array.length > 0) {
            Collection<IntSummaryStatistics> statistics = Arrays.stream(array).boxed()
                    .filter(a -> a != 0)
                    .collect(Collectors.groupingBy(x -> x > 0, Collectors.summarizingInt(a -> a)))
                    .values();

            arrayResult = new int[2];
            for (IntSummaryStatistics st : statistics) {
                arrayResult[0] = (int) st.getCount();
                arrayResult[1] = (int) st.getSum();
            }
        } else {
            arrayResult = new int[0];
        }
        long end1 = System.currentTimeMillis();
        streamTime = end1 - start1;
        System.out.println(streamTime);
        return arrayResult;
    }

    public static long getDifferenceTime() {
        return cycleTime - streamTime;
    }

    public static void show(int[] array) {
        System.out.println(Arrays.toString(array));
    }

}
