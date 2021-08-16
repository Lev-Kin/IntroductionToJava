package supporting;

public class МуMethods {

    // НОД (Наибольший общий делитель) или gcd (Greatest Common Divisor)
    public static int gcd(int first, int second) {

        int a;
        int b;

        if (first < 0)
            a = Math.abs(first);
        else
            a = first;

        if (second < 0)
            b = Math.abs(second);
        else
            b = first;

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

    // Метод взаимно простые числа
    public static boolean numbersCoprime(int[] array, int n) {
        int nodN = gcdN(array, n);

        if (nodN == 1) {
            return true;
        }

        return false;
    }

    public static long sumFactorialOdd(int n) {

        long sum = 0;
        long factorial = 1;

        for (int i = 1; i <= n; i++) {
            factorial *= i;
            if (i % 2 != 0) sum += factorial;
        }
        return sum;
    }

    public static int sumGapKM(int[] array, int k, int m) {
        int sum = 0;

        for (int i = k; i < m + 1; i++) {
            sum = array[i] + sum;
        }

        return sum;
    }

    public static double squareOfQuadrangle(double a, double b, double c, double d) {

        // Находим площадь первой части четырехугольника
        double s1 = (a * b) / 2.0;
        double t = Math.sqrt(a * a + b * b);

        // Находим площадь второй части четырехугольника
        double p = (c + d + t) / 2.0;
        double s2 = Math.sqrt(p * (p - c) * (p - d) * (p - t));

        return (s1 + s2);
    }



}
