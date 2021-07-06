package algorithm02.tasks;

import static supporting.MyTools.*;

public class Arrays1D {
    public static void Tasks() {
        System.out.println("\t\t\t=== Одномерные массивы ===\n");
        task01();
        task02();

    }

    private static void task01() {
        System.out.println("1. В массив A[N] занесены натуральные числа. Найти сумму тех\n" +
                "элементов, которые кратны данному K");
        System.out.println("-------------------------------------------------------------");

        int k = 3;
        int[] array = new int[10];
        int sum = 0;

        enterArrayRandomInt(array);
        printArray(array);

        for (int i = 0; i < array.length; i++) {
            if (array[i] % k == 0) {
                sum += array[i];
            }
        }

        System.out.println("Сумма элементов, которые кратны " + k + ", равна " + sum);
        System.out.println("=============================================================\n");
    }

    static public void task02() {
        System.out.println("Дана последовательность действительных чисел a1, a2, ..., an.\n" +
                "Заменить все ее члены, большие данного Z, этим числом.\n" +
                "Подсчитаь кол-во замен.");

        double[] array = new double[10];
        double number = 4.20;
        int count = 0;

        System.out.println("Начальный массив");
        enterArrayRandomDouble(array);
        printArray(array);

        for (int i = 0; i < array.length; i++) {
            if (array[i] > number) {
                array[i] = number;
                count++;
            }
        }
        System.out.println("Массив после замены");
        System.out.println("при Z = " + number);
        printArray(array);
        System.out.println("Количество замен равно " + count);
        System.out.println("=============================================================\n");
    }


}
