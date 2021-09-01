package strings03.tasks;


public class StringAsObject {
    public static void Tasks() {
        System.out.println("\t\t=== Работа со строкой как с объектом\n" +
                "\t\t    типа String или StringBuilder ===\n");
        //task01();
        //task02();
        task03();
        //task04();
        //task05();
        //task06();
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

        String text = " 1  22 abc5r6 7a 13   waa77d  8ab53r 0   aoa1  pd word.9  1  a";

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



        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.println("=============================================================\n");
    }

}
