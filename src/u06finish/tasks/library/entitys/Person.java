package u06finish.tasks.library.entitys;

import u06finish.tasks.library.handlers.EmailAddressHandler;

public class Person {
    private static int uniqueID = 11;
    private int id;
    private String personName;
    private String login;
    private String password;
    private PersonAccess personAccess;
    private EmailAddressHandler emailAddress;

    public Person() {
        this.id = uniqueID++;
    }

    public Person(String loging, String password) {
        this.login = loging;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PersonAccess getPersonAccess() {
        return personAccess;
    }

    public void setPersonAccess(PersonAccess personAccess) {
        this.personAccess = personAccess;
    }

    public EmailAddressHandler getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(EmailAddressHandler emailAddress) {
        this.emailAddress = emailAddress;
    }
}
