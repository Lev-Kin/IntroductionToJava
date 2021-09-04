package strings03.tasks;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringAsObject {
    public static void Tasks() {
        System.out.println("\t\t=== Работа со строкой как с объектом\n" +
                "\t\t    типа String или StringBuilder ===\n");
        task01();
        task02();
        task03();
        task04();
        task05();
        task06();
        task07();
        task08();
        task09();
        task10();
    }

    private static void task01() {
        System.out.println("1. Дан текст (строка). Найдите наибольшее количество подряд\n" +
                "идущих пробелов в нем.");
        System.out.println("-------------------------------------------------------------");

        String text = " 1  22 abc5r6 7a 13   waa77d  8ab53r 0   aoa1  pd word.9  1   ";

        System.out.println("Дан текст:");
        System.out.println(text);
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        int maxSpaceAmount = 0;
        int tmpSpaceAmount = 0;

        StringBuilder strBuilder = new StringBuilder(text);

        for (int i = 0; i < strBuilder.length(); i++) {

            if (strBuilder.charAt(i) == ' ') {
                tmpSpaceAmount++;

            } else if (strBuilder.charAt(i) != ' ') {
                maxSpaceAmount = Math.max(tmpSpaceAmount, maxSpaceAmount);
                tmpSpaceAmount = 0;
            }
        }

        System.out.println("Наибольшее количество подряд стоящих пробелов = " + maxSpaceAmount);
        System.out.println("=============================================================\n");
    }

    private static void task02() {
        System.out.println("2. В строке вставить после каждого символа 'a' символ 'b'.");
        System.out.println("-------------------------------------------------------------");

        String text = " 1  22 abc5r6 7a 13   waa77d  8ab53r 0   aoa1  pd word.9  1 a";

        System.out.println("Дан текст:");
        System.out.println(text);
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        StringBuilder strBuilder = new StringBuilder(text);

        for (int i = 0; i < strBuilder.length(); i++) {

            if (strBuilder.charAt(i) == 'a')
                strBuilder.insert(i + 1, 'b');
        }
        String.valueOf(strBuilder);

        System.out.println("Измереный текст:");
        System.out.println(strBuilder);
        System.out.println("=============================================================\n");
    }

    private static void task03() {
        System.out.println("3. Проверить, является ли заданное слово палиндромом.");
        System.out.println("-------------------------------------------------------------");

        String[] word = {"Qddf", "QfFq", "Ана", "Лето"};

        for (int i = 0; i < word.length; i++) {
            System.out.print("Слово: " + word[i]);

            String reverseWord = new StringBuilder(word[i]).reverse().toString();

            if (reverseWord.equalsIgnoreCase(word[i]))
                System.out.print("\t - является палиндромом.\n");
            else
                System.out.print("\t - не является палиндромом.\n");
        }

        System.out.println("=============================================================\n");
    }

    private static void task04() {
        System.out.println("4. C помощью функции копирования и операции конкатенации\n" +
                "составить из частей слова “информатика” слово “торт”.");
        System.out.println("-------------------------------------------------------------");

        String wordGiven = "информатика";
        String wordNeded = "торт";
        String resultWord = "";

        for (int i = 0; i < wordNeded.length(); i++) {
            for (int j = 0; j < wordGiven.length(); j++) {
                if (wordNeded.charAt(i) == wordGiven.charAt(j)) {
                    resultWord += String.copyValueOf(wordGiven.toCharArray(), j, 1);
                }
            }
        }

        System.out.println(resultWord);
        System.out.println("=============================================================\n");
    }

    private static void task05() {
        System.out.println("5. Подсчитать, сколько раз среди символов заданной строки\n" +
                "встречается буква “а”.");
        System.out.println("-------------------------------------------------------------");

        String text = " 1  22 abc5r6 7a 13   waa77d  8ab53r 0   aoa1  pd word.9  1 a";

        System.out.println("Дана строка:");
        System.out.println(text);
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        int countA = 0;
        for (int i = 0; i < text.length(); i++)
            if (text.charAt(i) == 'a')
                countA++;

        System.out.println("Количество встречающейся буквы \"a\" = " + countA);
        System.out.println("=============================================================\n");
    }

    private static void task06() {
        System.out.println("6. Из заданной строки получить новую,\n" +
                "повторив каждый символ дважды.");
        System.out.println("-------------------------------------------------------------");

        String text = "1  22 abc5r6 waa77d  8ab53r 0 pd word.9 a";

        System.out.println("Дана строка:");
        System.out.println(text);
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        StringBuilder strBuilder = new StringBuilder(text);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < strBuilder.length(); i++) {
            result.append(strBuilder.charAt(i));
            result.append(strBuilder.charAt(i));
        }

        System.out.println(result);
        System.out.println("=============================================================\n");
    }

    private static void task07() {
        System.out.println("7. Вводится строка. Требуется удалить из нее повторяющиеся\n" +
                "символы и все пробелы. Например, если было введено\n" +
                "\"abc cde def\", то должно быть выведено \"abcdef\".");
        System.out.println("-------------------------------------------------------------");

//        String str = "abc cde def";
//
//        System.out.println("Дана строка:");
//        System.out.println(str);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = null;

        System.out.print("Введите строку:\n[str] --> ");
        try {
            str = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        StringBuilder strBuilder = new StringBuilder(str);

        for (int i = 0; i < strBuilder.length(); i++) {

            char uniqueChar = strBuilder.charAt(i);

            // Удаляем пробелы
            if (uniqueChar == ' ') {
                strBuilder.deleteCharAt(i);
                i--;
                continue;
            }

            for (int j = i + 1; j < strBuilder.length(); j++) {
                if (strBuilder.charAt(j) == uniqueChar) {
                    strBuilder.deleteCharAt(j);
                }
            }
        }

        String.valueOf(strBuilder);
        System.out.println(strBuilder);
        System.out.println("=============================================================\n");
    }

    private static void task08() {
        System.out.println("8. Вводится строка слов, разделенных пробелами.\n" +
                "Найти самое длинное слово и вывести его на экран.\n" +
                "Случай, когда самых длинных слов может быть несколько,\n" +
                "не обрабатывать.");
        System.out.println("-------------------------------------------------------------");

//        String str = " 1  22 abc5r6 7a 13   waa77d  8ab53r 0   aoa1  pd word.9  1 a";
//
//        System.out.println("Дана строка:");
//        System.out.println(str);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = null;

        System.out.print("Введите строку слов разделеными пробелами:\n[str] --> ");
        try {
            str = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        String longestWord = "";
        int maxLenght = 0;

        String[] words = str.split(" ");

        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > maxLenght) {
                maxLenght = words[i].length();
                longestWord = words[i];
            }
        }

        System.out.println("Самое длиное слово в строке разделенае пробелами:");
        System.out.println(longestWord);
        System.out.println("=============================================================\n");
    }

    private static void task09() {
        System.out.println("9. Посчитать количество строчных (маленьких) и прописных\n" +
                "(больших) букв в введенной строке.\n" +
                "Учитывать только английские буквы.");
        System.out.println("-------------------------------------------------------------");

//        String str = " 1  22 Abc5r6 7a 13   waA77d  8ab53R 0   aoa1  Pd wOrd.9  1 a";
//
//        System.out.println("Дана строка:");
//        System.out.println(str);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = null;

        System.out.print("Введите строку из букв только латинского алфавита:\n[str] --> ");
        try {
            str = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        int lowerCaseAmount = 0;
        int upperCaseAmount = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                upperCaseAmount++;
            }

            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                lowerCaseAmount++;
            }
        }

        System.out.println("Количество больших   букв в строке = " + upperCaseAmount);
        System.out.println("Количество маленьких букв в строек = " + lowerCaseAmount);
        System.out.println("=============================================================\n");
    }

    private static void task10() {
        System.out.println("10. Строка X состоит из нескольких предложений,\n" +
                "каждое из которых кончается точкой,\n" +
                "восклицательным или вопросительным знаком.\n" +
                "Определить количество предложений в строке X.");
        System.out.println("-------------------------------------------------------------");

        String strX = "Быть или не быть, вот в чём вопрос.\n" +
                "To be, or not to be, that is the question.\n" +
                "Ну и умный же ты! Какой сегодя день недели?\n" +
                "How beautiful you look! Do you like studying? − Yes, I do.";

        System.out.println("Дана строка X:");
        System.out.println(strX);
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        int coutSentence = 0;

        for (int i = 0; i < strX.length(); i++) {
            if (strX.charAt(i) == '.' || strX.charAt(i) == '!' || strX.charAt(i) == '?')
                coutSentence++;
        }

        System.out.println("Количество предложений в стороке X = " + coutSentence);
        System.out.println("=============================================================\n");
    }
}
