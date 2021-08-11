package algorithm02.tasks;

import static supporting.MyTools.enterArrayRandom;
import static supporting.MyTools.printArray;

public class SortArrays1D {
    public static void Tasks() {
        System.out.println("\t\t\t=== Одномерные массивы. Сортировки ===\n");
        //task01();
        //task02();
        //task03();
        //task04();
        //task05();
        //task06();
        task07();
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

    private static void task03() {
        System.out.println("3. Сортировка выбором. Дана последовательность чисел\n" +
                "a1 <= a2 <= ... <= an. Требуется переставить элементы так,\n" +
                "чтобы они были расположены по убыванию. Для этого в массиве,\n" +
                "начиная с первого, выбирается наибольший элемент и ставится\n" +
                "на первое место, а первый - на место наибольшего.\n" +
                "Затем, начиная со второго, эта процедура\n" +
                "повторяется. Написать алгоритм сортировки выбором.");
        System.out.println("-------------------------------------------------------------");

        int n = (int) (Math.random() * 15 + 1);
        int[] array = new int[n];

        System.out.println("Дана последовательность чисел a1 <= a2 <= ... <= an:");
        for (int i = 0; i < array.length; i++) {
            array[i] = (i + 1) * 2;
        }
        printArray(array);

        System.out.println("Сортируем по убыванию, сортировкой выбором по убыванию:");
        for (int i = 0; i < array.length; i++) {

            int max = array[i];
            int maxIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > max) {
                    max = array[j];
                    maxIndex = j;
                }
            }

            int temp = array[i];
            array[i] = max;
            array[maxIndex] = temp;
        }
        printArray(array);

