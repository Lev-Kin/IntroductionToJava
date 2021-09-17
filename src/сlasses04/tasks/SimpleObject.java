package сlasses04.tasks;

import сlasses04.tasks.student.Student;
import сlasses04.tasks.test01.Test1;
import сlasses04.tasks.test02.Test2;

import java.util.Random;

public class SimpleObject {
    public static void Tasks() {
        System.out.println("\t\t=== Простейшие классы и объекты ===\n");
        //task01();
        //task02();
        //task03();
        task04();
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

    private static void task02() {
        System.out.println("2. Создйте класс Test2 двумя переменными. Добавьте конструктор\n" +
                "с входными параметрами. Добавьте конструктор, инициализирующий\n" +
                "члены класса по умолчанию. Добавьте set- и get- методы для\n" +
                "полей экземпляра класса.");
        System.out.println("-------------------------------------------------------------");

        System.out.println("Создаем класс Теst2 с двумя перемеными:");

        System.out.println("Конструктор с входными параметрами:");
        Test2 test2 = new Test2(10, 20);
        test2.print();

        System.out.println("Конструктор по умолчанию:");
        Test2 test2Def = new Test2();
        test2Def.print();
        System.out.println("=============================================================\n");
    }

    private static void task03() {
        System.out.println("3. Создайте класс с именем Student, содержащий поля: фамилия\n" +
                "и инициалы, номер группы, успеваемость (массив из пяти\n" +
                "элементов). Создайте массив из десяти элементов такого типа.\n" +
                "Добавьте возможность вывода фамилий и номеров групп\n" +
                "студентов, имеющих оценки, равные только 9 или 10.");
        System.out.println("-------------------------------------------------------------");

        Student[] students = new Student[10];

        String[] arrLastNames = {"Scorsese", "Jackson", "Spielberg", "Burton", "Fincher",
                "Lynch", "Nolan", "Scott", "Cameron", "Forman"};
        String[] initials = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
                "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] faculty = {"MTM", "MTС", "C", "МV", "MG", "MT", "ML", "MF", "BW", "BC", "BF"};

        int[] courses = {1, 2, 3, 4, 5};
        int[] numberGroups = {1, 2, 3};

        // Инициализация студентов
        Random random = new Random();
        for (int i = 0; i < students.length; i++) {
            int indexLastName = random.nextInt(10);
            int indexName = random.nextInt(26);
            int indexPatronymic = random.nextInt(26);
            int indexFaculty = random.nextInt(11);
            int indexCourse = random.nextInt(5);
            int indexNumberGroup = random.nextInt(3);

            int[] arrMarks = new int[5];
            for (int k = 0; k < arrMarks.length; k++) {
                arrMarks[k] = random.nextInt(11 - 8) + 8;
            }

            String lastName = arrLastNames[indexLastName];
            String name = initials[indexName];
            String patronymic = initials[indexPatronymic];
            String fullName = lastName + " " + name + "." + patronymic;
            String group = faculty[indexFaculty] + "-" + courses[indexCourse] + numberGroups[indexNumberGroup];

            students[i] = new Student(fullName, group, arrMarks);
        }

        Student.print(students);

        System.out.println("\nВыводим фамилии и номера групп студентов, имеющих оценки,\n" +
                "равные только 9 или 10");

        if(Student.printExcellentStudent(students) == false){
            System.out.println("Таблица пуста.\n" +
                    "Студентов подходящих по таким параметрам не обнаружено.");
        }
        System.out.println("=============================================================\n");
    }

    private static void task04() {
        System.out.println("4. Создайте класс Train, содержащий поля: название пункта\n" +
                "назначения, номер поезда, время отправления. Создайте данные\n" +
                "в массив из пяти элементов типа Train, добавьте возможность\n" +
                "сортировки элементов массива по номерам поездов. Добавьте\n" +
                "возможность вывода информации о поезде, номер которого введен\n" +
                "пользователем. Добавьте возможность сортировки массив по\n" +
                "пункту назначения, причем поезда с одинаковыми пунктами\n" +
                "назначения должны быть упорядочены по времени отправления.");
        System.out.println("-------------------------------------------------------------");

        System.out.println("=============================================================\n");
    }
}