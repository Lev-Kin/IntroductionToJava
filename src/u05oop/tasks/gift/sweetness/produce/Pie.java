package u05oop.tasks.gift.sweetness.produce;

import u05oop.tasks.gift.sweetness.Sweetness;

public class Pie implements Sweetness {
    private String name;
    private double price;

    public Pie(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Pie{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
