package u04сlasses.tasks.customer;

public class Customer {

    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private long creditCardNumber;
    private int bankAccount;

    public Customer(int id, String surname, String name, String patronymic, String address,
                    long creditCardNumber, int bankAccount) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.bankAccount = bankAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public int getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(int bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return ".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   ." +
                "\n---| Клиент ID " + id + "\t\t\t|---\n" +
                "Фамилия:\t" + surname + '\n' +
                "Имя:\t\t" + name + '\n' +
                "Отчество:\t" + patronymic + '\n' +
                "Адрес:\t\t" + address + '\n' +
                "Номер кридитной карты:\t" + creditCardNumber + '\n' +
                "Банковский счет:\t\t" + bankAccount;
    }
}