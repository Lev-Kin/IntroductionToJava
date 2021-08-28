package strings03.tasks;

import static supporting.MyMethodsString.convertCamelCaseInSnakeCase;
import static supporting.MyMethodsString.replaceWordAnoterWordInText;

public class StringAsArray {
    public static void Tasks() {
        System.out.println("\t=== Работа со строкой как с массивом символ ===\n");
        task01();
        task02();
        task03();
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

        String text = "word abcdefword abc word abwor a word worl  pd word.   word";
        String wordGiven = "word";
        String wordReplace = "letter";

        System.out.println("Дан текст:");
        System.out.println(text);
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.println("Заменяем все слова " + wordGiven + " в тексте на " + wordReplace + ":");
        String changeText = replaceWordAnoterWordInText(text, wordGiven, wordReplace);
        System.out.println(changeText);
        System.out.println("=============================================================\n");
    }

    private static void task03() {
        System.out.println("3. В строке найти количество цифр.");
        System.out.println("-------------------------------------------------------------");

        System.out.println("=============================================================\n");
    }

}
