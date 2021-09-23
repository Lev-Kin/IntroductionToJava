package u04сlasses.tasks.book;

import java.util.ArrayList;

public class BookProcessing {

    private ArrayList<Book> booksList;

    public BookProcessing(ArrayList<Book> booksList) {
        this.booksList = booksList;
    }

    public ArrayList<Book> getBooksList() {
        return booksList;
    }

    public void setBooksList(ArrayList<Book> booksList) {
        this.booksList = booksList;
    }

    public void addBook(String title, String author, String publisher, int yearOfPublishing,
                        int numberOfPages, float price, String bindingType) {
        this.booksList.add(new Book(title, author, publisher, yearOfPublishing, numberOfPages, price, bindingType));
    }

    public void print(ArrayList<Book> booksList) {
        for (Book book : booksList) {
            System.out.println(book);
        }
    }

    public ArrayList authorBooks(String author) {
        ArrayList<Book> authorList = new ArrayList<>();
        for (Book book : this.booksList) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                authorList.add(book);
            }
        }
        return authorList;
    }

    public ArrayList publisherBooks(String publisher) {
        ArrayList<Book> publisherList = new ArrayList<>();
        for (Book book : this.booksList) {
            if (book.getPublisher().equalsIgnoreCase(publisher)) {
                publisherList.add(book);
            }
        }
        return publisherList;
    }

    public ArrayList releasedAfter(int year) {
        ArrayList<Book> releasedAfterList = new ArrayList<>();
        for (Book book : this.booksList) {
            if (book.getYearOfPublishing() > year) {
                releasedAfterList.add(book);
            }
        }
        return releasedAfterList;
    }
}