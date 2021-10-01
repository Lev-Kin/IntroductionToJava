package u04сlasses.tasks.bank;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Client> clients;

    public Bank() {
        this.clients = new ArrayList<>();
    }

    public void addNewClient(Client client) {
        clients.add(client);
    }

    public Client getClient(String passportID) {
        for (Client client : clients) {
            if (client.getPassportID().equals(passportID)) {
                return client;
            }
        }
        return null;
    }

    public void print() {
        System.out.println(clients.toString());
    }

    @Override
    public String toString() {
        return String.format("Банк начитывает %d клиентов.\n", clients.size());
    }
}
