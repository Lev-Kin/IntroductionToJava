package u06finish.tasks.library.utils;

import u06finish.tasks.library.entitys.BookType;
import u06finish.tasks.library.entitys.PersonAccess;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static String checkInputLine() {
        Pattern pattern = Pattern.compile("[\\D\\w ]{4,30}");
        scanner.useDelimiter("[\r\n]");
        while (!scanner.hasNext(pattern)) {
            scanner.nextLine();
            System.out.println("Некорректный ввод.\nУбедитесь, что длина строки составляет от 4 до 30 символов.");
        }
        return scanner.nextLine().trim();
    }

    public static int checkInputChoice(PersonAccess personAccess) {
        Pattern pattern;
        if (personAccess == PersonAccess.ADMIN) {
            pattern = Pattern.compile("[0-6[7]]");
        } else {
            pattern = Pattern.compile("[0-3[7]]");
        }
        while (!scanner.hasNext(pattern)) {
            scanner.nextLine();
            System.out.println("Недоступная операция. Попробуйте снова.");
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public static BookType checkInputBookType() {
        Pattern pattern = Pattern.compile("[1-2]");
        while (!scanner.hasNext(pattern)) {
            scanner.nextLine();
            System.out.println("Некорректный ввод. Попробуйте снова.");
        }
        if (scanner.nextInt() == 1) {
            return BookType.EBOOK;
        } else return BookType.PBOOK;
    }

    public static int checkPageNumber() {
        Pattern pattern = Pattern.compile("[\\d]");
        while (!scanner.hasNext(pattern)) {
            scanner.nextLine();
            System.out.println("Некорректный ввод. Попробуйте снова.");
        }
        return scanner.nextInt();
    }

    public static int checkInputYear() {
        Pattern pattern = Pattern.compile("[\\d ]{4}");
        while (!scanner.hasNext(pattern)) {
            scanner.nextLine();
            System.out.println("(год должен состоять из четырех цифр)");
        }
        return scanner.nextInt();
    }

}
