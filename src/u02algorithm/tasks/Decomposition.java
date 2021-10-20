package u02algorithm.tasks;

import static supporting.MyTools.enterArrayRandom;
import static supporting.MyTools.printArray;
import static supporting.МуMethods.*;

public class Decomposition {
    public static void Tasks() {
        System.out.println("\t\t=== Декомпозиция с использованием метов ===\n");
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
        task11();
        task12();
        task13();
        task14();
        task15();
        task16();
        task17();
    }

    private static void task01() {
        System.out.println("1. Написать метод(методы) для нахождения наибольшего общего\n" +
                "делителя и наименьшего общего кратного двух\n" +
                "натуральных чисел:");
        System.out.println("-------------------------------------------------------------");

        int a = (int) (Math.random() * 100 + 2);
        int b = (int) (Math.random() * 100 + 2);

        System.out.printf("Дано два натуральных числа А = %d и B = %d\n", a, b);
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        int nod = 0;
        int nok = 0;

        nod = gcd(a, b);
        System.out.printf("1) НОД(%d, %d) = %d\n", a, b, nod);
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        nok = lcm(a, b);
        System.out.printf("2) НОK(%d, %d) = %d\n", a, b, nok);
        System.out.println("=============================================================\n");
    }

    private static void task02() {
        System.out.println("2. Написать метод(методы) для нахождения наибольшего общего\n" +
                "делителя четырех натуральных чисел:");
        System.out.println("-------------------------------------------------------------");

        int n = 4;
        int[] arrayN = new int[n];
        //int [] arrayN = {8, 12, 16, 20}; // НОД = 4

        for (int i = 0; i < arrayN.length; i++) {
            arrayN[i] = (int) (Math.random() * 100 + 2);
        }

        System.out.printf("Дано %d натуральныx числa:\n", n);
        for (int i = 0; i < arrayN.length; i++) {

            if (i % 10 == 0 && i != 0) {
                System.out.println();
            }

            System.out.print(arrayN[i] + "; ");
        }
        System.out.println();
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.print("НОД(");
        for (int i = 0; i < arrayN.length; i++) {

            if (i % 10 == 0 && i != 0) {
                System.out.print("\n\t");
            }

            if (i != arrayN.length - 1) {
                System.out.print(arrayN[i] + "; ");
            } else {
                System.out.print(arrayN[i] + ") = ");
            }
        }

        // метод для нахождения наибольшего общего делителя четырех натуральных чисел
        int nodN = gcdN(arrayN, n);
        System.out.print(nodN + "\n");
        System.out.println("=============================================================\n");
    }

    private static void task03() {
        System.out.println("3. Вычислить площадь правильного шестиугольника со стороной а,\n" +
                "используя метод вычисления площади треугольника.");
        System.out.println("-------------------------------------------------------------");

        double a = Math.random() * 100 + 1;
        System.out.printf("Дана сторона правильного шестиугольника а = %.2f\n", a);

        double s = squareOfRegularHexagon(a); // Метод вычисления площади
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.printf("Площадь правильного шестиугольника S = %.2f\n", s);
        System.out.println("=============================================================\n");
    }

    private static void task04() {
        System.out.println("4. На плоскости заданы своими координатами n точек.\n" +
                "Написать метод(методы), определяющие,\n" +
                "между какими из пар точек самое большое расстояние.\n" +
                "Указание. Координаты точек занести в массив.");
        System.out.println("-------------------------------------------------------------");

        int n = (int) (Math.random() * 5 + 1) + 2;
        double[][] point = new double[n][2];
        System.out.println("1) Заданое количество точек равно " + n);

        //double[][] point = {{-5, 3}, {6, 5}, {-6, -5}, {4, 3}}; // max между 2 и 3 = 7,81
        for (int i = 0; i < n; i++) {
            point[i][0] = (Math.random() * (20 + 1)) - 10; // X
            point[i][1] = (Math.random() * (20 + 1)) - 10; // Y
        }

        System.out.println("Координаты точек на плоскости:");
        for (int i = 0; i < n; i++) {
            System.out.printf("Точка %d\t\tX = %2.0f\t\tY = %2.0f\n",
                    i + 1, point[i][0], point[i][1]);
        }
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.println("2) Определяем между какими парами точек самое max расстояние:");

        // метод нохождения max растояния между n точками
        double result = maxPointDistance(point, n);

        System.out.printf("\nДлина = %.2f\n", result);
        System.out.println("=============================================================\n");
    }

