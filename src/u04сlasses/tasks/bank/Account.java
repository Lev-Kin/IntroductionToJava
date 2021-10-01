package u04сlasses.tasks.bank;

public class Account {
    private static long nextId = 0;
    private long id;
    private double balance;
    private boolean isOpen = true;

    public Account(double balance) {
        this.id = nextId++;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void block() {
        isOpen = false;
    }

    public void unlock() {
        isOpen = true;
    }

    public String getStatus() {
        String status = isOpen ? "Разблокирован" : "Блокирован";
        return String.format("Счет %d %s.", id, status);
    }
}
