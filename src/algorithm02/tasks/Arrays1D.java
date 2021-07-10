package algorithm02.tasks;

import supporting.MyTools;

import static java.lang.Math.abs;
import static supporting.MyTools.enterArrayRandom;
import static supporting.MyTools.printArray;

public class Arrays1D {
    public static void Tasks() {
        System.out.println("\t\t\t=== Одномерные массивы ===\n");
        task01();
        task02();
        task03();
        task04();
        task05();
        task06();
        task07();
        task08();
        task09();
        task10();
    }

    private static void task01() {
        System.out.println("1. В массив A[N] занесены натуральные числа. Найти сумму тех\n" +
                "элементов, которые кратны данному K");
        System.out.println("-------------------------------------------------------------");

        int k = 3;
        int[] array = new int[10];
        int sum = 0;

        enterArrayRandom(array);
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

    private static void task02() {
        System.out.println("2. Дана последовательность действительных чисел a1, a2, ...,\n" +
                "an. Заменить все ее члены, большие данного Z, этим числом.\n" +
                "Подсчитаь кол-во замен.");
        System.out.println("-------------------------------------------------------------");

        double[] array = new double[10];
        double number = 4.2;
        int count = 0;

        System.out.println("Начальный массив:");
        MyTools.enterArrayRandom(array);
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

    private static void task03() {
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
        MyTools.enterArrayRandom(array);
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

    private static void task04() {
        System.out.println("4. Даны действительные числа а1 ,а2 ,..., аn.\n" +
                "Поменять местами наибольший и наименьший элементы.");
        System.out.println("-------------------------------------------------------------");

        int n = 10;
        double[] array = new double[n];

        System.out.println("Дан массив размерность которого равна " + n);
        MyTools.enterArrayRandom(array);
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

    private static void task05() {
        System.out.println("5. Даны целые числа а1 ,а2 ,..., аn.\n" +
                "Вывести на печать только те числа, для которых аi > i.");
        System.out.println("-------------------------------------------------------------");

        int n = 11;
        int[] array = new int[n];

        System.out.println("Дан массив размерность которого равна " + n);
        enterArrayRandom(array);
        printArray(array);

        System.out.println("Числа, для которых a[i] > i: ");
        for (int i = 0; i < array.length; i++) {
            if (array[i] > i) {
                System.out.printf("A[%2d] = %4d\n", i, array[i]);
            }
        }
        System.out.println("=============================================================\n");
    }

    private static void task06() {
        System.out.println("6. Задана последовательность N вещественных чисел.\n" +
                "Вычислить сумму чисел, порядковые номера которых\n" +
                "являются простыми числами.");
        System.out.println("-------------------------------------------------------------");

        int n = 12;
        double[] array = new double[n];
        double sum = 0.0;

        System.out.println("Дан массив размерность которого равна " + n);
        MyTools.enterArrayRandom(array);
        printArray(array);

        System.out.println("Выводим на экран порядковые нормера которые являются\n" +
                "простыми числами и их заначение");
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        nextPrime:
        for (int i = 2; i < array.length; i++) {

            for (int j = 2; j < i; j++) {
                if (i % j == 0) continue nextPrime;
            }

            System.out.printf("A[%2d] = %6.2f\n", i, array[i]);
            sum += array[i];
        }
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.printf("Сумма элеметов где i - постое число = %6.2f\n", sum);
        System.out.println("=============================================================\n");
    }

    private static void task07() {
        System.out.println("7. Даны действительные числа a1, a2, ..., an.\n" +
                "Найти: max(a1 + a2n, a2 + a2n-1, ..., an + an-1)");
        System.out.println("-------------------------------------------------------------");

        int n = 12;
        double[] array = new double[n];
        double max = Double.MIN_VALUE;

        System.out.println("Дан массив размерность которого равна " + n);
        MyTools.enterArrayRandom(array);
        printArray(array);

        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                max = array[0] + array[1];
            } else if (array[i] + array[i - 1] > max) {
                max = array[i] + array[i - 1];
            }
        }

        System.out.printf(" max(a1 + a2n, a2 + a2n-1, ..., an + an-1) = %6.2f\n", max);
        System.out.println("=============================================================\n");
    }

    private static void task08() {
        System.out.println("8. Дана последовательность целых чисел a1, a2, ..., an.\n" +
                "Образовать новую последовательность, выбросив из исходной\n" +
                "челены, которые равны min(a1, a2, ..., an)");
        System.out.println("-------------------------------------------------------------");

        int n = 20;
        int[] array = new int[n];

        System.out.println("Дан массив размерность которого равна " + n);
        enterArrayRandom(array);
        printArray(array);

        int min = Integer.MAX_VALUE;
        int minCount = 0;

        System.out.println("min(a1, a2, ..., an):");
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                minCount++;
                System.out.printf("A[%2d] = %4d\n", i, min);
            }
        }

        //создаем массив без min элементов
        int[] result = new int[array.length - minCount];
        int index = 0;
        min = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (!(array[i] < min)) {
                result[index] = array[i];
                index++;
            }

            if (array[i] < min) {
                min = array[i];
            }
        }

        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        System.out.println("Новая паследовательность с выбрасом из изходного массива\n" +
                "членов которые равны min(a1, a2, ..., an)");
        printArray(result);
        System.out.println("=============================================================\n");
    }

    private static void task09() {
        System.out.println("9. В массиве целых чисел с количеством элементов n найти\n" +
                "наиболее часто встречающееся число. Если таких чисел\n" +
                "несколько, то определить наименьшее из них.");
        System.out.println("-------------------------------------------------------------");

        int n = 30;
        int[] array = new int[n];

        System.out.println("Дан массив размерность которого равна " + n);
        enterArrayRandom(array);
        printArray(array);

        int amountRepeatNumber = 0;
        int count;
        int min = Integer.MAX_VALUE;

        //Находим повторяющийся числа определяем сколько их всего и делаем меньший массив
        for (int i = 0; i < array.length; i++) {
            count = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }

            if (count > 1) {
                amountRepeatNumber++;
            }
        }

        if (amountRepeatNumber != 0) {

            //Заполняем массив часто встречающимися числами
            int[] repeatNumber = new int[amountRepeatNumber];
            int index = 0;

            for (int i = 0; i < array.length; i++) {
                count = 0;
                for (int j = 0; j < array.length; j++) {
                    if (array[i] == array[j]) {
                        count++;
                    }
                }

                if (count > 1) {
                    repeatNumber[index] = array[i];
                    index++;
                }
            }

            System.out.println("Массив с повторяющимися числами из данного массива:");
            printArray(repeatNumber);

            // делаем maxCount чтоб найти наиболее часто встречающиеся число
            int maxCount = Integer.MIN_VALUE;
            for (int i = 0; i < repeatNumber.length; i++) {
                count = 0;
                for (int j = 0; j < repeatNumber.length; j++) {
                    if (repeatNumber[i] == repeatNumber[j]) {
                        count++;
                    }
                }

                if (count > maxCount) {
                    maxCount = count;
                    min = repeatNumber[i];
                } else if (maxCount == count) {
                    if (repeatNumber[i] < min) {
                        min = repeatNumber[i];
                    }
                }
            }

            System.out.println("Число встречается max раз = " + maxCount);
            System.out.println("Наименьше число и из часто всречающийся " + min);
        } else {
            System.out.println("Повторяющийся числа не обнаружины.");
        }
        System.out.println("=============================================================\n");
    }

    private static void task10() {
        System.out.println("10. Дан целочисленный массив с количеством элементов n.\n" +
                "Сжать массив, выбросив из него каждый второй элемент\n" +
                "(освободившиеся элементы заполнить нулями).\n" +
                "Примечание. Дополнительный массив не использовать");
        System.out.println("-------------------------------------------------------------");

        int n = 21;
        int[] array = new int[n];

        System.out.println("Дан массив размерность которого равна " + n);
        enterArrayRandom(array);
        printArray(array);

        System.out.println("Kаждый второй элемент массива заполняем нулеми.");
        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0) {
                array[i] = 0;
            }
        }
        printArray(array);

        System.out.println("Все нулевые элементы премещаем в конец массива.");
        int i = 0;
        for (int j = 0; j < array.length; j++) {
            if (array[j] != 0) {
                array[i++] = array[j];
            }
        }

        while (i < array.length) {
            array[i++] = 0;
        }

        printArray(array);
        System.out.println("=============================================================\n");
    }
}