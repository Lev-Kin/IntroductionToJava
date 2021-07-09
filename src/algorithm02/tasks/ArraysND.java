package algorithm02.tasks;

import static supporting.MyTools.*;

public class ArraysND {
    public static void Tasks() {
        System.out.println("\t\t\t=== Массивы массивов ===\n");
        //task01();
        task02();
        task03();
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

        int m = 5;
        int n = 5;

        int[][] matrix = new int[m][n];

        System.out.println("Дана матрица " + m + " X " + n);
        enterMatrixRandom(matrix, m, n);
        printMatrix(matrix, m, n);

        System.out.println("Выводим все элементы, стоящие на диагонали.");
        for (int i = 0; i < m; i++)
            System.out.printf("[%d][%d] = %3d\n", i, i, matrix[i][i]);
//        for (int i = 0; i < m; i++) {
//            for (int j = n; j > -1; j--) {
//                if (i == j){
//                    System.out.printf("[%d][%d] = %3d ", i, j, matrix[i][j]);
//                    break;
//                }
//            }
//            System.out.println();
//        }
        System.out.println("=============================================================\n");
    }

    private static void task03() {
        System.out.println("3. Дана матрица. Вывести k-ю строку и p-й столбец матрицы.");
        System.out.println("-------------------------------------------------------------");

        int m = 5;
        int n = 5;
        int k = 0;
        int p = 0;

        int[][] matrix = new int[m][n];

        System.out.println("Дана матрица " + m + " X " + n);
        enterMatrixRandom(matrix, m, n);
        printMatrix(matrix, m, n);

        do {
            System.out.println("\nНеобходимо ввести число k строку матрицы");
            k = scannerInt();
            if ((k + 1) > m || k < 0)
                System.out.println("Число k выходит за приделы матрицы! от 0 до " + (m - 1));
        } while ((k + 1) > m || k < 0);
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        do {
            System.out.println("\nНеобходимо ввести число p столбца матрицы");
            p = scannerInt();
            if ((p + 1) > n || p < 0)
                System.out.println("Число p выходит за приделы матрицы! oт 0 до " + (n - 1));
        } while ((p + 1) > n || p < 0);

        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        System.out.println("Выводим k = " + k + " строку матрицы:");
        for (int i = 0; i < m; i++) {
            System.out.printf("[%d][%d] = %3d ", k, i, matrix[k][i]);
        }
        System.out.println();
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.println("Выводим p = " + p + " столбец матрицы:");
        for (int j = 0; j < n; j++) {
            System.out.printf("[%d][%d] = %3d\n", j, p, matrix[j][p]);
        }
        System.out.println("=============================================================\n");
    }


}
