package u04сlasses.tasks.bank;

import java.util.ArrayList;
import java.util.Comparator;

public class Client {
    private String surname;
    private String name;
    private String passportID;
    private ArrayList<Account> accounts;

    public Client(String surname, String name, String passportID) {
        this.surname = surname;
        this.name = name;
        this.passportID = passportID;
        this.accounts = new ArrayList<>();
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

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public void openAccount(Account account) {
        accounts.add(account);
    }

    public String getBalance() {
        double balance = 0;
        for (Account account : accounts) {
            balance += account.getBalance();
        }
        return String.format("%.2f $", balance);
    }

    public String getBalancePositiveAccounts() {
        double balance = 0;
        for (Account account : accounts) {
            if (account.getBalance() > 0) {
                balance += account.getBalance();
            }

        }
        return String.format("%.2f $", balance);
    }

    public String getBalanceNegativeAccounts() {
        double balance = 0;
        for (Account account : accounts) {
            if (account.getBalance() < 0) {
                balance += account.getBalance();
            }

        }
        return String.format("%.2f $", balance);
    }

    public void sortByBalance() {
        accounts.sort(Comparator.comparing(Account::getBalance));
    }

    public Account getAccount(long id) {
        for (Account client : accounts) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }

    public void blockAccaunt(long id) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                account.block();
            }
        }
    }

    public void unlockAccaunt(long id) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                account.unlock();
            }
        }
    }

    public String getInformation() {
        String information = "";
        for (Account account : accounts) {
            information += String.format("=== Счет: %-10d\nБаланс: %10.2f $\nСтатус: %s\n", account.getId(), account.getBalance(), account.getStatus());
        }
        return String.format("===| Клиент |===\n%s\n%s", toString(), information);
    }

    @Override
    public String toString() {
        return String.format("%-10s|%-15s| Паспорт: %s", name, surname, passportID);
    }
}
