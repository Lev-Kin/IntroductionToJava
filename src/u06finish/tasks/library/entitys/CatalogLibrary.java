package u06finish.tasks.library.entitys;

import java.util.List;

public class CatalogLibrary {
    private Person person;
    private List<Book> books;

    public CatalogLibrary(Person person, List<Book> books) {
        this.person = person;
        this.books = books;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
