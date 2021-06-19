package basics01.tasks;

import java.math.BigInteger;

import static supporting.MyTools.scannerInt;

public class CycleProgram {
    public static void Tasks() {
        System.out.println("\t\t\t=== Циклы ===\n");
        task01();
        task02();
        task03();
        task04();
        task05();
        task06();
        task07();
        task08();
    }

    private static void task01() {
        System.out.println("1. Напишите программу, где пользователь вводит любое целое\n" +
                "положительное число. А программа суммирует все числа от 1 \n" +
                "до введенного пользователем числа.");
        System.out.println("-------------------------------------------------------------");

        int a = 0;
        do {
            a = scannerInt();
            if (a <= 0)
                System.out.println("Число должно быть положительным!");
        } while (a <= 0);

        System.out.println("при a = " + a);
        int i = 1;
        int sum = 0;
        while (i <= a) {
            sum += i;
            i++;
        }

        System.out.println("Сумма чисел от 1 до " + a + " равна " + sum);
        System.out.println("=============================================================\n");
    }

    private static void task02() {
        System.out.println("1. Вычислить значения функции на отрезке [a, b] с шагом h:\n" +
                "y = x, x > 2\n" +
                "    -x, x <= 2.");
        System.out.println("-------------------------------------------------------------");

        int a = -5;
        int b = 11;
        int h = 2;
        int y = 0;

        for (int i = a; i <= b; i += h) {
            if (i > 2) {
                y = i;
            } else {
                y = i * (-1);
            }
        }

        System.out.printf("При отрезке [%d, %d] c шагом %d: y = %d\n", a, b, h, y);
        System.out.println("=============================================================\n");
    }

    private static void task03() {
        System.out.println("3. Найти сумму квадратов первых ста чисел.");
        System.out.println("-------------------------------------------------------------");

        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i * i;
        }

        System.out.println("Сумма квадратов первых ста чисел = " + sum);
        System.out.println("=============================================================\n");
    }

    private static void task04() {
        System.out.println("4. Составить программу нахождения произведения квадратов\n" +
                "первых духсот чисел.");
        System.out.println("-------------------------------------------------------------");

        BigInteger product = BigInteger.valueOf(1);
        for (int i = 2; i <= 200; i++) {
            product = product.multiply(BigInteger.valueOf((long) i * i));
        }

        System.out.println("Проивидение квадратов первых духсот чисел равно - ");
        System.out.println(product);
        System.out.println("=============================================================\n");
    }

    private static void task05() {
        System.out.println("5. Даны числовой ряд и некоторое число e. Найти сумму тех\n" +
                "членов ряда, модуль которых больше или равен заданному e.\n" +
                "Общий член ряда имеет вид: An = 1/2^n + 1/3^n");
        System.out.println("-------------------------------------------------------------");

        double sum = 0.0;
        double e = 0.01;
        double an = 0.0;
        int n = 42;

        for (int i = 1; i <= n; i++) {
            an = (1 / Math.pow(2, i)) + (1 / Math.pow(3, i));
            if (Math.abs(an) >= e) {
                sum += an;
            }
        }

        System.out.println("Сумма равна " + sum);
        System.out.println("=============================================================\n");
    }

    private static void task06() {
        System.out.println("6. Вывести на экран сооветсвий между символами и их численными\n" +
                "обозначениями в памяти компьютера.");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Численое заначение\t|  Соответвующий символ");
        System.out.println("-------------------------------------------------------------");
        for (int i = 32; i <= 126; i++) {
            System.out.println("\t\t" + i + "\t\t\t|\t\t\t" + (char) i);
        }
        System.out.println("=============================================================\n");
    }

    private static void task07() {
        System.out.println("7. Для каждого натурального числа в промежутке от m до n\n" +
                "вывести все делители, кроме единицы и самого числа.\n" +
                "m и n вводятся с клавятуры.");
        System.out.println("-------------------------------------------------------------");

        int m = 0;
        int n = 0;
        int a = 0;
        int b = 0;
        int i = 0;
        int t = 0;

        System.out.println("Натуральное число m:");
        m = scannerInt();
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        System.out.println("Натуральное число n:");
        n = scannerInt();
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        a = Math.abs(m);
        b = Math.abs(n);

        if (a > b) {
            t = a;
            a = b;
            b = t;
        }

        System.out.printf("Получен следущий промежуток [%d ... %d]\n", a, b);
        System.out.print("Выводим все делители в заданном промежутке:");
        while (a <= b) {
            System.out.print("\n" + a + "\t->\t");
            for (i = 1; i <= a; i++) {
                if (a % i == 0)
                    if (!(i == 1 || i == a))
                        System.out.print(i + " ");
            }
            a++;
        }

        System.out.println("");
        System.out.println("=============================================================\n");
    }

    private static void task08() {
        System.out.println("8. Даны два числа. Определить цифры, входящие в запись как\n" +
                "первого так и второго числа.");
        System.out.println("-------------------------------------------------------------");

        int a = 78651020;
        int b = 367220414;

        boolean one = true;
        boolean two = true;
        boolean three = true;
        boolean four = true;
        boolean five = true;
        boolean six = true;
        boolean seven = true;
        boolean eight = true;
        boolean nine = true;
        boolean zero = true;

        System.out.println("Число а = " + a);
        System.out.println("Число b = " + b);

        int la = 0;
        int lb = 0;

        int reverseA = 0;
        while (a != 0) {
            reverseA = reverseA * 10 + a % 10;
            a /= 10;
            la++;
        }

        int reverseB = 0;
        while (b != 0) {
            reverseB = reverseB * 10 + b % 10;
            b /= 10;
            lb++;
        }

        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        System.out.println("Цифры входяшие как в первое так и во второе число:");
        int tempReversB = reverseB;
        while (reverseA != 0) {
            int digitA = reverseA % 10;
            reverseA /= 10;

            reverseB = tempReversB;
            while (reverseB != 0) {
                int digitB = reverseB % 10;
                reverseB /= 10;

                if (digitA == digitB) {
                    switch (digitA) {
                        case 1:
                            if (one) {
                                System.out.print(" 1 ");
                                one = false;
                            }
                            break;
                        case 2:
                            if (two) {
                                System.out.print(" 2 ");
                                two = false;
                            }
                            break;
                        case 3:
                            if (three) {
                                System.out.print(" 3 ");
                                three = false;
                            }
                            break;
                        case 4:
                            if (four) {
                                System.out.print(" 4 ");
                                four = false;
                            }
                            break;
                        case 5:
                            if (five) {
                                System.out.print(" 5 ");
                                five = false;
                            }
                            break;
                        case 6:
                            if (six) {
                                System.out.print(" 6 ");
                                six = false;
                            }
                            break;
                        case 7:
                            if (seven) {
                                System.out.print(" 7 ");
                                seven = false;
                            }
                            break;
                        case 8:
                            if (eight) {
                                System.out.print(" 8 ");
                                eight = false;
                            }
                            break;
                        case 9:
                            if (nine) {
                                System.out.print(" 9 ");
                                nine = false;
                            }
                            break;
                        default:
                            if (zero) {
                                System.out.print(" 0 ");
                                zero = false;
                            }
                            break;
                    }
                }
            }
        }

        System.out.println("");
        System.out.println("=============================================================\n");
    }
}
