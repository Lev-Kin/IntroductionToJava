package u05oop.tasks;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import u05oop.tasks.calendar.Calendar;
import u05oop.tasks.cave.Cave;
import u05oop.tasks.file.Directory;
import u05oop.tasks.file.File;
import u05oop.tasks.file.TextFile;
import u05oop.tasks.payment.Payment;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Oop {
    public static void Tasks() {
        System.out.println("\t=== Задачи для закрепления навыков по теме ООП ===\n");
        //task01();
        //task02();
        //task03();
        task04();
        //task05();
    }

    private static void task01() {
        System.out.println("Задача 1.\n" +
                "Создать объект класса Текстовый файл, используя классы Файл,\n" +
                "Директория. Методы: создать, переименовать,\n" +
                "вывести на консоль содержимое, дополнить, удалить.");
        System.out.println("-------------------------------------------------------------");
        Directory directory = new Directory("Directory");
        String nameFile = "What is Lorem Ipsum?.txt";
        TextFile textFile = new TextFile(directory, nameFile);

        String str = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
        textFile.addText(str);

        System.out.println("Текстовый файл создан с именем:");
        System.out.println(textFile.getNameFile());
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.println("Меняем имя файла на \"Lorem Ipsum\"");
        textFile.changeName("Lorem Ipsum.txt");
        System.out.println(textFile.getNameFile());
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.println("Выводим на экран содержимое текстогово файла:");
        textFile.printText();
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.println("Добовляем текст в текстовый файл и выводим содержимое файла:");
        String str2 = "\nLorem Ipsum был стандартным фиктивным текстом в отрасли с 1500-х годов,\n" +
                "когда неизвестный типограф взял камбуз и скремблировал его,\n" +
                "чтобы сделать книгу образцов шрифта.";
        textFile.addText(str2);
        textFile.printText();
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.println("Выдодим содержимое котолога " + directory.getName());
        for (File file : directory.getFiles()) {
            System.out.println(file);
        }
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.println("Создаем новый текстовый файл и выводим содержимое котолога:");
        File textFile2 = new TextFile(directory, "What is Lorem Ipsum?.txt");
        for (File file : directory.getFiles()) {
            System.out.println(file);
        }

        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        System.out.println("Удаляем текстовый файл " + directory.getFiles().get(0) + " из дериктории");
        directory.removeFile(directory.getFiles().get(0).getNameFile());

        System.out.println("Выдодим содержимое котолога " + directory.getName());
        for (File file : directory.getFiles()) {
            System.out.println(file);
        }
        System.out.println("=============================================================\n");
    }

    private static void task02() {
        System.out.println("Задача 2.\n" +
                "Создать класс Payment с внутренним классом, с помощью объектов\n" +
                "которого можно сформировать покупку из нескольких товаров.");
        System.out.println("-------------------------------------------------------------");

        System.out.println("1. Создали класс Payment с внутреним классом.");
        Payment payment = new Payment();
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.println("2. С помощью объектов формируем покупку из нескольких товаров.");
        String good = "Chacolate";
        double price = 5.15;
        double wight = 113;
        int amount = 7;
        Payment.Product product = payment.new Product(good, price, wight);
        payment.purchaseMultipleTheSameGoods(product, amount);
        System.out.println("Покупаем продукт в количесве " + amount + " штук.");
        product.print();

        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        System.out.println("3. Выводим результат цену покупки:");
        System.out.printf("Итого: %.2f\n", payment.getTotalPayment());
        System.out.println("=============================================================\n");
    }

    private static void task03() {
        System.out.println("Задача 3.\n" +
                "Создать класс Календарь с внутренним классом,\n" +
                "с помощью объектов которого можно хранить информацию\n" +
                "о выходных и праздничных днях.");
        System.out.println("-------------------------------------------------------------");

        int year = 2022;
        Calendar calendar = new Calendar(year);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        System.out.println("Дабавим некоторые праздинчные дни.");
        calendar.addHoliday(LocalDate.parse("01.01." + year, dateTimeFormatter), "Новый Год");
        calendar.addHoliday(LocalDate.parse("07.01." + year, dateTimeFormatter), "Рождество Христово");
        calendar.addHoliday(LocalDate.parse("08.03." + year, dateTimeFormatter), "8 Марта");
        calendar.addHoliday(LocalDate.parse("24.04." + year, dateTimeFormatter), "Пасха");
        calendar.addHoliday(LocalDate.parse("01.05." + year, dateTimeFormatter), "День Труда");
        calendar.addHoliday(LocalDate.parse("09.05." + year, dateTimeFormatter), "День Победы");
        calendar.addHoliday(LocalDate.parse("03.07." + year, dateTimeFormatter), "День Независимости");
        calendar.addHoliday(LocalDate.parse("07.11." + year, dateTimeFormatter), "День Октябрьской революции");
        calendar.addHoliday(LocalDate.parse("25.12." + year, dateTimeFormatter), "Католическое рождество");
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        System.out.println("Празднечные дни добавлены в календарь.");
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        System.out.println("Выводим календарь на " + year + " год выходных и праздничных дней:");
        calendar.printHolidays();
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        String holidayName = "День Независимости";
        System.out.println("Удалим из каленадаря празник - " + holidayName);
        Calendar.Holiday holidayRemove1 = calendar.removeHoliday(holidayName);
        System.out.println("Удален следующий празник\n" + holidayRemove1);
        holidayName = "День Октябрьской революции";
        System.out.println("Удалим из каленадаря празник - " + holidayName);
        Calendar.Holiday holidayRemove2 = calendar.removeHoliday(holidayName);
        System.out.println("Удален следующий празник\n" + holidayRemove2);
        System.out.println("=============================================================\n");
    }

    private static void task04() {
        System.out.println("Задача 4.\n" +
                "Создать консольное приложение, удовлетворяющее следующим требованиям:\n" +
                "- Приложение должно быть объектно-, а не процедурно-ориентированным\n" +
                "- Каждый класс должен иметь отражающее смысл название и информативный состав.\n" +
                "- Наследование должно применяться только тогда, когда это имеет смысл.\n" +
                "- При кодировании должны быть использованы соглашения об оформлении кода java code convention.\n" +
                "- Классы должны быть грамотно разложены по пакетам." +
                "- Консольное меню должно быть минимальным.\n" +
                "- Для хранения данных можно использовать файлы.\n\n" +
                "Дракон и его сокровища.\n" +
                "Создать программу, позволяющую  обрабатывать сведения о 100 сокровищах\n" +
                "в пещере дракона. Реализовать возможность просмотра сокровищ, выбора\n" +
                "самого дорогого по стоимости сокровища и выбора сокровищ на заданную сумму.)");
        System.out.println("-------------------------------------------------------------");

        final int TREASURE_COUNT = 100;
        Cave cave = new Cave(TREASURE_COUNT);
        cave.createTreasures();

        Scanner scanner = new Scanner(System.in);

        int menu;
        int option;

        char enter;
        char repeat = '\0';

        boolean work = false;
        boolean onLaunch = true;
        int select = 0;

        System.out.println("\n\t\t\t\t***| Дракон и его сокровища |***");
        while (onLaunch == true) {
            System.out.print(" _______________________| Главное меню |_____________________\n");
            System.out.print("    Выберите ПУНКТ меню:\n");
            System.out.print(" 1) Вывести информацию о cокровищах.\n");
            System.out.print(" 2) Вывести информацию о забраных сокровищах.\n");
            System.out.print(" 3) Выбрать самое дорогое.\n");
            System.out.print(" 4) Выбрать сокровищ на определеную сумму.\n");
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
                    System.out.println("Coкровище пищеры дракона:");
                    System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
                    cave.printAllTreasures();
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
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("\t\t\t_______| Выбран 2 пункт меню |_______");
                    System.out.println("Coкровище забраные из пищеры дракона:");
                    System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
                    cave.printTakenTreasures();
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Вернутся в главное меню нажмите-<ENTER>");
                    try {
                        enter = (char) System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;

                case 3: {
                    do {
                        System.out.println("-------------------------------------------------------------");
                        System.out.println("\t\t\t_______| Выбран 3 пункт меню |_______");
                        System.out.println(" 1 -  Выбрать самое дорогое в пещере.");
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
                            System.out.println("Выбераем самое дорогое:");
                            System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
                            cave.takeMostExpensiveTreasure();
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
                        System.out.println(" 1 -  Выбрать сокровищ на определеную сумму.");
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
                            System.out.println("Выбераем сокровища на определеную сумму:");
                            System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

                            double sum;
                            System.out.print("Введите сумму > ");
                            do {
                                sum = 0;

                                if (!scanner.hasNextDouble()) {
                                    scanner.next();
                                    System.out.println("Некорректный ввод!!!\nВвод чисел!");
                                    System.out.print("Введите сумму > ");
                                } else {
                                    sum = scanner.nextDouble();

                                    if (sum <= 0) {
                                        System.out.println("Сумма должна быть > 0");
                                        System.out.println("Пожалуйста посторите ввод.");
                                        System.out.print("Введите сумму > ");
                                    }
                                }

                            } while (sum <= 0);

                            cave.takeOnSum(sum);
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
                    System.out.print("\tДля продолжения-<ENTER>\n");
                    Scanner sc = new Scanner(System.in);
                    sc.nextLine();
                    break;
            }
        }

        System.out.println("=============================================================\n");
    }


}
