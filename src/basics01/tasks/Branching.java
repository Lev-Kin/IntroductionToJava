package basics01.tasks;

public class Branching {
    public static void Tasks() {
        System.out.println("\t\t\t=== Ветвления ===\n");
        task01();
        task02();
        task03();
        task04();
        task05();
    }

    private static void task01() {
        System.out.println("1. Даны два угла треугольника (в градусах). Определить,\n" +
                "существует ли такой треугольник, и если да,\n" +
                "то будет ли он прямоугольным.");
        System.out.println("-------------------------------------------------------------");

        int cornerOne = 40;
        int cornerTwo = 50;
        int cornerThree = 180 - cornerOne - cornerTwo;

        System.out.println("Даны два угла: первый = " + cornerOne +
                "\u00b0, второй = " + cornerTwo + "\u00b0");

        if (cornerOne > 0 && cornerTwo > 0 && cornerThree > 0) {
            System.out.println("Треугольник существует");

            if (cornerOne == 90 || cornerTwo == 90 || cornerThree == 90)
                System.out.println("Треугольник прямоугольный");
            else
                System.out.println("Треугольник не прямоугольный");

        } else
            System.out.println("Треугольник не существует");

        System.out.println("=============================================================\n");
    }

    private static void task02() {
        System.out.println("2. Найти max{min(a, b), min(c, d)}");
        System.out.println("-------------------------------------------------------------");

        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        int partOne = 0;
        int partTwo = 0;

        System.out.println("При а = " + a + " b = " + b + " c = " + c + " d = " + d);
//        int result = Math.max(Math.min(a, b), Math.min(c, d));
//        System.out.println("max{min(a, b), min(c, d)} = " + result);

        if (a < b)
            partOne = a;
        else
            partOne = b;

        if (c < d)
            partTwo = c;
        else
            partTwo = d;

        if (partOne > partTwo)
            System.out.println("max{min(a, b), min(c, d)} = " + partOne);
        else
            System.out.println("max{min(a, b), min(c, d)} = " + partTwo);

        System.out.println("=============================================================\n");
    }

    private static void task03() {
        System.out.println("3. Даны три точки А(x1, y1), B(x2, y2) и C(x3, x3).\n" +
                "Определить, будут ли они расположены на одной прямой.");
        System.out.println("-------------------------------------------------------------");

        int x1 = 1;
        int x2 = 2;
        int x3 = 3;
        int y1 = 1;
        int y2 = 2;
        int y3 = 3;

        if (((x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3)) == 0)
            System.out.println("Точки А, B, C расположены на одной прямой.");
        else
            System.out.println("Точки А, B, C не расположены на одной прямой.");

        System.out.println("=============================================================\n");
    }

    private static void task04() {
        System.out.println("4. Заданы размеры А, В прямоугольного отверстия и размеры\n" +
                "х, у, z кирпича.\n" +
                "Определить, пройдет ли кирпич через отверстие.");
        System.out.println("-------------------------------------------------------------");

        int a = 8;
        int b = 12;

        int x = 27;
        int y = 7;
        int z = 12;

        System.out.println("Размеры отверстия (" + a + " X " + b + ").\n" +
                "Размеры кирпича (" + x + " X " + y + " X " + z + ")");
        if (x <= a && y <= b || y <= a && x <= b ||
                x <= a && z <= b || z <= a && x <= b ||
                z <= a && y <= b || y <= a && z <= b)
            System.out.println("Кирпич пройдет через отвертие.");
        else
            System.out.println("Кирпич не поройдет через отверстие.");

        System.out.println("=============================================================\n");
    }

    private static void task05() {
        System.out.println("5. Вычислить значение функции:\n" +
                "f(x) = x^2 - 3*x + 9, если x <= 3;\n" +
                "       1/(x^3 + 6),   если x >  3.");
        System.out.println("-------------------------------------------------------------");

        double x = 3;
        double fx = 0;

        System.out.println("при x = " + x);
        if (x <= 3)
            fx = x * x - 3 * x + 9;
        else
            fx = 1 / (Math.pow(x, 3) + 6);

        System.out.println("f(x) = " + fx);
        System.out.println("=============================================================\n");
    }
}