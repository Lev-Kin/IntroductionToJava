package u03strings.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static supporting.MyMethodsRegularExpression.*;

public class RegularExpression {
    public static void Tasks() {
        System.out.println(" === Работа с регулярными выражениями (Pattern, Matcher) ===\n");
        task01();
        task02();
    }

    private static void task01() {
        System.out.println("1. Создать приложение, разбирающее текст (текст хранится в\n" +
                "строке) и позволяющее выполнять с текстом три различных\n" +
                "операции:\n" +
                "отсортировать абзацы по количеству предложений;\n" +
                "в каждом предложении отсортировать слова по длине;\n" +
                "отсортировать лексемы в предложении по убыванию количества\n" +
                "вхождений заданного символа, а в случае равенства – по алфавиту.");
        System.out.println("-------------------------------------------------------------");

        String text = "I\tParagraph to infinity and beyond.\n" +
                "II\tParagraph. Five sentence. It's third sentence. It's fourth. And it's fifth...\n" +
                "III\tParagraph. Three sentence. Three!\n" +
                "IV\tParagraph and seven sentences. Second. Third. Fourth. Fifth? Sixth. Seventh.\n" +
                "V\tParagraph five, next, six.\n" +
                "VI\tParagraph.\n" +
                "VII\tParagraph. Final Fantasy Remake.";

        Scanner scanner = new Scanner(System.in);

        int menu;
        int option;

        char enter;
        char repeat = '\0';

        boolean work = false;
        boolean goBack = true;
        int select = 0;
        do {
            System.out.println("\n\t\t\t***| Приложение для работы с текстом |***");
            System.out.print(" _______________________| Главное меню |_____________________\n");
            System.out.print("    Выберите ПУНКТ меню:\n");
            System.out.print(" 1) Просмотреть исходный текст.\n");
            System.out.print(" 2) Отсортировать абзацы по количеству предложений.\n");
            System.out.print(" 3) В каждом предложении отсортировать слова по длине.\n");
            System.out.print(" 4) Отсортировать лексемы в предложении по убыванию количества\n");
            System.out.print("    вхождений заданного символа,\n");
            System.out.print("    а в случае равенства – по алфавиту.\n");
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
                    System.out.println("Дан текст:");
                    System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
                    System.out.println(text);
                    System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
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
                        System.out.println("Дан текст:");
                        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
                        System.out.println(text);
                        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

                        System.out.println(" 1 - Отсортировать абзацы по количеству предложений.");
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
                            System.out.println("Абзацы в тексте отсортированы по количеству предложений:");
                            System.out.println(sortParagraphsByAmountSentences(text));
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
                        System.out.println("Дан текст:");
                        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
                        System.out.println(text);
                        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

                        System.out.println(" 1 - Отсортировать слова по длине в предложений.");
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
                            System.out.println("В предложении отсортированы слова по длине:");
                            System.out.println(sortWordsByLengthInSentences(text));
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
                        System.out.println("Дан текст:");
                        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
                        System.out.println(text);
                        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

                        System.out.println(" 1 - Отсортировать лексемы в предложении согласно задания.");
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

                            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                            String symbol = null;

                            System.out.print("Введите символ для сортировки лексем по убыванию:\n[ch] --> ");
                            try {
                                symbol = reader.readLine();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

                            System.out.println("Текст отсортирован согласно задания:");
                            String result = sortLexemesInSentencesByDecreaseGivenSymbol(text, symbol);
                            System.out.println(result);
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
                    goBack = false;
                    break;


                default:
                    System.out.print("\n\tНеверный пункт меню.\n");
                    System.out.print("\tБудьте внимательны!!!\n");
                    System.out.print("\tДля продолжения-<ENTER>");
                    Scanner sc = new Scanner(System.in);
                    sc.nextLine();
                    break;
            }

        } while (goBack == true);

        System.out.println("=============================================================\n");
    }

    private static void task02() {
        System.out.println("2. Дана строка, содержащая следующий текст (xml-документ):\n" +
                "<notes>\n" +
                "\t<note id = \"1\">\n" +
                "\t\t<to>Вася</to>\n" +
                "\t\t<from>Света</from>\n" +
                "\t\t<heading>Напоминание</heading>\n" +
                "\t\t<body>Позвони мне завтра!</body>\n" +
                "\t</note>\n" +
                "\t<note id = \"2\">\n" +
                "\t\t<to>Петя</to>\n" +
                "\t\t<from>Маша</from>\n" +
                "\t\t<heading>Важное напоминание</heading>\n" +
                "\t\t<body/>\n" +
                "\t</note>\n" +
                "</notes>\n" +
                "Напишите анализатор, позволяющий последовательно возвращать\n" +
                "содержимое узлов xml-документа и его тип (открывающий тег,\n" +
                "закрывающий тег, содержимое тега, тег без тела). \n" +
                "Пользоваться готовыми парсерами XML для решения задачи нельзя");
        System.out.println("-------------------------------------------------------------");

        String xml = "<notes>\n" +
                " <note id = \"1\">\n" +
                " <to>Вася</to>\n" +
                " <from>Света</from>\n" +
                " <heading>Напоминание</heading>\n" +
                " <body>Позвони мне завтра!</body>\n" +
                " </note>\n" +
                " <note id = \"2\">\n" +
                " <to>Петя</to>\n" +
                " <from>Маша</from>\n" +
                " <heading>Важное напоминание</heading>\n" +
                " <body/>\n" +
                " </note>\n" +
                "</notes>";

        StringBuilder strBuilder = new StringBuilder();

        Pattern tegOpen = Pattern.compile("<\\w.+?>");
        Pattern tegClose = Pattern.compile("</\\w+>");
        Pattern tegContent = Pattern.compile(">.+?<");
        Pattern tegEmpty = Pattern.compile("<\\w.+?/>");

        String[] lines = xml.split("\n\\s*");

        for (String line : lines) {

            Matcher matcherOpen = tegOpen.matcher(line);
            Matcher matcherClose = tegClose.matcher(line);
            Matcher matcherContent = tegContent.matcher(line);
            Matcher matcherEmpty = tegEmpty.matcher(line);

            if (matcherEmpty.find() == true) {
                strBuilder.append("\nTег без тела\t:\t");
                strBuilder.append(matcherEmpty.group());
            }
            else if (matcherOpen.find() == true) {
                strBuilder.append("\nОткрывающий тег\t:\t");
                strBuilder.append(matcherOpen.group());
            }

            if (matcherContent.find() == true) {
                strBuilder.append("\nСодержимое тега\t:\t");
                strBuilder.append(matcherContent.group().substring(1));
                strBuilder.append("\b");
            }

            if (matcherClose.find() == true) {
                strBuilder.append("\nЗакрывающий тег\t:\t");
                strBuilder.append(matcherClose.group());
            }
        }
        System.out.println(strBuilder);
        System.out.println("=============================================================\n");
    }
}
