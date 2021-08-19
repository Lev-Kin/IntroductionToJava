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
            b = second;

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

    public static int amountDigitsOfNumbers(int n) {

        int amountDigits = 0;

        while (n > 0) {
            n /= 10;
            amountDigits++;
        }

        return amountDigits;
    }

    public static int[] digitsOfNumbersInArray(int n) {

        int amountDigit = amountDigitsOfNumbers(n);
        int[] arrayDigits = new int[amountDigit];
        int digit = 0;

        int divider = 1;
        int k = 1;

        while (k != amountDigit) {
            divider *= 10;
            k++;
        }

        for (int i = 0; i < arrayDigits.length; i++) {

            digit = n / divider;

            while (digit >= 10)
                digit %= 10;

            arrayDigits[i] = digit;

            divider /= 10;
        }

        return arrayDigits;
    }

    // Метод определяющий, в коком из данных двух чисел больше цифр
    public static int longerNumberOfTwo(int a, int b) {
        int longerNumger = 0;

        int amountDigitsA = amountDigitsOfNumbers(a);
        int amountDigitsB = amountDigitsOfNumbers(b);

        if (amountDigitsA > amountDigitsB)
            longerNumger = a;
        else if (amountDigitsA < amountDigitsB)
            longerNumger = b;
        else
            return -1;

        return longerNumger;
    }

    // Сумма цифр натурального числа
    public static int sumDigitsOfNumber(int a) {
        int sumDigits = 0;

        int[] array = digitsOfNumbersInArray(a);

        for (int i = 0; i < array.length; i++)
            sumDigits += array[i];

        return sumDigits;
    }

    // Метод формирования массива А для 12 задания (2. Algorithmization - Декомпозиция)
    public static int[] arrayDigitsSumKminN(int k, int n) {

        int count = 0;
        int cheсkSumK = 0;

        for (int i = 1; i < n; i++) {

            cheсkSumK = sumDigitsOfNumber(i);

            if (cheсkSumK == k) {
                count++;
            }
        }

        int[] array = new int[count];
        int j = 0;
        cheсkSumK = 0;

        for (int i = 1; i < n; i++) {

            cheсkSumK = sumDigitsOfNumber(i);

            if (cheсkSumK == k) {
                array[j] = i;

                j++;
            }
        }

        return array;
    }

    // Проверка является ли чило простым
    public static boolean isPrimeNumber(int n) {
        if (n > 1) {
            for (int i = 2; i < n; i++) {
                if (n % i == 0)
                    return false;
            }

        } else
            return false;

        return true;
    }

    // Проверка являются ли числа "близницами"
    public static int[][] twinsPrimeNumberArray(int a, int b) {

        int cout = 0;

        for (int i = a; i < b; i++) {
            if (isPrimeNumber(i) == true && isPrimeNumber(i + 2) == true) {
                cout++;
            }
        }

        int[][] arrayTwins = new int[cout][2];

        int j = 0;

        for (int i = a; i < b; i++) {
            if (isPrimeNumber(i) == true && isPrimeNumber(i + 2) == true) {
                arrayTwins[j][0] = i;
                arrayTwins[j][1] = i + 2;
                j++;
            }
        }

        return arrayTwins;
    }

    // метод проверки на число Амстронга
    public static boolean isArmstrongNumber(int n) {

        int[] digit = digitsOfNumbersInArray(n);

        double sumCubeDigit = 0;

        for (int i = 0; i < digit.length; i++) {
            sumCubeDigit += Math.pow(digit[i], digit.length);
        }

        if (sumCubeDigit != n)
            return false;

        return true;
    }

    // Для 16 задания (2. Algorithmization - Декомпозиция)
    public static int sumOfOddNumbers(int n) {

        int startNumber = (int) Math.pow(10, n - 1);
        int sumOfOddNumbers = 0;

        for (int number = startNumber; number < startNumber * 10; number++) {

            int temp = number;
            int numberLength = amountDigitsOfNumbers(number);

            while (temp != 0) {
                if ((temp % 10) % 2 != 0) {
                    numberLength--;
                }

                temp /= 10;
            }

            if (numberLength == 0) {
                sumOfOddNumbers += number;
            }
        }

        return sumOfOddNumbers;
    }

    // Количество четных цифр натурального числа
    public static int amountEvenDigitsOfNumber(int a) {

        int amountEvenDigits = 0;

        int[] array = digitsOfNumbersInArray(a);

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0)
                amountEvenDigits++;
        }

        return amountEvenDigits;
    }

}