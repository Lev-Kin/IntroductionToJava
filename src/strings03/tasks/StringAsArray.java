package strings03.tasks;

import java.util.Arrays;

import static supporting.MyMethodsString.convertCamelCaseInSnakeCase;

public class StringAsArray {
    public static void Tasks() {
        System.out.println("\t=== Работа со строкой как с массивом символ ===\n");
        task01();
        task02();
//        task03();
//        task04();
//        task05();
//        task06();
    }

    private static void task01() {
        System.out.println("1. Дан массив названий переменных в camelCase.\n" +
                "Преобразовать названия в snake_case.");
        System.out.println("-------------------------------------------------------------");

        String[] camelCaseWord = {"penRed", "amountNumbers", "superMaximumPrice", "noteWrite"
                , "luxurySpaRelax", "coldWinter", "rainyAtumn"};

        System.out.println("Дан массив названий переменных в camelCase.");
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        for (int i = 0; i < camelCaseWord.length; i++)
            System.out.println(camelCaseWord[i]);
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.println("Преобразовываем camelCase в snake_case.");
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        String[] result = convertCamelCaseInSnakeCase(camelCaseWord);

        for (int i = 0; i < result.length; i++)
            System.out.println(result[i]);

//        String str = Arrays.toString(result);
//        System.out.println();
//        System.out.println(str);
        System.out.println("=============================================================\n");
    }

    private static void task02() {
        System.out.println("2. Замените в строке все вхождения 'word' на 'letter'.");
        System.out.println("-------------------------------------------------------------");


        System.out.println("=============================================================\n");
    }


}
