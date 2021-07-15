package algorithm02.tasks;

import static supporting.MyTools.printArray;

public class SortArrays1D {
    public static void Tasks() {
        System.out.println("\t\t\t=== Одномерные массивы. Сортировки ===\n");
        //task01();
        task02();
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

    private static void task02() {
        System.out.println("2. Даны две последовательности a1 <= a2 <= ... <= an и\n" +
                "b1 <= b2 <= ... <= bm. Образовать из них новую\n" +
                "последовательность чисел так, чтобы она тоже была неубывающей.\n" +
                "Примечание. Дополнительный массив не использовать.");
        System.out.println("-------------------------------------------------------------");

        int n = (int) (Math.random() * 10 + 1);
        int m = (int) (Math.random() * 10 + 1);

        int[] arrayA = new int[n];
        int[] arrayB = new int[m];

        System.out.println("Первый одномерный массив:");
        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = (i + 1) * 1;
        }
        printArray(arrayA);
        System.out.println("Второй одномерный массив:");
        for (int i = 0; i < arrayB.length; i++) {
            arrayB[i] = (i + 1) * 2;
        }
        printArray(arrayB);

        int count = 0;
        System.out.println("Новая последоваательность неубывающих чисел:");
        int[] arrayAB = new int[arrayA.length + arrayB.length];
        for (int i = 0; i < arrayA.length; i++)
            arrayAB[count++] = arrayA[i];
        for (int j = 0; j < arrayB.length; j++)
            arrayAB[count++] = arrayB[j];

        // Сортировка массива пузырьком
        for (int i = 0; i < arrayAB.length - 1; i++) {
            for (int j = 0; j < arrayAB.length - i - 1; j++) {
                if (arrayAB[j] > arrayAB[j + 1]) {
                    // меняем элементы местами
                    int temp = arrayAB[j];
                    arrayAB[j] = arrayAB[j + 1];
                    arrayAB[j + 1] = temp;
                }
            }
        }
        printArray(arrayAB);

        System.out.println("=============================================================\n");
    }

}