        System.out.println("=============================================================\n");
    }

    private static void task04() {
        System.out.println("4. Сортировка выбором. Дана последовательность чисел\n" +
                "(a1 <= a2 <= ... <= an)?. Требуется переставить числа в,\n" +
                "порядке возрастания. Для этого сравниваются два соседних\n" +
                "числа ai и ai+1. Если ai > ai+1, то делается перестановка.\n" +
                "Так продолжается до тех пор, пока все элементы нне станут\n" +
                "расположены в порядке возрастания. Составить алгоритм \n" +
                "сортировки, подсчитывая при этом количества перестановок.");
        System.out.println("-------------------------------------------------------------");

        int n = (int) (Math.random() * 15 + 1);
        int[] array = new int[n];

        System.out.println("Дана последовательность чисел a1, a2, ..., an:");
        enterArrayRandom(array);
        printArray(array);

        int count = 0;
        System.out.println("Сортируем обменами, eсли ai > ai+1:");
        // Сортировка массива пузырьком
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // меняем элементы местами
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    count++;
                }
            }
        }
        printArray(array);

        System.out.println("Количество перестановок при сортировке = " + count);
        System.out.println("=============================================================\n");
    }

    private static void task05() {
        System.out.println("5. Сортировка вставками. Дана последовательность чисел\n" +
                "a1, a2, ..., an. Требуется переставить числа в порядке\n" +
                "возрастания. Делается это следующим образом. Пусть\n" +
                "a1, a2, ..., an - упорядоченная последовательность, т. е.\n" +
                "a1 <= a2 <= ... <= an. Берется следующее число ai+1 и\n" +
                "и вставляется в последовательность так, чтобы новая\n" +
                "последовательность была тоже возрастающей. Процесс\n" +
                "производится до тех пор, пока все элементы от i+1 до n\n" +
                "не будут перебраны.\n" +
                "?Примечание:\n" +
                "Место помещения очередного элемента в отсортированную часть\n" +
                "производить с помощью двоичного поиска. Двоичный поиск\n" +
                "оформитть в виде отдельной функции?.");
        System.out.println("-------------------------------------------------------------");

        int n = (int) (Math.random() * 11 + 1) + 3;
        int[] array = new int[n];

        System.out.println("Дана последовательность чисел a1, a2, ..., an:");
        enterArrayRandom(array);
        printArray(array);

        System.out.println("Сортируем вставками в порядке возростания:");
        for (int i = 1; i < array.length; i++) {

            int current = array[i];
            int j = i - 1;

            while (j >= 0 && current < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            // в этой точке мы вышли, так что j так же -1
            // или в первом элементе, где текущий >= a[j]
            array[j + 1] = current;
        }
        printArray(array);
        System.out.println("=============================================================\n");
    }

    private static void task06() {
        System.out.println("6. Сортировка Шелла. Дан массив n действительных чисел.\n" +
                "Требуется упорядочить его по возрастанию. Делается это\n" +
                "следующим образом:\n" +
                "сравниваются два соседних элемента ai и ai+1.\n" +
                "Если ai <= ai+1, то продвигаются на один элемент вперед.\n" +
                "Если ai >  ai+1, то производится перестановка и сдвигаются\n" +
                "на один элемент назад. Составить алгоритм этой сортировки.");
        System.out.println("-------------------------------------------------------------");

        int n = (int) (Math.random() * 11 + 1) + 3;
        double[] array = new double[n];

        System.out.println("Дана последовательность чисел a1, a2, ..., an:");
        enterArrayRandom(array);
        printArray(array);

        System.out.println("Сортировка Шелла элементы в порядке возростания:");
        int j;
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {

                double temp = array[i];

                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }

                array[j] = temp;
            }
        }
        printArray(array);
        System.out.println("=============================================================\n");
    }

    private static void task07() {
        System.out.println("7. Пусть даны две неубывающие последовательности действительных\n" +
                "чисел a1 <= a2 <= ... <= an и  b1 <= b2 <= ... <= bm.\n" +
                "Требуется указать те места, на которые нужно вставлять\n" +
                "элементы последовательности b1 <= b2 <= ... <= bm в первую\n" +
                "последовательность так чтобы новая последовательность\n" +
                "оставалась возрастающей.");
        System.out.println("-------------------------------------------------------------");

        int n = (int) (Math.random() * 11 + 1) + 3;
        int m = (int) (Math.random() * 11 + 1) + 3;

        double[] arrayA = new double[n];
        double[] arrayB = new double[m];

        System.out.println("1) Дана последовательность неубывающих чисел a1, a2, ..., an:");
        for (int i = 0; i < arrayA.length; i++) {
            double random_number = Math.random() * 100;
            arrayA[i] = random_number;
        }

        // неубывающие последовательность A сортировка массива пузырьком
        for (int i = 0; i < arrayA.length - 1; i++) {
            for (int j = 0; j < arrayA.length - i - 1; j++) {
                if (arrayA[j] > arrayA[j + 1]) {
                    // меняем элементы местами
                    double temp = arrayA[j];
                    arrayA[j] = arrayA[j + 1];
                    arrayA[j + 1] = temp;
                }
            }
        }
        printArray(arrayA);

        System.out.println("2) Дана последовательность неубывающих чисел  b1, b2, ..., bm:");
        for (int i = 0; i < arrayB.length; i++) {
            double random_number = Math.random() * 100;
            arrayB[i] = random_number;
        }

        // неубывающие последовательность B сортировка массива пузырьком
        for (int i = 0; i < arrayB.length - 1; i++) {
            for (int j = 0; j < arrayB.length - i - 1; j++) {
                if (arrayB[j] > arrayB[j + 1]) {
                    // меняем элементы местами
                    double temp = arrayB[j];
                    arrayB[j] = arrayB[j + 1];
                    arrayB[j + 1] = temp;
                }
            }
        }
        printArray(arrayB);

        System.out.println("Образуюм новую последовательность и указываем места в которые \n" +
                "вставляем из последовательности B элементы в послодовательноcть\n" +
                "А сохраняя возростание");
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        int k = 0;
        for (int i = 0; i < arrayA.length; i++) {
            boolean flagIns = true;
            for (int j = 0; j < arrayB.length; j++) {
                if (arrayA[i] < arrayB[j]) {
                    System.out.printf("a[%2d] <-- b[%2d]\n", i, j);
                    arrayA[i] = arrayB[j];
                    flagIns = false;
                    break;
                }
            }
            if (flagIns) {
                System.out.printf("a[%2d] <-> a[%2d]\n", i, i);
            }
        }

        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        System.out.println("Новая последовательность:");
        printArray(arrayA);
        System.out.println("=============================================================\n");
    }


}
