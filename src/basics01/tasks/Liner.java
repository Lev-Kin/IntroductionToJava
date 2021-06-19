package basics01.tasks;

public class Liner {
    public static void Tasks() {
        System.out.println("\t\t\t=== Линейные программы ===\n");
        task01();
        task02();
        task03();
        task04();
        task05();
        task06();
    }

    private static void task01() {
        System.out.println("1. Найдите значение функции: z = ( (a – 3 ) * b / 2) + c.");
        System.out.println("-------------------------------------------------------------");
        double a = 9;
        double b = 11;
        double c = 4;
        double z = ((a - 3.0) * b / 2.0) + c;
        System.out.println("при a = " + a + " b = " + b + " c = " + c);
        System.out.println("Значение функции z = " + z);
        System.out.println("=============================================================\n");
    }

    private static void task02() {
        System.out.println("2. Вычислить значения выражения по формуле\n" +
                "(все переменные принимают действительные значения):\n" +
                "(b + \u221Ab^2 + 4*a*c)/2*a) - (a^3*c + b^-2)");
        System.out.println("-------------------------------------------------------------");
        double a = 9;
        double b = 11;
        double c = 4;
        double z = (b + Math.sqrt(b * b + 4 * a * c)) / (2 * a) - (Math.pow(a, 3) * c + Math.pow(b, -2));
        System.out.println("при a = " + a + " b = " + b + " c = " + c);
        System.out.println("Значение функции z = " + z);
        System.out.println("=============================================================\n");
    }

    private static void task03() {
        System.out.println("3. Вычислить значение выражения по формуле\n" +
                "(все переменные принимают действительные значения):\n" +
                "(sin(x) + cos(y))/(cos(x) - sin(y)) * tg(xy)");
        System.out.println("-------------------------------------------------------------");
        double x = 9;
        double y = 11;
        double z = (Math.sin(x) + Math.cos(y)) / (Math.cos(x) - Math.sin(y)) * (Math.tan(x) * Math.tan(y));
        System.out.println("при x = " + x + " y = " + y);
        System.out.println("Значение функции z = " + z);
        System.out.println("=============================================================\n");
    }

    private static void task04() {
        System.out.println("4. Дано действительное число R вида nnn.ddd\n" +
                "(три цифровых разряда в дробной и целой частях).\n" +
                "Поменять местами дробную и целую части числа и\n" +
                "вывести полученное занчение числа.");
        System.out.println("-------------------------------------------------------------");
        double r = 123.754;
        System.out.println("Исходное число R = " + r);
        int partOne = (int) r;
        int partTwo = (int) ((r - partOne) * 1000);
        System.out.println("Меняем местами дробную и целую части числа R");
        double result = partTwo + partOne * 0.001;
        System.out.println("Получаем число R = " + result);
        System.out.println("=============================================================\n");
    }

    private static void task05() {
        System.out.println("5. Дано натуральное число Т, которое представляет длительность\n" +
                "прошедшего времени в секундах. Вывести данное значение \n" +
                "длительности в часах, минутах и секундах в седующей форме:\n" +
                "ННч ММм SSс.");
        System.out.println("-------------------------------------------------------------");
        int t = 42424;
        int s = t % 60;
        int tm = t / 60;
        int mm = (t / 60) % 60;
        int hh = tm / 60;
        System.out.println("при T = " + t);
        System.out.printf("Время: %dч %dм %dс.\n", hh, mm, s);
        System.out.println("=============================================================\n");
    }

    private static void task06() {
        System.out.println("6. Для данной области составить линейную программу, каторая\n" +
                "печатает true, если точка с координатами (x, y) принадлежит\n" +
                "закрашенной области, и false - в противном случае:");
        System.out.println("-------------------------------------------------------------");
        int x = 0;
        int y = -1;
        System.out.println("при x = " + x + " при y = " + y);
        if ((x < 4) && (x > -4)) {
            if ((y < 4) && (y > -3)) {
                if ((y > 0) && ((x < 4) && (x > -4)))
                    System.out.println("false");
                else
                    System.out.println("true");
            } else
                System.out.println("false");
        } else
            System.out.println("false");
        System.out.println("=============================================================\n");
    }
}