package u06finish.tasks.library.handlers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailAddressHandler {
    private String name;

    public EmailAddressHandler(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Pattern pattern = Pattern.compile("^[a-z_]{2,20}@[a-z]{2,4}\\.[a-z]{2,3}$");
        Matcher matcher = pattern.matcher(name);

        if (matcher.matches()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Неверный адрес электронной почты: " + name);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
