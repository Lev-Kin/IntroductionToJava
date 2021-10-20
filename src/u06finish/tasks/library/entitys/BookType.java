package u06finish.tasks.library.entitys;

public enum BookType {
    PBOOK("Paper book"), EBOOK("eBook");

    String name;

    BookType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
