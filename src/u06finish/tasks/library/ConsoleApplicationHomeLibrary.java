package u06finish.tasks.library;

import u06finish.tasks.library.entitys.Book;
import u06finish.tasks.library.entitys.CatalogLibrary;
import u06finish.tasks.library.entitys.Person;
import u06finish.tasks.library.entitys.PersonAccess;
import u06finish.tasks.library.handlers.MyFileHandler;
import u06finish.tasks.library.utils.CatalogLibraryUtils;
import u06finish.tasks.library.utils.InputUtils;
import u06finish.tasks.library.utils.PersonUtils;

import java.io.IOException;
import java.util.List;

public class ConsoleApplicationHomeLibrary {
    private static CatalogLibrary catalogLibrary = null;

    public static void onLaunch() {
        System.out.println("\t\t===| Добро пожаловать в библиотеку |===");

        if (entrance()) {
            System.out.println("Вход выполнен успешно.");
            System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        }

        while (true) {
            PersonAccess personAccess = catalogLibrary.getPerson().getPersonAccess();
            System.out.println(getMainOptions(personAccess));
            int option = InputUtils.checkInputChoice(personAccess);
            if (option != 0) {
                performOperation(option);
            } else {
                System.out.print("\n\t\t\t    ..........................");
                System.out.print("\n\t\t\t    |    До новых встреч!    |");
                System.out.print("\n\t\t\t    |         (^-^)/         |");
                System.out.print("\n\t\t\t    ''''''''''''''''''''''''''\n");
                break;
            }
        }
    }

    private static boolean entrance() {
        Person person = null;
        while (person == null) {
            System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
            System.out.print("Введите логин:\t");
            String personName = InputUtils.checkInputLine();
            System.out.print("Введите пароль:\t");
            String password = InputUtils.checkInputLine();
            person = PersonUtils.login(personName, password);
            if (person == null) {
                System.out.println("Не верный логин или пароль. Попробуйте снова.");
            }
        }

        List<Book> books = MyFileHandler.loadBooks();
        catalogLibrary = new CatalogLibrary(person, books);
        return true;
    }

    private static String getMainOptions(PersonAccess personAccess) {
        StringBuilder sb = new StringBuilder();
        sb.append("\nВыберите ПУНКТ меню:\n").append("1) Посмотреть книги в каталоге.\n");
        sb.append("2) Найдити\tкнигу в каталоге.\n");
        if (personAccess == PersonAccess.ADMIN) {
            sb.append("3) Добавить\tкнигу в каталог.\n");
            sb.append("4) Удалить\tкнигу из каталога.\n");
            sb.append("5) Зарегистрировать нового пользователя.\n");
            sb.append("6) Удалить пользователя.\n");
        } else {
            sb.append("3) Предложите администратору добавить книгу.\n");
        }
        sb.append("7) Сменить пользователя.\n");
        sb.append("0)  | ВыхоД |\n");
        return sb.toString();
    }

    private static void performOperation(int option) {
        switch (option) {
            case 1:
                System.out.println("-------------------------------------------------------------");
                System.out.println("--> Просматриваем имеющийся книги в библиотеке:");
                if (!CatalogLibraryUtils.printBooks(catalogLibrary.getBooks())) {
                    System.out.println("Каталог пуст.\n");
                }
                System.out.println("-------------------------------------------------------------");
                System.out.println("Вернутся к пунктам меню нажмите-<ENTER>");
                char enter;
                try {
                    enter = (char) System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
                break;

            case 2:
                System.out.println("-------------------------------------------------------------");
                System.out.println("--> Проводим поиск книги в библиотеке:");
                while (!CatalogLibraryUtils.findBook(catalogLibrary)) {
                    System.out.println("Ошибка в запросе, попробуйте еще раз.");
                }
                System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
                break;

            case 3:
                System.out.println("-------------------------------------------------------------");
                System.out.println("--> Добавляем книгу в каталог:");
                Book book = CatalogLibraryUtils.createBook();
                if (catalogLibrary.getPerson().getPersonAccess() == PersonAccess.ADMIN) {
                    if (CatalogLibraryUtils.addBook(catalogLibrary, book)) {
                        System.out.println("Книга успешно добавлена.");
                    } else {
                        System.out.println("Книга уже есть в каталоге.\n");
                    }
                } else {
                    if (CatalogLibraryUtils.suggestBook(catalogLibrary, book)) {
                        System.out.println("Книга отправлена администратору по электронной почте.");
                    } else {
                        System.out.println("Книга уже есть в каталоге.\n");
                    }
                }
                System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
                break;

            case 4:
                System.out.println("-------------------------------------------------------------");
                System.out.println("--> Удаляем книгу из каталога:");
                Book removeBook = CatalogLibraryUtils.createBook();
                if (CatalogLibraryUtils.removeBook(catalogLibrary, removeBook)) {
                    System.out.println("Книга успешно удалена из каталога.");
                } else {
                    System.out.println("В каталоге нет этой книги!");
                }
                System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
                break;

            case 5:
                System.out.println("-------------------------------------------------------------");
                System.out.println("--> Добавляем нового пользователя из библиотеки:");
                if (PersonUtils.addPerson()) {
                    System.out.println("Новый пользователь успешно добавлен.");
                }
                System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
                break;

            case 6:
                System.out.println("-------------------------------------------------------------");
                System.out.println("--> Удаляем пользователя из библиотеки:");
                if (PersonUtils.removePerson()) {
                    System.out.println("Пользователь успешно удален.");
                }
                System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
                break;

            case 7:
                System.out.println("-------------------------------------------------------------");
                System.out.println("--> Проводим смену пользователя:");
                if (entrance()) {
                    System.out.println("Добрый день " + catalogLibrary.getPerson().getPersonName() + "!");
                }
                System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        }
    }
}
