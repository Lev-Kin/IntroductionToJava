package u02algorithm.tasks;

import static supporting.MyTools.*;

public class ArraysND {
    public static void Tasks() {
        System.out.println("\t\t\t=== Массивы массивов ===\n");
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

    private static void task04() {
        System.out.println("4. Сформировать квадратную матрицу порядка n\n" +
                "по заданному образцу(n - четное):");
        System.out.println("-------------------------------------------------------------");

        int n = 4;
        int[][] matrix = new int[n][n];

        System.out.println("Дана матрица " + n + " X " + n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0)
                    matrix[i][j] = j + 1;
                else
                    matrix[i][j] = n - j;
            }
        }

        printMatrix(matrix, n, n);
        System.out.println("=============================================================\n");
    }

    private static void task05() {
        System.out.println("5. Сформировать квадратную матрицу порядка n\n" +
                "по заданному образцу(n - четное):");
        System.out.println("-------------------------------------------------------------");

        int n = 4;
        int[][] matrix = new int[n][n];

        System.out.println("Дана матрица " + n + " X " + n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                matrix[i][j] = i + 1;
            }
//            for (int j = n - i; j < n; j++) {
//                matrix[i][j] = 0;
//            }
        }

        printMatrix(matrix, n, n);
        System.out.println("=============================================================\n");
    }

    private static void task06() {
        System.out.println("6. Сформировать квадратную матрицу порядка n\n" +
                "по заданному образцу(n - четное):");
        System.out.println("-------------------------------------------------------------");

        int n = 14;
        int[][] matrix = new int[n][n];

        System.out.println("Дана матрица " + n + " X " + n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (((i <= j) && (j <= n - i - 1)) ||
                        ((i >= j) && (j >= n - i - 1)))
                    matrix[i][j] = 1;
                else
                    matrix[i][j] = 0;
            }
        }

        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d ", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        //printMatrix(matrix, n, n);
        System.out.println("=============================================================\n");
    }

    private static void task07() {
        System.out.println("7. Сформировать квадратную матрицу порядка n по правилу:\n" +
                "A[i, j] = sin((i*i - j*j)/n)\n" +
                "и подсчитать количество положительных элементов в ней.");
        System.out.println("-------------------------------------------------------------");

        int n = 10;
        double[][] matrix = new double[n][n];
        int positiveElements = 0;

        System.out.println("Дана матрица " + n + " X " + n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Math.sin((i * i - j * j) / n);
                if (matrix[i][j] > 0)
                    positiveElements++;
            }
        }

        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%6.2f", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.println("Количество положительных элементов в матрице = " + positiveElements);
        System.out.println("=============================================================\n");
    }

    private static void task08() {
        System.out.println("8. В числовой матрице поменять местами два столбца любых\n" +
                "столбца, т. е. все элементы одного столбца поставить на\n" +
                "соответствующие им позиции другого, а его элементы второго\n" +
                "переместить в первый.\n" +
                "Номера столбцов вводитпользователь с клавиатуры.");
        System.out.println("-------------------------------------------------------------");

        int m = 7;
        int n = 5;
        int k = 0;
        int p = 0;

        int[][] matrix = new int[m][n];

        System.out.println("Дана матрица " + m + " X " + n);
        enterMatrixRandom(matrix, m, n);
        printMatrix(matrix, m, n);

        do {
            System.out.println("\n1) Индекс столбеца матрицы каторый поменять:");
            k = scannerInt();
            if ((k + 1) > n || k < 0)
                System.out.println("Индекс числа выходит за приделы матрицы! от 0 до " + (n - 1));
        } while ((k + 1) > n || k < 0);
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        do {
            System.out.println("\n2) Индекс столбеца матрицы с каторым поменять:");
            p = scannerInt();
            if ((p + 1) > n || p < 0)
                System.out.println("Индекс числа выходит за приделы матрицы! oт 0 до " + (n - 1));
        } while ((p + 1) > n || p < 0);
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.printf("Меняем местами %d столбец c %d столбцом.\n", k, p);
        for (int i = 0; i < m; i++) {
            int temp = matrix[i][k];
            matrix[i][k] = matrix[i][p];
            matrix[i][p] = temp;
        }

        printMatrix(matrix, m, n);

        System.out.println("=============================================================\n");
    }

    private static void task09() {
        System.out.println("9. Задана матрица неотрицательных чисел.\n" +
                "Посчитать сумму элементов в каждом столбце.\n" +
                "Определить, какой столбец содержит максимальную сумму.");
        System.out.println("-------------------------------------------------------------");

        int m = 7;
        int n = 5;

        int sum = 0;
        int sumMax = Integer.MIN_VALUE;
        int indexMaxSum = 0;

        int[][] matrix = new int[m][n];

        System.out.println("Дана матрица " + m + " X " + n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) (Math.random() * 100);
            }
        }
        printMatrix(matrix, m, n);

        System.out.println("Считаем сумму элемнтов в каждом столбце:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum += matrix[j][i];
            }

            System.out.println("Cумма " + i + " столбца = " + sum);

            if (sum > sumMax) {
                sumMax = sum;
                indexMaxSum = i;
            }
            sum = 0;
        }

        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        System.out.println("Номер столбца с максимальной суммой = " + indexMaxSum);
        System.out.println("=============================================================\n");
    }

    private static void task10() {
        System.out.println("10. Найти положительные элементы главной диагонали\n" +
                "квадратной матрицы.");
        System.out.println("-------------------------------------------------------------");

        int m = 5;
        int n = 5;

        int[][] matrix = new int[m][n];

        System.out.println("Дана матрица " + m + " X " + n);
        enterMatrixRandom(matrix, m, n);
        printMatrix(matrix, m, n);

        System.out.println("Положительные элементы главной диагонали:");
        for (int i = 0; i < m; i++)
            if (matrix[i][i] > 0)
                System.out.printf("[%d][%d] = %3d\n", i, i, matrix[i][i]);
        System.out.println("=============================================================\n");
    }

    private static void task11() {
        System.out.println("11. Матрицу 10x20 заполнить случайными числами от 0 до 15.\n" +
                "Вывести на экран саму матрицу и номера строк, в\n" +
                "которых число 5 встречается три и более раз.");
        System.out.println("-------------------------------------------------------------");

        int m = 10;
        int n = 20;
        int k = 0;

        int[][] matrix = new int[m][n];
        int[] row = new int[m];
        int countNumberFive = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) (Math.random() * (15 + 1));
            }
        }

        System.out.println("Дана матрица " + m + " X " + n);
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                System.out.printf(" %2d ", matrix[i][j]);

                if (matrix[i][j] == 5)
                    countNumberFive++;
            }
            if (countNumberFive >= 3) {
                row[k] = i;
                k++;
            }

            countNumberFive = 0;
            System.out.println();
        }
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.println("Нормера строк, в которых число 5 встречается три и более раз.");
        for (int i = 0; i < k; i++) {
            System.out.printf("Строка %d\n", row[i]);
        }
        System.out.println("=============================================================\n");
    }

    private static void task12() {
        System.out.println("12. Отсортировать строки матрицы \n" +
                "по возрастанию и убыванию значений элементов.");
        System.out.println("-------------------------------------------------------------");

        int m = 5;
        int n = 5;

        int[][] matrix = new int[m][n];

        System.out.println("Дана матрица " + m + " X " + n);
        enterMatrixRandom(matrix, m, n);
        printMatrix(matrix, m, n);

        System.out.println("Сортируем строки матрицы по возрастанию элементов:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n - 1; k++) {
                    if (matrix[i][k + 1] < matrix[i][k]) {
                        int temp = matrix[i][k + 1];
                        matrix[i][k + 1] = matrix[i][k];
                        matrix[i][k] = temp;
                    }
                }
            }
        }
        printMatrix(matrix, m, n);

        System.out.println("Сортируем строки матрицы по убыванию элементов:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n - 1; k++) {
                    if (matrix[i][k + 1] > matrix[i][k]) {
                        int temp = matrix[i][k + 1];
                        matrix[i][k + 1] = matrix[i][k];
                        matrix[i][k] = temp;
                    }
                }
            }
        }
        printMatrix(matrix, m, n);
        System.out.println("=============================================================\n");
    }

    private static void task13() {
        System.out.println("13. Отсортировать столбцы матрицы\n" +
                "по возрастанию и убыванию значений элементов.");
        System.out.println("-------------------------------------------------------------");

        int m = 5;
        int n = 5;

        int[][] matrix = new int[m][n];

        System.out.println("Дана матрица " + m + " X " + n);
        enterMatrixRandom(matrix, m, n);
        printMatrix(matrix, m, n);

        System.out.println("Сортируем столбцы матрицы по возрастанию элементов:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n - 1; k++) {
                    if (matrix[k + 1][j] < matrix[k][j]) {
                        int temp = matrix[k + 1][j];
                        matrix[k + 1][j] = matrix[k][j];
                        matrix[k][j] = temp;
                    }
                }
            }
        }
        printMatrix(matrix, m, n);

        System.out.println("Сортируем столбцы матрицы по убыванию элементов:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n - 1; k++) {
                    if (matrix[k + 1][j] > matrix[k][j]) {
                        int temp = matrix[k + 1][j];
                        matrix[k + 1][j] = matrix[k][j];
                        matrix[k][j] = temp;
                    }
                }
            }
        }
        printMatrix(matrix, m, n);
        System.out.println("=============================================================\n");
    }

    private static void task14() {
        System.out.println("14. Сформировать случайную матрицу m x n, состоящую из нулей\n" +
                "и единиц, причем в каждом столбце число единиц равно номеру\n" +
                "столбца по возрастанию и убыванию значений элементов.");
        System.out.println("-------------------------------------------------------------");

        int m = (int) (Math.random() * 6 + 2);
        int n = (int) (Math.random() * 6 + 2);

        if (m < n) {
            int t = m;
            m = n;
            n = t;
        }

        int[][] matrix = new int[m][n];

        System.out.println("Дана матрица " + m + " X " + n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
                if (i < n && i <= j) {
                    for (int h = i; h > 0; h--) {
                        matrix[h][j] = 1;
                    }
                }
            }
        }

        printMatrix(matrix, m, n);
        System.out.println("=============================================================\n");
    }

    private static void task15() {
        System.out.println("15. Найдите наибольший элемент матрицы и заменить все нечетные\n" +
                "элементы на него.");
        System.out.println("-------------------------------------------------------------");

        int m = 5;
        int n = 5;
        int maxElement = Integer.MIN_VALUE;

        int[][] matrix = new int[m][n];

        System.out.println("Дана матрица " + m + " X " + n);
        enterMatrixRandom(matrix, m, n);
        printMatrix(matrix, m, n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > maxElement)
                    maxElement = matrix[i][j];
            }
        }

        System.out.println("Max элемент в матрице = " + maxElement);
        System.out.println("Заменяем все нечетные элементы на max элемент.");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] % 2 != 0)
                    matrix[i][j] = maxElement;
            }
        }
        printMatrix(matrix, m, n);
        System.out.println("=============================================================\n");
    }

    private static void task16() {
        System.out.println("16. Магическим квадратом порядка n называется квадратная\n" +
                "матрица размера nxn, составленная из чисел 1, 2, 3, ..., n2\n" +
                "так, что суммы по каждому столбцу, каждой строке и каждой из \n" +
                "двух больших диагоналей равны между собой.\n" +
                "Построить такой квадрат.");
        System.out.println("-------------------------------------------------------------");

        int n = 3;

        int[][] matrix = new int[n][n];

        System.out.println("Дана матрица " + n + " X " + n);
        System.out.println("Строим магический квадрат:");

        // "Сиамский метод"
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }

        int count = 1, y = 0, x = matrix.length / 2;

        while (true) {

            matrix[y][x] = count;
            count++;

            if (((y == 0) && (x >= n - 1)) && (matrix[n - 1][0] != 0)) {
                y++;
            } else {
                y--;
                if (y < 0) {
                    y = n - 1;
                }
                x++;
                if (x == n) {
                    x = 0;
                }
                if (matrix[y][x] != 0) {
                    y += 2;
                    x--;
                }
            }

            if (count == n * n + 1) break;
        }

        printMatrix(matrix, n, n);
        System.out.println("=============================================================\n");
    }
}