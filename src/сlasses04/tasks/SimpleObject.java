package сlasses04.tasks;

import сlasses04.tasks.test01.Test1;

public class SimpleObject {
    public static void Tasks() {
        System.out.println("\t\t=== Простейшие классы и объекты. ===\n");
        task01();
//        task02();
//        task03();
//        task04();
//        task05();
//        task06();
//        task07();
//        task08();
//        task09();
//        task10();
    }

    private static void task01() {
        System.out.println("1. Создайте класс Test1 двумя переменными. Добавьте метод\n" +
                "вывода на экран и методы изменения этих переменных. Добавьте\n" +
                "метод, который находит сумму значений этих переменных, и метод,\n" +
                "который находит наибольшее значение из этих двух переменных.");
        System.out.println("-------------------------------------------------------------");

        System.out.println("Создаем класс Теst1 с двумя перемеными:");
        Test1 test1 = new Test1();
        test1.setVariableFirst(10);
        test1.setVariableSecond(20);
        test1.print();

        System.out.println("Определяем сумму двух переменых = " + test1.getSum());
        System.out.println("Определяем max значения переменных = " + test1.getMax());
        System.out.println("=============================================================\n");
    }


}
