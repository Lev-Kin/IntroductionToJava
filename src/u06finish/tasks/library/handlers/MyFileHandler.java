package u06finish.tasks.library.handlers;

import u06finish.tasks.library.builders.BookBuilder;
import u06finish.tasks.library.builders.PersonBuilder;
import u06finish.tasks.library.entitys.Book;
import u06finish.tasks.library.entitys.BookType;
import u06finish.tasks.library.entitys.Person;
import u06finish.tasks.library.entitys.PersonAccess;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyFileHandler {
    private static String personFile = "src/u06finish/tasks/library/data/persons.txt";
    private static String catalogLibraryFile = "src/u06finish/tasks/library/data/books.txt";

    public static List<Person> loadPersons() {
        String line;
        String splitBy = " - ";
        List<Person> persons = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(personFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(splitBy);
                Person person = new PersonBuilder(data[1], data[2])
                        .setName(data[0])
                        .setPersonAccess(PersonAccess.valueOf(data[3].toUpperCase()))
                        .build();
                persons.add(person);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return persons;
    }

    public static void saveUserList(List<Person> personList) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(personFile))) {
            for (Person person : personList) {
                StringBuilder sb = new StringBuilder();
                sb.append(person.getPersonName());
                sb.append(" - ");
                sb.append(person.getLogin());
                sb.append(" - ");
                sb.append(person.getPassword());
                sb.append(" - ");
                sb.append(person.getPersonAccess().name().toLowerCase());
                bw.write(sb.toString());
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Book> loadBooks() {
        String line;
        String splitBy = " - ";
        List<Book> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(catalogLibraryFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(splitBy);
                Book book = new BookBuilder().setAuthor(data[0])
                        .setTitle(data[1])
                        .setYear(Integer.valueOf(data[2]))
                        .setType(BookType.valueOf(data[3].toUpperCase()))
                        .build();
                books.add(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    public static void saveCatalog(List<Book> books) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(catalogLibraryFile))) {
            for (Book book : books) {
                StringBuilder sb = new StringBuilder();
                sb.append(book.getAuthor());
                sb.append(" - ");
                sb.append(book.getTitle());
                sb.append(" - ");
                sb.append(book.getYear());
                sb.append(" - ");
                sb.append(book.getBookType().name().toLowerCase());

                bw.write(sb.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
