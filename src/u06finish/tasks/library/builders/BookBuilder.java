package u06finish.tasks.library.builders;

import u06finish.tasks.library.entitys.Book;
import u06finish.tasks.library.entitys.BookType;

public class BookBuilder {
    private Book book;

    public BookBuilder() {
        this.book = new Book();
    }

    public BookBuilder setAuthor(String author) {
        book.setAuthor(author);
        return this;
    }

    public BookBuilder setTitle(String title) {
        book.setTitle(title);
        return this;
    }

    public BookBuilder setYear(int year) {
        book.setYear(year);
        return this;
    }

    public BookBuilder setType(BookType type) {
        book.setBookType(type);
        return this;
    }

    public Book build() {
        return book;
    }
}
