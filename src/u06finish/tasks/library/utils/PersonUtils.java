package u06finish.tasks.library.utils;

import u06finish.tasks.library.builders.PersonBuilder;
import u06finish.tasks.library.entitys.Person;
import u06finish.tasks.library.entitys.PersonAccess;
import u06finish.tasks.library.handlers.MyFileHandler;

import java.util.Iterator;
import java.util.List;

public class PersonUtils {
    private static List<Person> personList;

    static {
        personList = MyFileHandler.loadPersons();
    }

    public static List<Person> getPersonList() {
        return personList;
    }

    public static Person login(String personName, String password) {
        for (Person person : personList) {
            if (person.getLogin().equalsIgnoreCase(personName) &&
                    PasswordUtils.verifyUserPassword(password, person.getPassword())) {
                return person;
            }
        }
        return null;
    }

    public static Person getAdmin() {
        for (Person person : personList) {
            if (person.getPersonAccess().getName().equalsIgnoreCase("admin")) {
                return person;
            }
        }
        return null;
    }

    public static boolean isAdmin(Person person) {
        return person.getPersonAccess() == PersonAccess.ADMIN;
    }

    public static boolean isPersonExist(String login) {
        return personList.stream().anyMatch(p -> p.getLogin().equalsIgnoreCase(login));
    }

    public static boolean addPerson() {
        System.out.println("Добавляем нового пользователя в библиотеку:");
        System.out.print("Ввидите логин:\t");
        String login = InputUtils.checkInputLine();
        List<Person> persons = PersonUtils.getPersonList();

        if (PersonUtils.isPersonExist(login)) {
            System.out.println("Пользователь с \"" + login + "\" уже существует!");
            return false;
        }

        System.out.print("Введите пароль:\t");
        String password = InputUtils.checkInputLine();
        String encryptedPassword = PasswordUtils.md5Custom(password);

        System.out.print("Введите имя:\t");
        String name = InputUtils.checkInputLine();
        Person person = new PersonBuilder(login, encryptedPassword).setName(name).setPersonAccess(PersonAccess.USER).build();
        persons.add(person);
        MyFileHandler.saveUserList(persons);
        return true;
    }

    public static boolean removePerson() {
        System.out.print("Введите логин:\t");
        String login = InputUtils.checkInputLine();
        List<Person> persons = PersonUtils.getPersonList();

        if (!PersonUtils.isPersonExist(login)) {
            System.out.println("Пользователь с \"" + login + "\" не существует!");
            return false;
        }

        System.out.print("Введите пароль:\t");
        String password = InputUtils.checkInputLine();
        Iterator<Person> iterator = persons.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (login.equalsIgnoreCase(person.getLogin())) {
                String encryptedPassword = PasswordUtils.md5Custom(password);
                if (encryptedPassword.equalsIgnoreCase(person.getPassword())) {
                    iterator.remove();
                }
            }
        }

        MyFileHandler.saveUserList(persons);
        return true;
    }

}
