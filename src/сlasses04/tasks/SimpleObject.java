package сlasses04.tasks;

import сlasses04.tasks.student.Student;
import сlasses04.tasks.test01.Test1;
import сlasses04.tasks.test02.Test2;
import сlasses04.tasks.train.Train;
import сlasses04.tasks.train.TrainProcessing;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class SimpleObject {
    public static void Tasks() {
        System.out.println("\t\t=== Простейшие классы и объекты ===\n");
        //task01();
        //task02();
        //task03();
        //task04();
        task05();
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

        if (Student.printExcellentStudent(students) == false) {
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

        TrainProcessing trainProcessing = new TrainProcessing();
        Train[] trains = trainProcessing.initializationTrain();

        Scanner scanner = new Scanner(System.in);

        int menu;
        int option;

        char enter;
        char repeat = '\0';

        boolean work = false;
        boolean onLaunch = true;
        int select = 0;

        System.out.println("\n\t\t\t\t***| Работа с расписанием поездов |***");
        while (onLaunch == true) {
            System.out.print(" _______________________| Главное меню |_____________________\n");
            System.out.print("    Выберите ПУНКТ меню:\n");
            System.out.print(" 1) Вывести информацию о поездах.\n");
            System.out.print(" 2) Cортировка элементов массива по номерам поездов.\n");
            System.out.print(" 3) Вывести информацию по номеру поезда.\n");
            System.out.print(" 4) Сортировка элементов массива по пункту назначения.\n");
            System.out.print(" 5)   | ВыхоД |\n");
            menu = 0;

            do {
                work = false;
                System.out.print(">");

                if (scanner.hasNextInt() == false) {
                    System.out.println("Ввод только целых чисел!");
                    scanner.next();
                } else {
                    menu = scanner.nextInt();
                    work = true;
                }

            } while (work == false);

            switch (menu) {

                case 1: {
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("\t\t\t_______| Выбран 1 пункт меню |_______");
                    System.out.println("Расписание поездов:");
                    System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
                    trainProcessing.print(trains);
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Вернутся в главное меню нажмите-<ENTER>");
                    try {
                        enter = (char) System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;

                case 2: {
                    do {
                        System.out.println("-------------------------------------------------------------");
                        System.out.println("\t\t\t_______| Выбран 2 пункт меню |_______");
                        System.out.println(" 1 - Отсортировать элементы массива по номерам поездов.");
                        System.out.println(" 2 - | Отмена - выход в главное меню |");

                        do {
                            option = 0;

                            System.out.print(">");
                            if (scanner.hasNextInt() == false) {
                                System.out.println("Ввод только целых чисел!");
                                scanner.next();
                            } else {
                                option = scanner.nextInt();

                                if (option != 1 && option != 2) {
                                    System.out.println(" Некорректный ввод (Действие = 2 -отмена).");
                                    System.out.println(" Пожалуйста сделайте выбор.");
                                }
                            }

                        } while (option != 1 && option != 2);

                        if (option == 1) {
                            System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
                            System.out.println("Элементы массива отсортированы по номерам поездов:");
                            System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
                            trainProcessing.sortByTrainNumber(trains);
                            trainProcessing.print(trains);
                        }

                        if (option == 2)
                            break;

                        System.out.println("-------------------------------------------------------------");
                        System.out.println(" Y - Повторить пункт 2.");
                        System.out.print(" Q - Выход в Главное меню.\n>");
                        repeat = scanner.next().charAt(0);
                    } while (repeat == 'y' || repeat == 'Y');
                }
                break;

                case 3: {
                    do {
                        System.out.println("-------------------------------------------------------------");
                        System.out.println("\t\t\t_______| Выбран 3 пункт меню |_______");
                        System.out.println(" 1 - Вывести информацию по номеру поезда.");
                        System.out.println(" 2 - | Отмена - выход в главное меню |");

                        do {
                            option = 0;

                            System.out.print(">");
                            if (scanner.hasNextInt() == false) {
                                System.out.println("Ввод только целых чисел!");
                                scanner.next();
                            } else {
                                option = scanner.nextInt();

                                if (option != 1 && option != 2) {
                                    System.out.println(" Некорректный ввод (Действие = 2 -отмена).");
                                    System.out.println(" Пожалуйста сделайте выбор.");
                                }
                            }

                        } while (option != 1 && option != 2);

                        if (option == 1) {
                            System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
                            System.out.println("Введите номер поезда для поиска и отображения информации:");

                            Scanner sc = new Scanner(System.in);
                            String searchTrainNumber = sc.nextLine();
                            int indexSerchTrainNumber = trainProcessing.cheackTrainNumber(searchTrainNumber, trains);

                            if (indexSerchTrainNumber > -1) {
                                System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
                                System.out.printf("Информация по набраному номеру %s поезда следушая:\n", searchTrainNumber);
                                System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
                                trainProcessing.getInfoByTrainNumber(trains[indexSerchTrainNumber]);
                            } else {
                                System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
                                System.out.printf("Информация по набраному номеру %s поезда отсутствует.\n", searchTrainNumber);
                            }
                        }

                        if (option == 2)
                            break;

                        System.out.println("-------------------------------------------------------------");
                        System.out.println(" Y - Повторить пункт 3.");
                        System.out.print(" Q - Выход в Главное меню.\n>");
                        repeat = scanner.next().charAt(0);
                    } while (repeat == 'y' || repeat == 'Y');
                }
                break;

                case 4: {
                    do {
                        System.out.println("-------------------------------------------------------------");
                        System.out.println("\t\t\t_______| Выбран 4 пункт меню |_______");
                        System.out.println(" 1 - Отсортировать элементы массива по пункту назначения.");
                        System.out.println(" 2 - | Отмена - выход в главное меню |");

                        do {
                            option = 0;

                            System.out.print(">");
                            if (scanner.hasNextInt() == false) {
                                System.out.println("Ввод только целых чисел!");
                                scanner.next();
                            } else {
                                option = scanner.nextInt();

                                if (option != 1 && option != 2) {
                                    System.out.println(" Некорректный ввод (Действие = 2 -отмена).");
                                    System.out.println(" Пожалуйста сделайте выбор.");
                                }
                            }

                        } while (option != 1 && option != 2);
                        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

                        if (option == 1) {
                            System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
                            System.out.println("Элементы массива отсортированы по пункту назначения:");
                            System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
                            trainProcessing.sortByDestinationName(trains);
                            trainProcessing.print(trains);
                        }

                        if (option == 2)
                            break;

                        System.out.println("-------------------------------------------------------------");
                        System.out.println(" Y - Повторить пункт 4.");
                        System.out.print(" Q - Выход в Главное меню.\n>");
                        repeat = scanner.next().charAt(0);
                    } while (repeat == 'y' || repeat == 'Y');
                }
                break;

                case 5:
                    System.out.print("\n\t\t\t    ..........................");
                    System.out.print("\n\t\t\t    |     Всего хорошего     |");
                    System.out.print("\n\t\t\t    |         (^-^)/         |");
                    System.out.print("\n\t\t\t    ''''''''''''''''''''''''''\n");
                    onLaunch = false;
                    break;


                default:
                    System.out.print("\n\tНеверный пункт меню.\n");
                    System.out.print("\tБудьте внимательны!!!\n");
                    System.out.print("\tДля продолжения-<ENTER>");
                    Scanner sc = new Scanner(System.in);
                    sc.nextLine();
                    break;
            }
        }

        System.out.println("=============================================================\n");
    }

    private static void task05(){

        
    }
}