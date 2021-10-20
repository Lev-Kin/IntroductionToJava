package u06finish.tasks.library.entitys;

public class Book {
    private String author;
    private String title;
    private int year;
    private BookType bookType;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Book book = (Book) o;

        if (year != book.year) return false;
        if (!author.equals(book.author)) return false;
        if (!title.equals(book.title)) return false;
        return bookType == book.bookType;
    }

    @Override
    public int hashCode() {
        int result = author.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + year;
        result = 31 * result + bookType.hashCode();
        return result;
    }

}
