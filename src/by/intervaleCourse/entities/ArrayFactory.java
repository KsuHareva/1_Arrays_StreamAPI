package by.intervaleCourse.entities;

public class ArrayFactory {

    public static int[] getRandomArray(int size) {
        int[] array = new int[size];
        double min = -100;
        double max = 100;

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) ((Math.random() * ((max - min) + 1)) + min);
        }
        return array;
    }
}
