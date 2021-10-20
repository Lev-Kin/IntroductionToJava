package u06finish.tasks.library.utils;

import u06finish.tasks.library.builders.BookBuilder;
import u06finish.tasks.library.entitys.*;
import u06finish.tasks.library.handlers.MyFileHandler;

import java.util.List;
import java.util.stream.Collectors;

public class CatalogLibraryUtils {

    public static Book createBook() {
        BookBuilder bookBuilder = new BookBuilder();

        System.out.print("Введите имя автора:\t\t");
        bookBuilder.setAuthor(InputUtils.checkInputLine());
        System.out.print("Введите название книги:\t");
        bookBuilder.setTitle(InputUtils.checkInputLine());
        System.out.print("Введите год издания книги:");
        bookBuilder.setYear(InputUtils.checkInputYear());

        System.out.print("Введите тип книги:\n(1 - электронная книга или 2 - бумажная книга)\n> ");
        bookBuilder.setType(InputUtils.checkInputBookType());

        return bookBuilder.build();
    }

    public static String getBookLine(Book book) {
        return String.format("%s, \"%s\", %d год, тип: %s", book.getAuthor(), book.getTitle(),
                book.getYear(), book.getBookType().getName());
    }

    public static boolean addBook(CatalogLibrary catalogLibrary, Book book) {
        if (!catalogLibrary.getBooks().contains(book)) {
            catalogLibrary.getBooks().add(book);
            MyFileHandler.saveCatalog(catalogLibrary.getBooks());

            for (Person person : PersonUtils.getPersonList()) {
                if (!person.getPersonAccess().getName().equals("admin")) {
                    Letter letter = new Letter(person.getEmailAddress(), PersonUtils.getAdmin().getEmailAddress(), book);
                    letter.sendLetter();
                    System.out.println("Письмо отправлено " + person.getPersonName());
                }
            }

            return true;
        }

        return false;
    }

    public static boolean suggestBook(CatalogLibrary catalogLibrary, Book book) {
        if (!catalogLibrary.getBooks().contains(book)) {
            Letter letter = new Letter(PersonUtils.getAdmin().getEmailAddress(),
                    catalogLibrary.getPerson().getEmailAddress(), book);
            if (letter.sendLetter()) {
                return true;
            }
        }
        return false;
    }

    public static boolean removeBook(CatalogLibrary catalogLibrary, Book book) {
        if (catalogLibrary.getBooks().remove(book)) {
            MyFileHandler.saveCatalog(catalogLibrary.getBooks());
            return true;
        } else {
            return false;
        }
    }

    public static boolean findBook(CatalogLibrary catalogLibrary) {
        List<Book> books = null;

        System.out.print("Введите \"1\" искать по автору или \"2\" искать по названию книги:\n> ");
        int request = InputUtils.checkInputChoice(PersonAccess.USER);
        if (request == 1) {
            System.out.print("Введите имя автора:\t\t");
            String author = InputUtils.checkInputLine();
            books = CatalogLibraryUtils.findBookByAuthor(catalogLibrary.getBooks(), author);
        } else if (request == 2) {
            System.out.print("Введите название книги:\t");
            String title = InputUtils.checkInputLine();
            books = CatalogLibraryUtils.findBookByTitle(catalogLibrary.getBooks(), title);
        } else {
            return false;
        }

        if (books.size() != 0) {
            CatalogLibraryUtils.printBooks(books);
        } else {
            System.out.println("Книга не найдена. Возможно запрос неверный.");
        }

        return true;
    }

    public static List<Book> findBookByAuthor(List<Book> books, String author) {
        return books.stream().filter(book -> book.getAuthor().equalsIgnoreCase(author)).collect(Collectors.toList());
    }

    public static List<Book> findBookByTitle(List<Book> books, String title) {
        return books.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
    }

    public static boolean printBooks(List<Book> bookList) {
        if (bookList.size() != 0) {

            for (int i = 0; i < bookList.size(); i++) {
                System.out.println(getBookLine(bookList.get(i)));
            }


            return true;
        }

        return false;

    }

}
