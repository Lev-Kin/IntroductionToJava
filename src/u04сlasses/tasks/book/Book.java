package u04сlasses.tasks.book;

public class Book {

    private static long uniqueID = 1000000000000L;
    private long isbn;
    private String title;
    private String author;
    private String publisher;
    private int yearOfPublishing;
    private int numberOfPages;
    private float price;
    private String bindingType;

    public Book(String title, String author, String publisher,
                int yearOfPublishing, int numberOfPages, float price, String bindingType) {
        this.isbn = uniqueID++;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearOfPublishing = yearOfPublishing;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.bindingType = bindingType;
    }

    public static long getUniqueID() {
        return uniqueID;
    }

    public static void setUniqueID(int uniqueID) {
        Book.uniqueID = uniqueID;
    }

    public long getId() {
        return isbn;
    }

    public void setId(int id) {
        this.isbn = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getBindingType() {
        return bindingType;
    }

    public void setBindingType(String bindingType) {
        this.bindingType = bindingType;
    }

    @Override
    public String toString() {
        return ".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   ." +
                "\n---| Book ISBN " + isbn + "\t\t\t|---\n" +
                "Название:\t\t" + title + '\n' +
                "Автор:\t\t\t" + author + '\n' +
                "Издательство:\t" + publisher + '\n' +
                "Год издания:\t" + yearOfPublishing + '\n' +
                "Кол-во страниц:\t" + numberOfPages + '\n' +
                "Цена:\t\t\t" + price + '\n' +
                "Тип переплета:\t" + bindingType;
    }
}