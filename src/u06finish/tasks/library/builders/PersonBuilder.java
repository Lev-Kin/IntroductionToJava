package u06finish.tasks.library.builders;

import u06finish.tasks.library.entitys.Person;
import u06finish.tasks.library.entitys.PersonAccess;
import u06finish.tasks.library.handlers.EmailAddressHandler;

public class PersonBuilder {
    private Person person;

    public PersonBuilder(String login, String password) {
        person = new Person(login, password);
    }

    public PersonBuilder setName(String name) {
        person.setPersonName(name);
        return this;
    }

    public PersonBuilder setPersonAccess(PersonAccess personAccess) {
        person.setPersonAccess(personAccess);
        return this;
    }

    public PersonBuilder setEmailAddress(EmailAddressHandler email) {
        person.setEmailAddress(email);
        return this;
    }

    public Person build() {
        return person;
    }

}
