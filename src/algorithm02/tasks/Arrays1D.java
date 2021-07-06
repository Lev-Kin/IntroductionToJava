package algorithm02.tasks;

import static java.lang.Math.abs;
import static supporting.MyTools.*;

public class Arrays1D {
    public static void Tasks() {
        System.out.println("\t\t\t=== Одномерные массивы ===\n");
        //task01();
        //task02();
        task03();
        task04();

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

        System.out.println("Числа кратные K = " + k + ":");
        for (int i = 0; i < array.length; i++) {
            if (array[i] % k == 0) {
                System.out.print(abs(array[i]) + " ; ");
                sum += abs(array[i]); // натуральные числа положительные
            }
        }

        System.out.println();
        System.out.println("Сумма элементов, которые кратны " + k + ", равна " + sum);
        System.out.println("=============================================================\n");
    }

    static public void task02() {
        System.out.println("2. Дана последовательность действительных чисел a1, a2, ..., an.\n" +
                "Заменить все ее члены, большие данного Z, этим числом.\n" +
                "Подсчитаь кол-во замен.");
        System.out.println("-------------------------------------------------------------");

        double[] array = new double[10];
        double number = 4.2;
        int count = 0;

        System.out.println("Начальный массив:");
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

    static public void task03() {
        System.out.println("3. Дан массив действительных чисел, размерность которого N.\n" +
                "Подсчитать, сколько в нем отрицательных, положительных\n" +
                "и нулевых элементов.");
        System.out.println("-------------------------------------------------------------");

        int n = 20;
        double[] array = new double[n];
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;

        System.out.println("Дан массив размерность которого равна " + n);
        enterArrayRandomDouble(array);
        printArray(array);

        for (int i = 0; i < array.length; i++)
            if (array[i] > 0) {
                positiveCount++;
            } else if (array[i] == 0) {
                zeroCount++;
            } else {
                negativeCount++;
            }

        System.out.printf("В массиве элеметов:\n" +
                        "%2d - отрецательных.\n%2d - нулевых.\n%2d - полжительных.\n",
                negativeCount, zeroCount, positiveCount);
        System.out.println("=============================================================\n");
    }

    static public void task04() {
        System.out.println("4. Даны действительные числа а1 ,а2 ,..., аn.\n" +
                "Поменять местами наибольший и наименьший элементы.");
        System.out.println("-------------------------------------------------------------");

        int n = 10;
        double[] array = new double[n];

        System.out.println("Дан массив размерность которого равна " + n);
        enterArrayRandomDouble(array);
        printArray(array);

        // Вычиляем наименьший и наибольший элемент в массиве
        int minIndex = 0;
        int maxIndex = 0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            } else if (array[i] > max) {
                max = array[i];
                maxIndex = i;
            }
        }

        System.out.printf("Меняем местами min A[%2d] и max A[%2d] элементы:\n", minIndex, maxIndex);

        double temp = array[minIndex];
        array[minIndex] = array[maxIndex];
        array[maxIndex] = temp;

        printArray(array);

        System.out.println("=============================================================\n");
    }


}
