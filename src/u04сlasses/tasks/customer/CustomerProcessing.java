package u04сlasses.tasks.customer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class CustomerProcessing {

    private Customer[] customers;

    public CustomerProcessing(Customer[] customers) {
        this.customers = customers;
    }

    public void print(Customer[] customers) {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public void sortCustomersAlphabetic(Customer[] customers) {
        Arrays.sort(customers, Comparator.comparing(Customer::getSurname)
                .thenComparing(Customer::getName)
                .thenComparing(Customer::getPatronymic));
    }

    public void printByCreditCardNumber(long start, long end) {
        Stream.of(customers).
                filter(customer -> customer.getCreditCardNumber() >= start &&
                        customer.getCreditCardNumber() <= end).
                forEach(System.out::println);
    }
}