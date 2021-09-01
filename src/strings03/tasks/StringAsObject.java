package strings03.tasks;


public class StringAsObject {
    public static void Tasks() {
        System.out.println("\t\t=== Работа со строкой как с объектом\n" +
                "\t\t    типа String или StringBuilder ===\n");
        task01();
        //task02();
        //task03();
        //task04();
       // task05();
    }

    private static void task01() {
        System.out.println("1.Дан текст (строка). Найдите наибольшее количество подряд\n" +
                "идущих пробелов в нем.");
        System.out.println("-------------------------------------------------------------");

        String text = " 1  22 abc5r6 7g 13   wor77d  8ab53r 0   wor1  pd word.9  1   ";

        System.out.println("Дан текст:");
        System.out.println(text);
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");



        System.out.println("=============================================================\n");
    }
}
