package algorithm02.tasks;

import static supporting.MyTools.*;

public class Decomposition {
    public static void Tasks() {
        System.out.println("\t\t=== Декомпозиция с использованием метов ===\n");
        //task01();
        task02();
//        task03();
//        task04();
//        task05();
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


}
