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
            System.out.print("A[" + i + "] --> ");
            array[i] = sc.nextInt();
        }
    }

    public static void enterArrayUser(double[] array) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.print("A[" + i + "] --> ");
            array[i] = sc.nextDouble();
        }
    }

    //------- Ввод массива случайными числами --------
    public static void enterArrayRandomInt(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (200 + 1)) - 100;
        }
    }

    public static void enterArrayRandomDouble(double[] array) {
        for (int i = 0; i < array.length; i++) {
            double random_number = Math.random() * 20 - 10;
            array[i] = random_number;
        }
    }

    //------- Вывод элемнтов массива на консоль --------
    public static void printArray(int[] array) {
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("A[%2d] = %4d\n", i, array[i]);
        }
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
    }

    public static void printArray(double[] array) {
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("A[%2d] = %6.2f\n", i, array[i]);
        }
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
    }

}

