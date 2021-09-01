package strings03.tasks;

import static supporting.MyMethodsString.*;

public class StringAsArray {
    public static void Tasks() {
        System.out.println("\t=== Работа со строкой как с массивом символ ===\n");
        task01();
        task02();
        task03();
        task04();
        task05();
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

        String text = "12 abc5efor6 123 wor77d 8ab5wo3r 0 wor1  pd word.9  1234";

        System.out.println("Дан текст:");
        System.out.println(text);
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        int amountDigit = 0;

        char[] textArray = text.toCharArray();

        for (int i = 0; i < textArray.length; i++) {
            if (isDigitInText(textArray[i]) == true) {
                amountDigit++;
            }
        }

        System.out.println("Количество цифр в строке = " + amountDigit);
        System.out.println("=============================================================\n");
    }

    private static void task04() {
        System.out.println("4. В строке найти количество чисел.");
        System.out.println("-------------------------------------------------------------");

        String text = "1 22 abc5efor6 7g 123 wor77d 8ab5wo3r 0 wor1  pd word.9  1234 14";

        System.out.println("Дан текст:");
        System.out.println(text);
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        int amountRealNumber = amountRealNumberInText(text);

        System.out.println("Количество чисел в строке = " + amountRealNumber);
        System.out.println("=============================================================\n");
    }

    private static void task05() {
        System.out.println("5. Удалить в строке все лишние пробелы, то есть серии подряд\n" +
                "идущих пробелов заменить на одиночные пробелы.\n" +
                "Крайние пробелы в строке удалить.");
        System.out.println("-------------------------------------------------------------");

        String text = " 1  22 abc5r6 7g 13   wor77d  8ab53r 0   wor1  pd word.9  1   ";

        System.out.println("Дан текст:");
        System.out.println(text);
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.println("Удаляем все дублирующийся пробелы и все крайнее:");

        String editedText = spaceCutDuplicateAndCutAllInBack(text);

        System.out.println(editedText);
        System.out.println("=============================================================\n");
    }
}
