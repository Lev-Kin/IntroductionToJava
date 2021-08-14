package supporting;

import java.util.Scanner;

public class MyTools {

    //------- Проверка на ввод типа данных int --------
    public static int scannerInt() {
        Scanner in = new Scanner(System.in);
        int number;
        System.out.print("Введите число: ");
        while (!in.hasNextInt()) {
            in.next();
            System.out.println("Некорректный ввод!!!\nЧисло должно быть целочисленным!");
            System.out.print("Введите число: ");
        }
        number = in.nextInt();
        return number;
    }

    //------- Проверка на ввод типа данных double --------
    public static double scannerDouble() {
        Scanner in = new Scanner(System.in);
        double number;
        System.out.print("Введите число: ");
        while (!in.hasNextDouble()) {
            in.next();
            System.out.println("Некорректный ввод!!!\nЧисло должно быть вещественым!");
            System.out.print("Введите число: ");
        }
        number = in.nextDouble();
        return number;
    }

    ////------- Для работы с массивами --------
    //------- Ввод массива пользователем --------
    public static void enterArrayUser(int[] array) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + i + "] --> ");
            array[i] = sc.nextInt();
        }
    }

    public static void enterArrayUser(double[] array) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + i + "] --> ");
            array[i] = sc.nextDouble();
        }
    }

    //------- Ввод массива случайными числами --------
    public static void enterArrayRandom(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (200 + 1)) - 100;
        }
    }

    public static void enterArrayRandom(double[] array) {
        for (int i = 0; i < array.length; i++) {
            double random_number = Math.random() * 20 - 10;
            array[i] = random_number;
        }
    }

    //------- Вывод элемнтов массива на консоль --------
    public static void printArray(int[] array) {
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("[%2d] = %4d\n", i, array[i]);
        }
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
    }

    public static void printArray(double[] array) {
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("[%2d] = %6.2f\n", i, array[i]);
        }
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
    }

    ////------- Для работы с матрицами --------
    //------- Ввод матрицы случайными числами --------
    public static void enterMatrixRandom(int[][] matrix, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) (Math.random() * (200 + 1)) - 100;
            }
        }
    }

    public static void enterMatrixRandom(double[][] matrix, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                double random_number = Math.random() * 20 - 10;
                matrix[i][j] = random_number;
            }
        }
    }

    //------- Вывод элемнтов матрицы на консоль --------
    public static void printMatrix(int[][] matrix, int m, int n) {
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("[%d][%d] = %3d ", i, j, matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
    }

    public static void printMatrix(double[][] matrix, int m, int n) {
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("[%d][%d] = %5.2f ", i, j, matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
    }

    // НОД (Наибольший общий делитель) или gcd (Greatest Common Divisor)
    public static int gcd(int a, int b) {

        while (a != 0 && b != 0) {
            if (a > b)
                a = a % b;
            else
                b = b % a;
        }

        return a + b;
    }

    // НОК (Наименьшее общее кратное) или lcm (Least Common Multiple)
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    // НОД (Наибольший общий делитель) для N чисел
    public static int gcdN(int[] array, int n) {

        int nod = 0;
        int nodForAll = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (i < n - 1) {
                nod = gcd(array[0], array[i + 1]);

                if (nodForAll > nod)
                    nodForAll = nod;
            }
        }

        return nodForAll;
    }

    // Метод вычисления площади правильного шестиугольника
    public static double squareOfRegularHexagon(double side) {
        double square = 0;

        square = ((3.0 * Math.sqrt(3.0)) / 2.0) * side * side;

        return square;
    }

    public static double maxPointDistance(double[][] point, int n) {

        double maxDistance = Double.MIN_VALUE;
        double distancePoint = 0;
        int imax = -1;
        int jmax = -1;

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {

                distancePoint = Math.sqrt(Math.pow((point[j][0] - point[i][0]), 2) +
                        Math.pow((point[j][1] - point[i][1]), 2));

                if (distancePoint > maxDistance) {
                    maxDistance = distancePoint;
                    imax = i;
                    jmax = j;
                }
            }

        System.out.printf("MAX растояния между точкой %2d и %2d точкой", imax + 1, jmax + 1);

        // maxDistance / 2 - проверил на листе бумаги надо делить
        return maxDistance / 2;
    }

}