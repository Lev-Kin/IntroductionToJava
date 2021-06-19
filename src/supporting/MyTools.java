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
}
