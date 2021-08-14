package algorithm02.tasks;

import static supporting.MyTools.*;

public class Decomposition {
    public static void Tasks() {
        System.out.println("\t\t=== Декомпозиция с использованием метов ===\n");
        //task01();
        //task02();
        //task03();
        task04();
        task05();
//        task06();
//        task07();
//        task08();
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
        System.out.println("1) Заданое количество точек равно " + 4);

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

        System.out.printf("\nДлина = %.2f\n",result);
        System.out.println("=============================================================\n");
    }

    private static void task05() {
        System.out.println("5. Составить программу, которая в массиве A[N] находит\n" +
                "второе по величине число (вывести на печать число,\n" +
                "которое меньше максимального элемента массива,\n" +
                "но больше всех других элементов).");
        System.out.println("-------------------------------------------------------------");

        System.out.println("=============================================================\n");
    }



    }