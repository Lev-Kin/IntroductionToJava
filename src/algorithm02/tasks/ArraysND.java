package algorithm02.tasks;

import static supporting.MyTools.enterMatrixRandom;
import static supporting.MyTools.printMatrix;

public class ArraysND {
    public static void Tasks() {
        System.out.println("\t\t\t=== Массивы массивов ===\n");
        task01();
        task02();
//        task03();
//        task04();
//        task05();
//        task06();
//        task07();
//        task08();
//        task09();
//        task10();
    }

    private static void task01() {
        System.out.println("1. Дана матрица. Вывести на экран все нечетные столбцы,\n" +
                "у которых первый элемент больше последнего.");
        System.out.println("-------------------------------------------------------------");

        int m = 5;
        int n = 5;

        int[][] matrix = new int[m][n];

        System.out.println("Дана матрица " + m + " X " + n);
        enterMatrixRandom(matrix, m, n);
        printMatrix(matrix, m, n);

        System.out.println("Выводим все нечетные столбцы, у которых первый элемент\n" +
                "больше последниего:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j += 2) {
                if (matrix[0][j] > matrix[m - 1][j]) {
                    System.out.printf("[%d][%d] = %3d ", i, j, matrix[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println("=============================================================\n");
    }

    private static void task02() {
        System.out.println("2. Дана квадратная матрица. Вывести на экран элементы,\n" +
                "стоящие на диагонали.");
        System.out.println("-------------------------------------------------------------");

        System.out.println("=============================================================\n");
    }


}
