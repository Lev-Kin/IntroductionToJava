package algorithm02.tasks;

import static supporting.MyTools.printArray;

public class SortArrays1D {
    public static void Tasks() {
        System.out.println("\t\t\t=== Одномерные массивы. Сортировки ===\n");
        task01();
//        task02();
//        task03();
//        task04();
//        task05();
//        task06();
//        task07();
//        task08();
    }

    private static void task01() {
        System.out.println("1. Заданы два одномерных массива с различным количеством\n" +
                "элементов и натуральное число k. Объединить их в один массив,\n" +
                "включив второй массив между k-м и (k+1) - м элементами\n" +
                "первого, при этом не используя дополнительный массив.");
        System.out.println("-------------------------------------------------------------");
        int an = 8;
        int bn = 5;
        int k = 3;
        int count = 0;

        int[] arrayA = new int[an];
        int[] arrayB = new int[bn];

        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = (int) (Math.random() * (100 + 1));
        }

        for (int i = 0; i < arrayB.length; i++) {
            arrayB[i] = (int) (Math.random() * (100 + 1));
        }

        System.out.println("Первый одномерный массив:");
        printArray(arrayA);
        System.out.println("Второй одномерный массив:");
        printArray(arrayB);

        int[] arrayAB = new int[(arrayA.length + arrayB.length)];
        k = k + 1; // (k + 1) = с индекса элемета включительно
        for (int i = 0; i < arrayAB.length; i++) {

            if (k > i) {
                arrayAB[i] = arrayA[i];
            } else if (count < k || count != arrayB.length) {
                arrayAB[i] = arrayB[count];
                count++;
            } else
                arrayAB[i] = arrayA[i - k - 1];
        }

        System.out.println("Объединяем первый массив со вторым\n" +
                "между k-ми (k+1) элементами первого:");
        printArray(arrayAB);
        System.out.println("=============================================================\n");
    }


}
