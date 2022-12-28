import by.intervaleCourse.entities.ArrayFactory;
import by.intervaleCourse.entities.ArrayManager;

public class Runner {
    public static void main(String[] args) {
        //Task_1
        //Дан массив целых чисел. Нужно вернуть массив,
        // в котором первым элементом будет количество положительных чисел, а во втором - сумма отрицательных
        //0 не является ни положительным ни отрицательным
        //Если на вход прилетает пустой массив или null, то вернуть пустой массив


        int[] array = ArrayFactory.getRandomArray(400_000_000);

        System.out.println("Time cycle");
        int[] arrayResult = ArrayManager.getArrayResult(array);

        System.out.println("Time StreamCollection");
        int[] arrayResult2 = ArrayManager.getArrayResultStreamCollection(array);

        System.out.println("_____");
        System.out.println(ArrayManager.getDifferenceTime());


    }
}
