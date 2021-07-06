package algorithm02.tasks;

import static supporting.MyTools.enterArrayRandom;
import static supporting.MyTools.printArray;

public class Arrays1D {
    public static void Tasks() {
        System.out.println("\t\t\t=== Одномерные массивы ===\n");
        task01();

    }

    private static void task01() {
        System.out.println("1. В массив A[N] занесены натуральные числа. Найти сумму тех\n" +
                "элементов, которые кратны данному K");
        System.out.println("-------------------------------------------------------------");

        int k = 3;
        int[] a = new int[10];
        int sum = 0;

       enterArrayRandom(a);
       printArray(a);

        for (int i = 0; i < a.length; i++) {
            if (a[i] % k == 0) {
                sum += a[i];
            }
        }

        System.out.println("Сумма элементов, которые кратны " + k + ", равна " + sum);
        System.out.println("=============================================================\n");
    }


}
