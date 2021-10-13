package u05oop.tasks.cave.treasure;

public class Treasure {
    private TreasureName name;
    private TreasureType type;
    private double price;

    public Treasure() {
        this.name = TreasureName.getRandomName();
        this.type = TreasureType.getRandomType();
        this.price = Math.round((Math.random() * 200) * 100.0) / 100.0;
    }

    public Treasure(TreasureName name, TreasureType type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public TreasureName getName() {
        return name;
    }

    public void setName(TreasureName name) {
        this.name = name;
    }

    public TreasureType getType() {
        return type;
    }

    public void setType(TreasureType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%10s", type) +
                " - " + String.format("%-15s", name) +
                " Rating: " + String.format("%7.2f", price) + " \u25A0";
    }

}
