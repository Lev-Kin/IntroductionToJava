package strings03.tasks;


public class StringAsObject {
    public static void Tasks() {
        System.out.println("\t\t=== Работа со строкой как с объектом\n" +
                "\t\t    типа String или StringBuilder ===\n");
        //task01();
        //task02();
        //task03();
        //task04();
        task05();
        task06();
        //task07();
        //task08();
        //task09();
        //task10();
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


}