    private static void task05() {
        System.out.println("5. Составить программу, которая в массиве A[N] находит\n" +
                "второе по величине число (вывести на печать число,\n" +
                "которое меньше максимального элемента массива,\n" +
                "но больше всех других элементов).");
        System.out.println("-------------------------------------------------------------");

        int n = (int) (Math.random() * 8 + 1) + 2;
        int[] array = new int[n];

        System.out.println("Дан массив размерность которого равна " + n);
        enterArrayRandom(array);
        printArray(array);

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {

                if (array[j] > array[j + 1]) {

                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        int maxNumber = array[array.length - 1];

        int result = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] < maxNumber) {
                result = array[i];
                break;
            }
        }

        System.out.println("Второе по величене число в массиве = " + result);
        System.out.println("=============================================================\n");
    }

    private static void task06() {
        System.out.println("6. Написать метод(методы), проверяющий, являются ли данные\n" +
                "три числа взаимно простыми.");
        System.out.println("-------------------------------------------------------------");

        int n = 3;
        int[] array = new int[n];
        enterArrayRandom(array);

        System.out.printf("Дано %d числа:\n", n);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "; ");
        }
        System.out.println();
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.print("НОД(");
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1) {
                System.out.print(array[i] + "; ");
            } else {
                System.out.print(array[i] + ") = ");
            }
        }
        int nodN = gcdN(array, n);
        System.out.print(nodN + "\n");

        // метод провеки являются ли три числа взаимно простыми
        if (numbersCoprime(array, n) == true)
            System.out.println("Числа взаимно простые.");
        else
            System.out.println("Числа НЕ взоимно простые.");

        System.out.println("=============================================================\n");
    }

    private static void task07() {
        System.out.println("7. Написать метод(методы) для вычисления суммы факториалов\n" +
                "всех нечетных чисел от 1 до 9.");
        System.out.println("-------------------------------------------------------------");

        int n = 9;

        System.out.println("Сумма факториала нечетных чисел от 1 до 9 = " + sumFactorialOdd(n));
        System.out.println("=============================================================\n");
    }

    private static void task08() {
        System.out.println("8. Задан массив D. Определить следующие суммы:\n" +
                "D[1] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] + D[5] + D[6].\n" +
                "Пояснение.\n" +
                "Составить метод(ы) для вычисления суммы трех последовательно\n" +
                "расположенных элементов массива с номерами от k до m.");
        System.out.println("-------------------------------------------------------------");

        int count = 0;
        int sum = 0;

        int[] array = new int[7];
        enterArrayRandom(array);
        System.out.println("Задан массив D");
        printArray(array);

        while (count != 3) {

            if (count == 0) {
                int k = 1;
                int m = 3;

                System.out.printf("Сумма промежутака D[%d] - D[%d] = %d\n", k, m, sumGapKM(array, k, m));
                count++;
            }

            if (count == 1) {
                int k = 3;
                int m = 5;

                System.out.printf("Сумма промежутака D[%d] - D[%d] = %d\n", k, m, sumGapKM(array, k, m));
                count++;
            }

            if (count == 2) {
                int k = 4;
                int m = 6;

                System.out.printf("Сумма промежутака D[%d] - D[%d] = %d\n", k, m, sumGapKM(array, k, m));
                count++;
            }
        }

        System.out.println("=============================================================\n");
    }

    private static void task09() {
        System.out.println("9. Даны числа A, B, C, D — длины сторон четырехугольника.\n" +
                "Написать метод(методы) вычисления его площади,\n" +
                "если угол между сторонами длиной A и B — прямой.");
        System.out.println("-------------------------------------------------------------");

        // Стороны четырехугольника ((5, 5, 5, 5) = 25; (3, 4, 12, 13) = 36)
        double a = (int) (Math.random() * 10 + 1);
        double b = (int) (Math.random() * 10 + 2);

        double k = 0;
        if (a >= b)
            k = a;
        else
            k = b;

        double c = (int) (Math.random() * 10 + 3 + k);
        double d = (int) (Math.random() * 10 + 4 + k);

        System.out.println("Даны числа дилины сторон четырехугольника:");
        System.out.printf("A = %.0f; B = %.0f; C = %.0f; D = %.0f\n", a, b, c, d);
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.printf("Площадь четырехугольнока = %.2f\n", squareOfQuadrangle(a, b, c, d));
        System.out.println("=============================================================\n");
    }

    private static void task10() {
        System.out.println("10. Дано натуральное число N.\n" +
                "Написать метод(методы) для формирования массива,\n" +
                "элементами которого являются цифры числа N.");
        System.out.println("-------------------------------------------------------------");

        int n = (int) (Math.random() * (Integer.MAX_VALUE - 100) + 100); // int max 2147483647

        System.out.println("Дано натуральное число --> " + n);
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.println("Количество цифр в числе = " + amountDigitsOfNumbers(n));
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        int[] array = digitsOfNumbersInArray(n);
        System.out.println("Массив сформирован цифры числа следущие:");
        printArray(array);
        System.out.println("=============================================================\n");
    }

    private static void task11() {
        System.out.println("11. Написать метод(методы), определяющий,\n" +
                "в каком из данных двух чисел больше цифр.");
        System.out.println("-------------------------------------------------------------");

        int a = (int) (Math.random() * (Integer.MAX_VALUE - 100) + 100);
        int b = (int) (Math.random() * (Integer.MAX_VALUE - 100) + 100);

        System.out.println("Дано число A = " + a + " и B = " + b);
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        int amountDigitsA = amountDigitsOfNumbers(a);
        int amountDigitsB = amountDigitsOfNumbers(b);

        System.out.println("Количество цифр в числе  А = " + amountDigitsA);
        System.out.println("Количество цифр в числе  B = " + amountDigitsB);
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        // Метод определяющий, в коком из данных двух чисел больше цифр
        int result = longerNumberOfTwo(a, b);

        if (a == result)
            System.out.println("Количество цифр числа А больше числа B");
        else if (b == result)
            System.out.println("Количество цифр числа B больше числа A");
        else
            System.out.println("Количество цифр чилса А и В равно");

        System.out.println("=============================================================\n");
    }

    private static void task12() {
        System.out.println("12. Даны натуральные числа К и N. Написать метод(методы)\n" +
                "формирования массива А, элементами которого являются числа,\n" +
                "сумма цифр которых равна К и которые не большее N.");
        System.out.println("-------------------------------------------------------------");

        int k = (int) (Math.random() * 10 + 1);
        int n = (int) (Math.random() * 1000 + 1);

        System.out.println("Дано натуральное число К = " + k + " и N = " + n);
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.println("Массив А сформирован:");
        int[] arrayA = arrayDigitsSumKminN(k, n);
        printArray(arrayA);
        System.out.println("=============================================================\n");
    }

    private static void task13() {
        System.out.println("13. Два простых числа называются «близнецами», если они\n" +
                "отличаются друг от друга на 2 (например, 41 и 43).\n" +
                "Найти и напечатать все пары «близнецов» из отрезка [n,2n],\n" +
                "где n - заданное натуральное число больше 2.\n" +
                "Для решения задачи использовать декомпозицию.");
        System.out.println("-------------------------------------------------------------");

        int n = (int) (Math.random() * 1000 + 3); // больше 2

        int a = n;
        int b = n * 2;

        System.out.printf("Дан отрезок натуральных чисел [%d, %d]\n", a, b);
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        int[][] arrayT = twinsPrimeNumberArray(a, b);

        System.out.println("Числа близницы простых чисел:");
        for (int i = 0; i < arrayT.length; i++) {
            System.out.printf("%d\t--> {%d\t; %d\t}\n", i + 1, arrayT[i][0], arrayT[i][1]);
        }
        System.out.println("=============================================================\n");
    }

    private static void task14() {
        System.out.println("14. Натуральное число, в записи которого n цифр, называется\n" +
                "числом Армстронга, если сумма его цифр, возведенная в степень\n" +
                "n, равна самому числу. Найти все числа Армстронга от 1 до k.\n" +
                "Для решения задачи использовать декомпозицию.");
        System.out.println("-------------------------------------------------------------");

        int k = (int) (Math.random() * 10000000 + 1);

        System.out.println("Дан промежуток от 1 до " + k);
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        System.out.println("Числа Амстронга следущие:");

        int count = 0;
        for (int i = 1; i < k + 1; i++) {
            if (isArmstrongNumber(i) == true) {

                if (count % 5 == 0 && count != 0) {
                    System.out.println();
                }

                System.out.print(i + " | ");

                count++;
            }
        }

        System.out.println();
        System.out.println("=============================================================\n");
    }

    private static void task15() {
        System.out.println("15. Найти все натуральные n-значные числа, цифры в которых\n" +
                "образуют строго возрастающую последовательность\n" +
                "(например, 1234, 5789).\n" +
                "Для решения задачи использовать декомпозицию.");
        System.out.println("-------------------------------------------------------------");

        int n = (int) (Math.random() * 4 + 2);

        System.out.println("Дано n-значные числа = " + n);
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        int startNumber = (int) Math.pow(10, n - 1);
        int count = 0;

        System.out.println("Значение числа строгой возрастающй последовательностью:");
        for (int i = startNumber; i < startNumber * 10; i++) {

            int amountGrowingNumbers = 0;

            for (int j = 1; j < n; j++) {

                int digitR = (int) (i / Math.pow(10, j - 1)) % 10;
                int digitL = (int) (i / Math.pow(10, j)) % 10;

                if (digitL < digitR) {
                    amountGrowingNumbers++;
                }

                if (amountGrowingNumbers == n - 1) {

                    if (count % 5 == 0 && count != 0) {
                        System.out.println();
                    }

                    System.out.print(i + " | ");

                    count++;
                }
            }
        }

        System.out.println();
        System.out.println("=============================================================\n");
    }

    private static void task16() {
        System.out.println("16. Написать программу, определяющую сумму n - значных чисел,\n" +
                "содержащих только нечетные цифры.\n" +
                "Определить также, сколько четных цифр в найденной сумме.\n" +
                "Для решения задачи использовать декомпозицию.");
        System.out.println("-------------------------------------------------------------");

        int n = (int) (Math.random() * 5 + 2);

        System.out.println("Дано n-значные числа = " + n);
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        int sum = sumOfOddNumbers(n);
        System.out.println("Сумма = " + sum);
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.println("Число чётных цифр в сумме = " + amountEvenDigitsOfNumber(sum));
        System.out.println("=============================================================\n");
    }

    private static void task17() {
        System.out.println("17. Из заданного числа вычти сумму его цифр.\n" +
                "Из результата вновь вычли сумму его цифр и т.д.\n" +
                "Сколько таких действий надо произвести, чтобы получился нуль?\n" +
                "Для решения задачи использовать декомпозицию.");
        System.out.println("-------------------------------------------------------------");

        int n = (int) (Math.random() * (Integer.MAX_VALUE - 100) + 100);
        System.out.println("Дано натуральное число N = " + n);
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        int temp = n;
        int count = 0;
        int sum = 0;

        while (temp != 0) {

            sum = sumDigitsOfNumber(temp);

            temp -= sum;

            count++;
        }

        System.out.println("Было произведенино "+ count + " действий.");
        System.out.println("=============================================================\n");
    }
}