package u06finish.tasks.library.entitys;

import u06finish.tasks.library.handlers.EmailAddressHandler;

public class Letter {
    private EmailAddressHandler recipient;
    private EmailAddressHandler sender;
    private Book book;
    private String message;

    public Letter(EmailAddressHandler recipient, EmailAddressHandler sender, Book book) {
        this.recipient = recipient;
        this.sender = sender;
        this.book = book;
        this.message = "";
    }

    public EmailAddressHandler getRecipient() {
        return recipient;
    }

    public void setRecipient(EmailAddressHandler recipient) {
        this.recipient = recipient;
    }

    public EmailAddressHandler getSender() {
        return sender;
    }

    public void setSender(EmailAddressHandler sender) {
        this.sender = sender;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean sendLetter() {
        return true;
    }

    @Override
    public String toString() {
        return "Letter{" +
                "recipient=" + recipient +
                ", sender=" + sender +
                ", book=" + book +
                ", message='" + message + '\'' +
                '}';
    }
}
